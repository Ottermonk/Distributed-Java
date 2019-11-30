package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CustomerOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_ID")
    private int id;
//    @Column(name = "Customer_ID")
//    private int Customerid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<LineItem> lineItems;

//    public Order(int customerid) {
//        Customerid = customerid;
//    }

    public Order() {
    }

    public List<LineItem> getLineItem() {
        return lineItems;
    }

    public void setLineItem(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void add(LineItem tempOrder) {
        if (lineItems == null) {
            lineItems = new ArrayList<>();
        }
        lineItems.add(tempOrder);
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
//                ", Customerid=" + Customerid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getCustomerid() {
//        return Customerid;
//    }
//
//    public void setCustomerid(int customerid) {
//        Customerid = customerid;
//    }
}
