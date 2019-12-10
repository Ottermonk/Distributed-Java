package hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.entity.Customer;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomer() {
        Session session = sessionFactory.getCurrentSession();

        List<Customer> list = session.createQuery("from Customer", Customer.class).getResultList();

        return list;
    }

    @Override
    public void saveCustomer(Customer aCustomer) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(aCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Customer.class, theId);
    }

    @Override
    public void deleteCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Customer where id = :doomedCustomerId");

        query.setParameter("doomedCustomerId", theId);

        query.executeUpdate();
    }

    @Override
    public List<Customer> getCustomerByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer where lower(name) like :searchTerm");

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        query.setParameter("searchTerm", theSearchTerm);

        return query.getResultList();
    }

}