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

    public List<CantidadProductoModel> findAllCantidades(Integer orderId){
        String query ="SELECT\n" +
                "    prod.product_id,prod.product_qqt\n" +
                "FROM\n" +
                "    \"order\" ord\n" +
                "        JOIN product_order proord ON proord.order_id = ord.order_id\n" +
                "        JOIN product prod ON prod.product_id = proord.product_id\n" +
                "WHERE ord.order_id = ?";

        List<CantidadProductoModel> resultado=null;
        try{
            resultado = jdbcTemplate.query(query, new Object[]{orderId},new RowMapper<CantidadProductoModel>(){
                public CantidadProductoModel mapRow(ResultSet restulSet, int i) throws SQLException {
                    return new CantidadProductoModel(restulSet.getInt(1),restulSet.getInt(2));
                }
            });
        }catch (Exception e){
            //do nothing
            throw new RuntimeException();
        }
        return resultado;
    }
}
