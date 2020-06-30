package bo.edu.ucb.sis.piratebay.model;

public class ComboboxModel {
    Integer combonumber;
    Integer orderId;
    Integer productId;

    public ComboboxModel() {
    }

    public ComboboxModel(Integer combonumber, Integer orderId, Integer productId) {
        this.combonumber = combonumber;
        this.orderId = orderId;
        this.productId = productId;
    }

    public Integer getCombonumber() {
        return combonumber;
    }

    public void setCombonumber(Integer combonumber) {
        this.combonumber = combonumber;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ComboboxModel{" +
                "combonumber=" + combonumber +
                ", orderId=" + orderId +
                ", productId=" + productId +
                '}';
    }
}
