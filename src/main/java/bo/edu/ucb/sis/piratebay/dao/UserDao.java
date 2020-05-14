package bo.edu.ucb.sis.piratebay.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer findUserIdByUsernameAndPassword(String username , String password){
        String query ="SELECT user_id FROM \"user\" WHERE username = ? AND password = ?";
        Integer user_id=null;
        try{
            user_id=jdbcTemplate.queryForObject(query,new Object[]{username,password},Integer.class);
        }catch (Exception e){
            //do nothing
        }
        return user_id;
    }
}
