package bo.edu.ucb.sis.piratebay.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CambiarEstadoDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public CambiarEstadoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer cambiarEstadoPedido(Integer estado,Integer orderId){
        String query ="UPDATE \"order\" ord\n" +
                "SET status = ?\n" +
                "WHERE ord.order_id = ?";
        Integer resultado=null;
        try{
            resultado=jdbcTemplate.update(query,new Object[]{estado,orderId});
            System.out.println("estado:"+resultado);
        }catch (Exception e){
            //do nothing
            throw new RuntimeException();
        }
        return resultado;
    }
}
