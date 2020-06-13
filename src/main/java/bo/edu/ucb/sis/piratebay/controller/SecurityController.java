package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.SecurityBl;
import bo.edu.ucb.sis.piratebay.model.CredentialModel;
import bo.edu.ucb.sis.piratebay.model.TokenRefreshModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/security")

public class SecurityController {
    private SecurityBl securityBl;

    @Value("${piratebay.security.tokenJwt}")
    private String secretJWT;
    @Autowired
    public SecurityController(SecurityBl securityBl) {
        this.securityBl = securityBl;
    }
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,  consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Map<String, Object>> authenticate(@RequestBody CredentialModel credentialModel) {
        Map<String,String> tokens =securityBl.authenticate(credentialModel.getUsername(),credentialModel.getPassword());
        if( tokens!=null ) {
            Map <String, Object> response = new HashMap();
            response.put("message", "Authentication OK");
            response.put("authentication ",tokens.get("authentication"));
            response.put("refresh ",tokens.get("refresh"));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map <String, Object> response = new HashMap();
            response.put("message", "User or password invalid"+"username : "+credentialModel.getUsername()+"| password: "+credentialModel.getPassword());
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
    }
    @RequestMapping(value = "refresh", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,  consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Map<String, Object>> authenticate(@RequestBody TokenRefreshModel tokenRefreshModel) {
        Map<String,String> tokens = securityBl.refresh(tokenRefreshModel);
            Map <String, Object> response = new HashMap();
            response.put("message", "Authentication OK");
            response.put("authentication ",tokens.get("authentication"));
            response.put("refresh ",tokens.get("refresh"));
            return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
