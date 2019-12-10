package hibernate.services;

import hibernate.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProduct();

    void saveProduct(Product aProduct);

    Product getProduct(int theId);

    void deleteProduct(int theId);

    List<Product> getProductByName(String theSearchTerm);

}