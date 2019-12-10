package hibernate.services;

import hibernate.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomer();

    void saveCustomer(Customer aCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);

    List<Customer> getCustomerByName(String theSearchTerm);
}
