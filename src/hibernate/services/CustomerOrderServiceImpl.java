
package hibernate.services;

import hibernate.dao.ProductDAO;
import hibernate.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
class ProductServiceImpl implements ProductService{
    @Autowired ProductDAO ProductDAO;

    @Override
    @Transactional
    public List<Product> getProduct() {
        return ProductDAO.getProduct();
    }

    @Transactional
    @Override
    public void saveProduct(Product aProduct) {
        ProductDAO.saveProduct(aProduct);
    }

    @Transactional
    public Product getProduct(int theId) {

        return ProductDAO.getProduct(theId);
    }

    @Transactional
    @Override
    public void deleteProduct(int theId) {

    }

    @Transactional
    @Override
    public List<Product> getProductByName(String theSearchTerm) {
        return ProductDAO.getProductByName(theSearchTerm);
    }
}
