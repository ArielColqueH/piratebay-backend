package bo.edu.ucb.sis.piratebay.controller;
import bo.edu.ucb.sis.piratebay.bl.OrderBl;
import bo.edu.ucb.sis.piratebay.model.EstadoOrderIdModel;
import bo.edu.ucb.sis.piratebay.model.OrderModel;
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
@RequestMapping("/api/v1/orders")
public class OrderController {
    private OrderBl orderBl;
    @Value("${piratebay.security.tokenJwt}")
    private String secretJWT;

    @Autowired
    public OrderController(OrderBl orderBl){
        this.orderBl=orderBl;
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<OrderModel>> findAllOrdersActive(@RequestHeader("Authorization") String authorization,@RequestBody Integer ordId){ //bearer token
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
        System.out.println("obteniendo lista de ordenes");
        return new ResponseEntity<>(this.orderBl.findAllOrders(ordId), HttpStatus.OK);
    }
}
