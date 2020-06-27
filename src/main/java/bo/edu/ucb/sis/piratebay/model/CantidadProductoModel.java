package bo.edu.ucb.sis.piratebay.model;

public class CantidadProductoModel {
    Integer producto_id;
    Integer producto_cantidad;

    public CantidadProductoModel() {
    }

    public CantidadProductoModel(Integer producto_id, Integer producto_cantidad) {
        this.producto_id = producto_id;
        this.producto_cantidad = producto_cantidad;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public Integer getProducto_cantidad() {
        return producto_cantidad;
    }

    public void setProducto_cantidad(Integer producto_cantidad) {
        this.producto_cantidad = producto_cantidad;
    }

    @Override
    public String toString() {
        return "CantidadProductoModel{" +
                "producto_id=" + producto_id +
                ", producto_cantidad=" + producto_cantidad +
                '}';
    }
}
