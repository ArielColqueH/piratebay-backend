package bo.edu.ucb.sis.piratebay.model;

public class CantidadProductoModel {
    Integer producto_id;

    public CantidadProductoModel(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public CantidadProductoModel() {
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    @Override
    public String toString() {
        return "CantidadProductoModel{" +
                "producto_id=" + producto_id +
                '}';
    }
}
