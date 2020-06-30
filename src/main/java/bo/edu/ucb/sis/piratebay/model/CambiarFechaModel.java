package bo.edu.ucb.sis.piratebay.model;

import java.sql.Timestamp;

public class CambiarFechaModel {
    Integer order_id;
    Integer estado_producto;

    public CambiarFechaModel() {
    }

    public CambiarFechaModel(Integer order_id, Integer estado_producto) {
        this.order_id = order_id;
        this.estado_producto = estado_producto;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(Integer estado_producto) {
        this.estado_producto = estado_producto;
    }

    @Override
    public String toString() {
        return "CambiarFechaModel{" +
                "order_id=" + order_id +
                ", estado_producto=" + estado_producto +
                '}';
    }
}
