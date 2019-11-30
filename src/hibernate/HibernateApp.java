package hibernate;

import hibernate.entity.Customer;
import hibernate.entity.LineItem;
import hibernate.entity.Order;
import hibernate.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(LineItem.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        HibernateApp hibernate = new HibernateApp();

        try {
            Product stuff = hibernate.readProduct(1);
            hibernate.createCustomers();
            hibernate.createProducts();
            hibernate.createOrderForCustomer(stuff, 5);
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

        Order order = new Order();
        customer.add(order);
        session.save(order);

        session.getTransaction().commit();
    }

    private Product readProduct(int product_id) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Product aProduct = session.get(Product.class, product_id);

        if (aProduct == null) {
            System.out.println("No Product found for ID " + product_id);
        } else {
            System.out.println(aProduct);
        }

        session.getTransaction().commit();

        return aProduct;
    }

    private void readCustomer(int customer_id) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Customer aCustomer = session.get(Customer.class, customer_id);

        if (aCustomer == null) {
            System.out.println("No Customer found for ID " + customer_id);
        } else {
            System.out.println(aCustomer);
        }

        session.getTransaction().commit();
    }


    private void createProducts() {
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

    private void createCustomers() {
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

    private void printProductList(List<Product> list) {
        if (list.isEmpty()) {
            System.out.println("No Products in list");
        } else {
            for (Product aProduct : list) {
                System.out.println(aProduct);
            }
        }
    }

    private void createOrderForCustomer(Product product, int quantity) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Customer newCustomer = new Customer("Pineapple", 30, "pineapple@yahoo.com");
        Order newOrder = new Order();
        LineItem newPOrder = new LineItem(product.getId(), quantity);

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
