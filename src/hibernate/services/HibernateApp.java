package hibernate.services;

import hibernate.entity.Customer;
import hibernate.entity.CustomerOrder;
import hibernate.entity.Product;
import hibernate.entity.ProductOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(CustomerOrder.class)
                .addAnnotatedClass(ProductOrder.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        HibernateApp hibernate = new HibernateApp();

        try {
            hibernate.readProduct(1);
        } finally {
            hibernate.close();
        }
    }

    private void createCustomerAndOrder() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Customer customer = new Customer("Kyle Duehr", 30, "Ottermonk@gmail.com");
        session.save(customer);

        CustomerOrder order = new CustomerOrder(2);
        customer.add(order);
        session.save(order);

        session.getTransaction().commit();
    }

    private void readProduct(int product_id) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Product aProduct = session.get(Product.class, product_id);

        if (aProduct == null){
            System.out.println("No Product found for ID " + product_id);
        } else {
            System.out.println(aProduct);
        }

        session.getTransaction().commit();
    }

    private void readCustomer(int customer_id) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Customer aCustomer = session.get(Customer.class, customer_id);

        if (aCustomer == null){
            System.out.println("No Customer found for ID " + customer_id);
        } else {
            System.out.println(aCustomer);
        }

        session.getTransaction().commit();
    }


    private void createProducts(int product_id) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Product stuff1 = new Product("Metroid Drawing", 22);
        Product stuff2 = new Product("Metorid Arm Cannon Replica", 60);
        Product stuff3 = new Product("Metroid Mug", 15);
        session.save(stuff1);
        session.save(stuff2);
        session.save(stuff3);

        session.getTransaction().commit();
    }

    private void createCustomers(int customer_id) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Customer stuff1 = new Customer("Bobby Hill", 16, "123@fake.com");
        Customer stuff2 = new Customer("Hank Hill", 34, "456@fake.com");
        Customer stuff3 = new Customer("Rick Dangerfield", 22, "Awesome@Danger.com");

        session.save(stuff1);
        session.save(stuff2);
        session.save(stuff3);

        session.getTransaction().commit();
    }

    private void listExpensiveProduct() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        List<Product> list = session.createQuery("from Product where cost < 50 order by Product_NM desc").getResultList();

        printProductList(list);

        session.getTransaction().commit();
    }

    private void printProductList(@NotNull List<Product> list) {
        if (list.isEmpty()) {
            System.out.println("No Products in list");
        } else {
            for (Product aProduct : list) {
                System.out.println(aProduct);
            }
        }
    }

    private void createOrderForCustomer() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Customer newCustomer = new Customer("Pineapple", 30, "pineapple@yahoo.com");
        CustomerOrder newOrder = new CustomerOrder(15);
        ProductOrder newPOrder = new ProductOrder(2, 3);

        newOrder.add(newPOrder);
        newCustomer.add(newOrder);
        session.save(newCustomer);

        session.getTransaction().commit();
    }

    private void updateAllProducts() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        session.createQuery("update Product set cost = cost - 1").executeUpdate();

        session.getTransaction().commit();
    }

    private void deleteCustomerTen() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        session.createQuery("delete from Customer where Customer_ID = 10").executeUpdate();

        session.getTransaction().commit();
    }

    private void deleteOverpricedProduct() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        session.createQuery("delete from Product where cost > 100").executeUpdate();

        session.getTransaction().commit();
    }



    private void close() {
        factory.close();
    }
}
