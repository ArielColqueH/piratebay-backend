package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.UserDao;
import bo.edu.ucb.sis.piratebay.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBl {
    private UserDao userDao;
    //private UserModel userModel;
    @Autowired
    public UserBl (UserDao userDao) {
        this.userDao=userDao;
    }

    public List<UserModel> findAllActives(){
        return this.userDao.findAllActives();
    }

//    public UserModel insertUserActivesBI(){
//        return this.userDao.insertUserActiveDao(userModel);
//    }


}
