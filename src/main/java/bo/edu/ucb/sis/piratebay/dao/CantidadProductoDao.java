package bo.edu.ucb.sis.piratebay.dao;
import bo.edu.ucb.sis.piratebay.model.CantidadProductoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class CantidadProductoDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public CantidadProductoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer findAllCantidades(Integer orderId){
        String query ="SELECT\n" +
                "    prod.product_qqt\n" +
                "FROM\n" +
                "     product prod\n" +
                "WHERE prod.product_id = ?";

        Integer resultado=null;
        try{
            resultado = jdbcTemplate.queryForObject(query,new Object[]{orderId},Integer.class);
        }catch (Exception e){
            //do nothing
            throw new RuntimeException();
        }
        return resultado;
    }
}
