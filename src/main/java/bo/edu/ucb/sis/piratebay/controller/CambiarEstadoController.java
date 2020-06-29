package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.CambiarEstadoBl;
import bo.edu.ucb.sis.piratebay.model.CambiarEstadoModel;
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

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/cambiarEstado")
public class CambiarEstadoController {
    private CambiarEstadoBl cambiarEstadoBl;
    @Value("${piratebay.security.tokenJwt}")
    private String secretJWT;

    @Autowired
    public CambiarEstadoController(CambiarEstadoBl cambiarEstadoBl){
        this.cambiarEstadoBl=cambiarEstadoBl;
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Integer> findAllCantidadProductos(@RequestHeader("Authorization") String authorization, @RequestBody CambiarEstadoModel order){
        //bearer token
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
        System.out.println("cambiando de estado");
        return new ResponseEntity<>(this.cambiarEstadoBl.cambiarEstadoPedido(order.getOrder_estado(),order.getOrder_id()), HttpStatus.OK);
    }
}
