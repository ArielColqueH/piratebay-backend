package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.UserDao;
import bo.edu.ucb.sis.piratebay.model.TokenRefreshModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

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

    public Map<String,String> authenticate(String username , String password){
        Map<String,String> result= new HashMap();
        String sha256hex = Hashing.sha256()
                .hashString(password+salt, StandardCharsets.UTF_8)
                .toString();//TODO repetir el algoritmo de hash N veces
        Integer userId = userDao.findUserIdByUsernameAndPassword(username,sha256hex);
        if(userId!=null){
            result.put("authentication", generateJWT(userId,2,"AUTHN"));
            result.put("refresh", generateJWT(userId,6,"REFRESH"));
            return result;

        }
        else{
            return null;
        }
    }


    public Map<String,String> refresh(TokenRefreshModel refresToken){

        //decodificar el token
        String tokenJwt =refresToken.getRefreshToken();
        System.out.println("Token JWT :"+tokenJwt);
        DecodedJWT decodeJWT = JWT.decode(tokenJwt);
        String idUsuario = decodeJWT.getSubject();
        //System.out.println("Claim type :" +decodeJWT.getClaim("type").asString());
        if(!"REFRESH".equals(decodeJWT.getClaim("type").asString())){
            throw new RuntimeException("El token proporcionado no es un token valido para refresh ");
        }
        //valida el token bueno y elde autencticacion
        Algorithm algorithm = Algorithm.HMAC256(secretJWT);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("Piratebay").build();
        verifier.verify(tokenJwt);



        Map<String,String> result= new HashMap();


            result.put("authentication", generateJWT(Integer.parseInt(idUsuario),2,"AUTHN"));
            result.put("refresh", generateJWT(Integer.parseInt(idUsuario),6,"REFRESH"));
            return result;
    }


    private String generateJWT(Integer userId,int minutes,String type){

        LocalDateTime expiresAt = LocalDateTime.now(ZoneId.systemDefault()).plusMinutes(minutes);
        String token=null;

        try{
            Algorithm algorithm = Algorithm.HMAC256(secretJWT);
            token = JWT.create().withIssuer("Piratebay")
                    .withClaim("type",type)
                    .withSubject(userId.toString())
                    .withExpiresAt(Date.from(expiresAt.atZone(ZoneId.systemDefault()).toInstant()))
                    .sign(algorithm);
        }catch (JWTCreationException exception){
            //else
            throw new RuntimeException(exception);
        }
        return token;
    }
}
