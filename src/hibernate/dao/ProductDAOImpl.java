package hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.entity.Product;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{
    @Autowired
    private SessionFactory sessionFactory;

//    @Override
//    public List<Product> getCustomerProduct() {
//        return null;
//    }

    @Override
    public List<Product> getProduct() {
        return null;
    }

    @Override
    public void saveProduct(Product aProduct) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(aProduct);
    }

    @Override
    public Product getProduct(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Product.class, theId);
    }

    @Override
    public void deleteProduct(int theId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Product where id = :doomedProductId");

        query.setParameter("doomedProductId", theId);

        query.executeUpdate();
    }

    @Override
    public List<Product> getProductByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        Query<Product> query = session.createQuery("from Product where lower(name) like :searchTerm");

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        query.setParameter("searchTerm", theSearchTerm);

        return query.getResultList();
    }

}
