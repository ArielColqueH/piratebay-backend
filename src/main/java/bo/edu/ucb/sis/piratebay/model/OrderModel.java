package bo.edu.ucb.sis.piratebay.model;

public class OrderModel {
    private Integer orderId;
    private String username;
    private String fechaPedido;
    private String fechaPago;
    private String nombreProducto;
    private Integer cantidadPedida;
    private String minutos;

    public OrderModel() {
    }

    public OrderModel(Integer orderId, String username, String fechaPedido, String fechaPago, String nombreProducto, int cantidadPedida, String minutos) {
        this.orderId = orderId;
        this.username = username;
        this.fechaPedido = fechaPedido;
        this.fechaPago = fechaPago;
        this.nombreProducto = nombreProducto;
        this.cantidadPedida = cantidadPedida;
        this.minutos = minutos;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
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

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderId=" + orderId +
                ", username='" + username + '\'' +
                ", fechaPedido='" + fechaPedido + '\'' +
                ", fechaPago='" + fechaPago + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", cantidadPedida=" + cantidadPedida +
                ", minutos='" + minutos + '\'' +
                '}';
    }
}








