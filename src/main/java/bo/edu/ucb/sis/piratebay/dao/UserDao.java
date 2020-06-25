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
    public UserModel insertUserActiveDao(UserModel aux){
        String query ="INSERT INTO \"user\" (username,email,phone_number,cat_user_status)" +
                " values (aux.username,aux.email,aux.phoneNumber,aux.carUserStatus)";
        UserModel userObject=null;
        return userObject;
    }
    public List<String> findAllFeatureCodeByUserId(int userId) {
        List<String> features = null;
        String query = "SELECT\n" +
                "       DISTINCT fea.feature_code\n" +
                "FROM\n" +
                "    \"user\" usr\n" +
                "    JOIN user_role uro ON usr.user_id = uro.user_id\n" +
                "    JOIN \"role\" rle ON rle.role_id = uro.role_id\n" +
                "    JOIN role_feature rfe ON rfe.role_id = rle.role_id\n" +
                "    JOIN feature fea ON fea.feature_id = rfe.feature_id\n" +
                "WHERE\n" +
                "    usr.user_id = ? \n" +
                "    AND usr.status =  1\n" +
                "    AND uro.status = 1\n" +
                "    AND rle.status = 1\n" +
                "    AND rfe.status = 1\n" +
                "    AND fea.status = 1";
        try {
            features = jdbcTemplate.query(query,
                    new Object[]{userId},
                    new RowMapper<String>() {
                        @Override
                        public String mapRow(ResultSet resultSet, int i) throws SQLException {
                            return resultSet.getString(1);
                        }
                    });
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return features;
    }
}
