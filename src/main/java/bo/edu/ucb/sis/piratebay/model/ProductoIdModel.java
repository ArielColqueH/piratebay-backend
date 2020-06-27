package bo.edu.ucb.sis.piratebay.model;

public class ProductoIdModel {
    Integer orderId;

    public ProductoIdModel() {
    }

    public ProductoIdModel(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "ProductoIdModel{" +
                "orderId=" + orderId +
                '}';
    }
}
