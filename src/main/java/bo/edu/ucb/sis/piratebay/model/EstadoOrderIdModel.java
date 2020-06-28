package bo.edu.ucb.sis.piratebay.model;

public class EstadoOrderIdModel {
    Integer estado;

    public EstadoOrderIdModel() {
    }

    public EstadoOrderIdModel(Integer estado) {
        this.estado = estado;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EstadoOrderIdModel{" +
                "estado=" + estado +
                '}';
    }
}
