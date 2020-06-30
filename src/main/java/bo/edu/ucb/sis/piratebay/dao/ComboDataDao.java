package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.OrderModel;
import bo.edu.ucb.sis.piratebay.model.OrderTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ComboDataDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public ComboDataDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Integer> findAllGivenOrders(Integer orderId){
        String query ="SELECT\n" +
                "    proord.qtty_given\n" +
                "FROM\n" +
                "        \"order\" ord\n" +
                "        JOIN product_order proord ON proord.order_id = ord.order_id\n" +
                "WHERE ord.order_id=?\n" +
                "ORDER BY proord.order_id";

        List<Integer> resultado=null;
        try{
            resultado = jdbcTemplate.query(query,new Object[]{orderId},new RowMapper<Integer>(){
                public Integer mapRow(ResultSet restulSet, int i) throws SQLException{
                    return new Integer(restulSet.getInt(1));
                }
            });
        }catch (Exception e){
            //do nothing
            throw new RuntimeException();
        }
        return resultado;
    }
}
