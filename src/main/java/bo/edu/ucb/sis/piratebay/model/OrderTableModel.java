package bo.edu.ucb.sis.piratebay.model;

public class OrderTableModel {
    private Integer orderTableId;
    private String username;
    private String fechaPedido;
    private String fechaPago;
    private String fechaPreparacion;
    private String fechaPreparado;
    private Integer status;

    public OrderTableModel() {
    }

    public OrderTableModel(Integer orderTableId, String username, String fechaPedido, String fechaPago, String fechaPreparacion, String fechaPreparado, Integer status) {
        this.orderTableId = orderTableId;
        this.username = username;
        this.fechaPedido = fechaPedido;
        this.fechaPago = fechaPago;
        this.fechaPreparacion = fechaPreparacion;
        this.fechaPreparado = fechaPreparado;
        this.status = status;
    }

    public Integer getOrderTableId() {
        return orderTableId;
    }

    public void setOrderTableId(Integer orderTableId) {
        this.orderTableId = orderTableId;
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

    public String getFechaPreparacion() {
        return fechaPreparacion;
    }

    public void setFechaPreparacion(String fechaPreparacion) {
        this.fechaPreparacion = fechaPreparacion;
    }

    public String getFechaPreparado() {
        return fechaPreparado;
    }

    public void setFechaPreparado(String fechaPreparado) {
        this.fechaPreparado = fechaPreparado;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderTableModel{" +
                "orderTableId=" + orderTableId +
                ", username='" + username + '\'' +
                ", fechaPedido='" + fechaPedido + '\'' +
                ", fechaPago='" + fechaPago + '\'' +
                ", fechaPreparacion='" + fechaPreparacion + '\'' +
                ", fechaPreparado='" + fechaPreparado + '\'' +
                ", status=" + status +
                '}';
    }
}








