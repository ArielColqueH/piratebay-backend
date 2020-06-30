package bo.edu.ucb.sis.piratebay.bl;
import bo.edu.ucb.sis.piratebay.dao.CambiarFechaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CambiarFechaBl {
    private CambiarFechaDao cambiarFechaDao;
    @Autowired
    public CambiarFechaBl(CambiarFechaDao cambiarFechaDao) {
        this.cambiarFechaDao=cambiarFechaDao;
    }

    public Integer cambiarFechaPedidoN(Integer orderId,Integer estado){
        return this.cambiarFechaDao.cambiarFechaPedidoNueva(orderId,estado);
    }
}
