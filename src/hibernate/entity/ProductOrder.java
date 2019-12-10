package hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ProductOrder")
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lineItemID")
    private int lineItemID;
    @Column(name = "Order_ID")
    private int Orderid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Product_Id")
    private Product productid;
    @Column(name = "Quantity")
    private int quantity;

    public ProductOrder(int orderid, int quantity) {
        Orderid = orderid;
        this.quantity = quantity;
    }

    public ProductOrder() {
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "Orderid=" + Orderid +
                ", Productid=" + productid +
                ", quantity=" + quantity +
                '}';
    }

    public int getLineItemID() {
        return lineItemID;
    }

    public void setLineItemID(int lineItemID) {
        this.lineItemID = lineItemID;
    }

    public int getOrderid() {
        return Orderid;
    }

    public void setOrderid(int orderid) {
        Orderid = orderid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
