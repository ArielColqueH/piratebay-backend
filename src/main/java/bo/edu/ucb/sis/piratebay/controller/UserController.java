package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.UserBl;
import bo.edu.ucb.sis.piratebay.model.UserModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/user")

public class UserController {
    private UserBl userBl;
    @Value("${piratebay.security.tokenJwt}")
    private String secretJWT;

    @Autowired
    public UserController (UserBl userBl){
        this.userBl=userBl;
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<UserModel>> findAllACtives(@RequestHeader("Authorization") String authorization){ //bearer token
        //decodificar el token
        String tokenJwt =authorization.substring(7);
        System.out.println("Token JWT :"+tokenJwt);
        DecodedJWT decodeJWT = JWT.decode(tokenJwt);
        String idUsuario = decodeJWT.getSubject();
        System.out.println("ID USUARIO :" + idUsuario);
        //System.out.println("Claim type :" +decodeJWT.getClaim("type").asString());
        if(!"AUTHN".equals(decodeJWT.getClaim("type").asString())){
            throw new RuntimeException("El token proporcionado no es de autenticacion");
        }
        //valida el token bueno y elde autencticacion
        Algorithm algorithm = Algorithm.HMAC256(secretJWT);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("Piratebay").build();
        verifier.verify(tokenJwt);
        System.out.println("obteniendo lista de usuarios");
        return new ResponseEntity<>(this.userBl.findAllActives(), HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
//    public ResponseEntity<UserModel> insertUser(@RequestHeader("Authorization") String authorization){ //bearer token
//        //decodificar el token
//        String tokenJwt =authorization.substring(7);
//        System.out.println("Token JWT :"+tokenJwt);
//        DecodedJWT decodeJWT = JWT.decode(tokenJwt);
//        String idUsuario = decodeJWT.getSubject();
//        System.out.println("ID USUARIO :" + idUsuario);
//        //System.out.println("Claim type :" +decodeJWT.getClaim("type").asString());
//        if(!"AUTHN".equals(decodeJWT.getClaim("type").asString())){
//            throw new RuntimeException("El token proporcionado no es de autenticacion");
//        }
//        //valida el token bueno y elde autencticacion
//        Algorithm algorithm = Algorithm.HMAC256(secretJWT);
//        JWTVerifier verifier = JWT.require(algorithm).withIssuer("Piratebay").build();
//        verifier.verify(tokenJwt);
//
//        return new ResponseEntity<>(this.userBl.insertUserActivesBI(), HttpStatus.OK);
//    }
}
