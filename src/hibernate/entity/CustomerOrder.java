package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CustomerOrder")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_ID")
    private int id;
    @Column(name = "Customer_ID")
    private int Customerid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Order_ID")
    private List<ProductOrder> productOrder;

    public List<ProductOrder> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(List<ProductOrder> productOrder) {
        this.productOrder = productOrder;
    }
    public void add(ProductOrder tempOrder) {
        if (productOrder == null) {
            productOrder = new ArrayList<>();
        }
        productOrder.add(tempOrder);
    }

    public CustomerOrder(int customerid) {
        Customerid = customerid;
    }

    public CustomerOrder() {
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", Customerid=" + Customerid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerid() {
        return Customerid;
    }

    public void setCustomerid(int customerid) {
        Customerid = customerid;
    }
}
