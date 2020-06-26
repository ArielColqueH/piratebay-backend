package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class OrderDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OrderModel> findAllOrders(){
        String query ="SELECT\n" +
                "    ord.order_id,usr.username,ord.date,ord.payday,prod.product_name,proord.qtty_requested,att.attr_value\n" +
                "FROM\n" +
                "    \"user\" usr\n" +
                "        JOIN \"order\" ord ON usr.user_id=ord.user_id\n" +
                "        JOIN product_order proord ON proord.order_id = ord.order_id\n" +
                "        JOIN product prod ON prod.product_id = proord.product_id\n" +
                "        JOIN attribute att ON prod.product_id=att.product_id";

        List<OrderModel> resultado=null;
        try{
            resultado = jdbcTemplate.query(query,new RowMapper<OrderModel>(){
                public OrderModel mapRow(ResultSet restulSet, int i) throws SQLException{
                    return new OrderModel(restulSet.getInt(1),restulSet.getString(2),restulSet.getString(3),restulSet.getString(4),restulSet.getString(5),restulSet.getInt(6),restulSet.getString(7));
                }
            });
        }catch (Exception e){
            //do nothing
            throw new RuntimeException();
        }
        return resultado;
    }

}
