package Customer.repository;

public interface CustomerDAO {
    public void addCustomer(Customer customer);
    public Customer getCustomerById(int id);
}
