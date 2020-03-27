package bo.edu.ucb.sis.piratebay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.MetaEventListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private ClientMapper clientMapper;
    @Autowired
    public ClientController(ClientMapper clientMapper){
        this.clientMapper=clientMapper;
    }
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity createClient(@RequestBody ClientDto clientDto) {
        // Verificamos que el fistName no sea nulo o no sea vacio.
        if (clientDto.getFirstName() == null || "".equals(clientDto.getFirstName().trim()) ) {
            Map response = new HashMap();
            response.put("code", 1000);
            response.put("message", "El cliente no tiene primer nombre");
            return new ResponseEntity<Map>(response, HttpStatus.BAD_REQUEST);
        }
        // Verificamos que el lastName no sea nulo o no sea vacio.
        if (clientDto.getLastName() == null || "".equals(clientDto.getLastName().trim())) {
            Map response = new HashMap();
            response.put("code", 1000);
            response.put("message", "El cliente no tiene primer nombre");
            return new ResponseEntity<Map>(response, HttpStatus.BAD_REQUEST);
        }
        clientMapper.create(clientDto);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity listClient() {
        return new ResponseEntity<>(clientMapper.listAll(), HttpStatus.OK);
    }

    /**
     * La ruta debería ser /api/v1/clients/123
     * @return
     */
    @RequestMapping(
            path = "/{clientId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity removeClient(@PathVariable("clientId") Integer clientId ) {
        clientMapper.deleteClient(clientId);
        Map response = new HashMap();
        response.put("code", 0);
        response.put("message", "Eliminación correcta");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @RequestMapping(
            path = "/{clientId}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity updateClient(@PathVariable("clientId") Integer clientId,
                                       @RequestBody ClientDto clientDto) {
        // Verificamos que el fistName no sea nulo o no sea vacio.
        if (clientDto.getFirstName() == null || "".equals(clientDto.getFirstName().trim()) ) {
            Map response = new HashMap();
            response.put("code", 1000);
            response.put("message", "El cliente no tiene primer nombre");
            return new ResponseEntity<Map>(response, HttpStatus.BAD_REQUEST);
        }
        // Verificamos que el lastName no sea nulo o no sea vacio.
        if (clientDto.getLastName() == null || "".equals(clientDto.getLastName().trim())) {
            Map response = new HashMap();
            response.put("code", 1000);
            response.put("message", "El cliente no tiene primer nombre");
            return new ResponseEntity<Map>(response, HttpStatus.BAD_REQUEST);
        }
        // Colocamos el ID en el DTO (porque lo usa el mapper) a partir del PathVariable
        clientDto.setClientId(clientId);
        // Invocamos a Base de datos para actualizar cliente.
        clientMapper.updateClient(clientDto);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

}
