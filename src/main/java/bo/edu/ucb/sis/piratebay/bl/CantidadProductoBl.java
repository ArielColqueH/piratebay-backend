package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.CantidadProductoDao;
import bo.edu.ucb.sis.piratebay.model.CantidadProductoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CantidadProductoBl {
    private CantidadProductoDao cantidadProductoDao;

    @Autowired
    public CantidadProductoBl(CantidadProductoDao cantidadProductoDao) {
        this.cantidadProductoDao=cantidadProductoDao;
    }

    public Integer findAllCantidadProducto(Integer orderId){
        return this.cantidadProductoDao.findAllCantidades(orderId);
    }
}
