package bo.edu.ucb.sis.piratebay.model;

public class OrderModel {
    private Integer orderId;
    private Integer productoId;
    private String nombreProducto;
    private Integer cantidadPedida;
    private String minutos;
    private String comentario;

    public OrderModel() {
    }

    public OrderModel(Integer orderId, Integer productoId, String nombreProducto, Integer cantidadPedida, String minutos, String comentario) {
        this.orderId = orderId;
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.cantidadPedida = cantidadPedida;
        this.minutos = minutos;
        this.comentario = comentario;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidadPedida() {
        return cantidadPedida;
    }

    public void setCantidadPedida(Integer cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderId=" + orderId +
                ", productoId=" + productoId +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", cantidadPedida=" + cantidadPedida +
                ", minutos='" + minutos + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}








