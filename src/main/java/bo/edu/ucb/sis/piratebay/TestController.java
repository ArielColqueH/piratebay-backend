package bo.edu.ucb.sis.piratebay;

import org.apache.catalina.connector.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @RequestMapping(method= RequestMethod.GET,produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> helloworld(){
        return new ResponseEntity<String>("hola mundo", HttpStatus.OK);
    }
}
