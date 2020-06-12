package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer findUserIdByUsernameAndPassword(String username , String password){
        String query ="SELECT user_id FROM \"user\" WHERE username = ? AND UPPER(password) = UPPER(?)";
        Integer user_id=null;
        try{
            user_id=jdbcTemplate.queryForObject(query,new Object[]{username,password},Integer.class);
        }catch (Exception e){
            //do nothing
        }
        return user_id;
    }
    public List<UserModel> findAllActives(){
        String query ="SELECT user_id,username,email,phone_number,cat_user_status FROM \"user\" WHERE status=1";

        List<UserModel> resultado=null;
        try{
            resultado = jdbcTemplate.query(query,new RowMapper<UserModel>(){
                public UserModel mapRow(ResultSet restulSet, int i) throws SQLException{
                    return new UserModel(restulSet.getInt(1),restulSet.getString(2),restulSet.getString(3),restulSet.getString(4),restulSet.getString(5));
                }
            });
        }catch (Exception e){
            //do nothing
            throw new RuntimeException();
        }
        return resultado;
    }
}
