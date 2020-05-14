package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityBl {
    private UserDao userDao;

    @Autowired
    public SecurityBl(UserDao userDao) {
        this.userDao = userDao;
    }

    public Integer authenticate(String username , String password){
        return userDao.findUserIdByUsernameAndPassword(username,password);

    }
}
