package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.CambiarFechaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CambiarFechaDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public CambiarFechaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer cambiarFechaPedidoNueva(Integer orderId,Integer estado){
        String query=null;
        if(estado==2){
            query ="UPDATE \"order\" ord\n" +
                    "SET preparationday = CURRENT_TIMESTAMP \n" +
                    "WHERE ord.order_id = ?";
        }else{
            query ="UPDATE \"order\" ord\n" +
                    "SET preparationfinisheday = CURRENT_TIMESTAMP \n" +
                    "WHERE ord.order_id = ?";
        }

        Integer resultado=null;
        try{
            System.out.println("fecha pedido estado :"+resultado);
            resultado=jdbcTemplate.update(query,new Object[]{orderId});

        }catch (Exception e){
            //do nothing
            throw new RuntimeException();
        }
        return resultado;
    }
}
