package Customer.service;

import Customer.repository.Customer;

public interface CustomerService {
    public void addCustomer(Customer customer);
    public Customer getCustomerById(int id);
}
