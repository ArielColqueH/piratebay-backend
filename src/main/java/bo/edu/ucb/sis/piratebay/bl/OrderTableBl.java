package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.OrderDao;
import bo.edu.ucb.sis.piratebay.dao.OrderTableDao;
import bo.edu.ucb.sis.piratebay.model.OrderModel;
import bo.edu.ucb.sis.piratebay.model.OrderTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTableBl {
    private OrderTableDao orderTableDao;

    @Autowired
    public OrderTableBl (OrderTableDao orderTableDao) {
        this.orderTableDao=orderTableDao;
    }

    public List<OrderTableModel> findAllOrdersTable(Integer estado){
        return this.orderTableDao.findAllOrdersTable(estado);
    }
}
