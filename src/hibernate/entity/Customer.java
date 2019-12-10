package hibernate.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")

public class Customer {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Customer_ID")
    private List<CustomerOrder> customerOrders;

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public void add(CustomerOrder tempOrder) {
        if (customerOrders == null) {
            customerOrders = new ArrayList<>();
        }
        customerOrders.add(tempOrder);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_ID")
    private int id;
    @NotNull(message = "required")
    @Size(min = 1, max = 30, message = "1-30 characters")
    @Column(name = "Customer_NM")
    private String name;
    @NotNull(message = "required")
    @Min(value = 1, message = "greater than 0")
    @Column(name = "Age")
    private Integer age;
    @NotNull(message = "required")
    @Size(min = 1, max = 30, message = "1-30 characters")
    @Column (name = "Email")
    private String email;

    public Customer(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
