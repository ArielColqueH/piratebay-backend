package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.ComboDataDao;
import bo.edu.ucb.sis.piratebay.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComboDataBl {
    private ComboDataDao comboDataDao;

    @Autowired
    public ComboDataBl (ComboDataDao comboDataDao) {
        this.comboDataDao=comboDataDao;
    }

    public List<Integer> findAllGiven(Integer orderId){
        return this.comboDataDao.findAllGivenOrders(orderId);
    }
}
