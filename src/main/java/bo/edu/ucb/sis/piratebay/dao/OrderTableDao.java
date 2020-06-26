package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.OrderTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class OrderTableDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public OrderTableDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OrderTableModel> findAllOrdersTable(){
        String query ="SELECT\n" +
                "    ord.order_id,usr.username,ord.date,ord.payday,ord.preparationday,ord.preparationfinisheday\n" +
                "FROM\n" +
                "    \"user\" usr\n" +
                "        JOIN \"order\" ord ON usr.user_id=ord.user_id\n" +
                "        JOIN product_order proord ON proord.order_id = ord.order_id\n" +
                "        JOIN product prod ON prod.product_id = proord.product_id\n" +
                "GROUP BY  ord.order_id,usr.username,ord.date,ord.payday";

        List<OrderTableModel> resultado=null;
        try{
            resultado = jdbcTemplate.query(query,new RowMapper<OrderTableModel>(){
                public OrderTableModel mapRow(ResultSet restulSet, int i) throws SQLException {
                    return new OrderTableModel(restulSet.getInt(1),restulSet.getString(2),restulSet.getString(3),restulSet.getString(4),restulSet.getString(5),restulSet.getString(6));
                }
            });
        }catch (Exception e){
            //do nothing
            throw new RuntimeException();
        }
        return resultado;
    }

}