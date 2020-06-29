package bo.edu.ucb.sis.piratebay.bl;
import bo.edu.ucb.sis.piratebay.dao.CambiarEstadoDao;
import bo.edu.ucb.sis.piratebay.dao.CantidadProductoDao;
import bo.edu.ucb.sis.piratebay.model.CambiarEstadoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CambiarEstadoBl {
    private CambiarEstadoDao cambiarEstadoDao;

    @Autowired
    public CambiarEstadoBl(CambiarEstadoDao cambiarEstadoDao) {
        this.cambiarEstadoDao=cambiarEstadoDao;
    }

    public Integer cambiarEstadoPedido(Integer estadoPedido,Integer orderId){
        return this.cambiarEstadoDao.cambiarEstadoPedido(estadoPedido,orderId);
    }
}
