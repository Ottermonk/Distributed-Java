package hibernate.services;

import hibernate.dao.CustomerDAO;
import hibernate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
@Autowired CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomer() {
        return customerDAO.getCustomer();
    }

    @Transactional
    @Override
    public void saveCustomer(Customer aCustomer) {
        customerDAO.saveCustomer(aCustomer);
    }

    @Transactional
    @Override
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }

    @Transactional
    @Override
    public void deleteCustomer(int theId) {
        customerDAO.deleteCustomer(theId);
    }

    @Transactional
    @Override
    public List<Customer> getCustomerByName(String theSearchTerm) {
        return customerDAO.getCustomerByName(theSearchTerm);
    }
}
