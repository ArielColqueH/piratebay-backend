package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.UserDao;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class SecurityBl {
    private UserDao userDao;
    @Value("${piratebay.security.salt}")
    private String salt;
    @Value("${piratebay.security.tokenJwt}")
    private String secretJWT;

    @Autowired
    public SecurityBl(UserDao userDao) {
        this.userDao = userDao;
    }
    /**
     *Este metodo recibe el usuario y password en plano , consulta a la base de datos enviando el paswoord con sha256 + salt
     * y si  esta bien genera el token JWT
     *
     */

    public String authenticate(String username , String password){

        String sha256hex = Hashing.sha256()
                .hashString(password+salt, StandardCharsets.UTF_8)
                .toString();//TODO repetir el algoritmo de hash N veces
        Integer userId = userDao.findUserIdByUsernameAndPassword(username,sha256hex);
        if(userId!=null){
            return generateJWT(userId);
        }
        else{
            return null;
        }
    }
    private String generateJWT(Integer userId){

        LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(2);
        String token=null;

        try{
            Algorithm algorithm = Algorithm.HMAC256(secretJWT);
            token = JWT.create().withIssuer("Piratebay").withSubject(userId.toString()).withExpiresAt(Date.from(expiresAt.toInstant(ZoneOffset.of("+04:00")))).sign(algorithm);
        }catch (JWTCreationException exception){
            //else
            throw new RuntimeException(exception);
        }
        return token;
    }
}
