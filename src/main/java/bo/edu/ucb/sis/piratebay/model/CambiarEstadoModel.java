package bo.edu.ucb.sis.piratebay.model;

public class CambiarEstadoModel {
    Integer order_id;
    Integer order_estado;

    public CambiarEstadoModel() {
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getOrder_estado() {
        return order_estado;
    }

    public void setOrder_estado(Integer order_estado) {
        this.order_estado = order_estado;
    }

    @Override
    public String toString() {
        return "CambiarEstadoModel{" +
                "order_id=" + order_id +
                ", order_estado=" + order_estado +
                '}';
    }
}
