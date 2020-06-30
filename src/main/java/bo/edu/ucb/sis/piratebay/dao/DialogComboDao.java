package bo.edu.ucb.sis.piratebay.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class DialogComboDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public DialogComboDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer updateCombo(Integer combodata,Integer orderId,Integer productId){
        String query="UPDATE product_order\n" +
                "SET qtty_given = ?\n" +
                "WHERE order_id = ? and product_id=?";
        Integer resultado=null;
        try{
            System.out.println("dato combo agregado :"+resultado);
            resultado=jdbcTemplate.update(query,new Object[]{combodata,orderId,productId});
        }catch (Exception e){
            //do nothing
            throw new RuntimeException();
        }
        return resultado;
    }
}
