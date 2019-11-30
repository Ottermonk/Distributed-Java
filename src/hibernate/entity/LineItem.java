package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "lineitem")
public class LineItem {
    @Id
    @Column(name = "lineitem_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lineItemId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "quantity")
    private int quantity;

    public LineItem() {
    }

    public LineItem(int productId, int quantity) {
//        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(int lineItemId) {
        this.lineItemId = lineItemId;
    }

//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "lineItemId=" + lineItemId +
//                ", orderId=" + orderId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
