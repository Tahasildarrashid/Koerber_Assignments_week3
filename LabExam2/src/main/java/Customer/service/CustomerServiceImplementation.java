package Customer.service;

import Customer.repository.Customer;
import Customer.repository.CustomerDAO;
import Customer.repository.implementation.CustomerDAOImplementation;

public class CustomerServiceImplementation implements CustomerService{

    private CustomerDAO customerDAO = new CustomerDAOImplementation();
    @Override
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }
}
