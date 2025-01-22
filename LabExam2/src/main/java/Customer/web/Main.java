package Customer.web;

import Customer.repository.Customer;
import Customer.service.CustomerService;
import Customer.service.CustomerServiceImplementation;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImplementation();
        customerService.addCustomer(new Customer(2, "rohit", "HSR Layput", "1234567890"));

        customerService.addCustomer(new Customer(3, "rajeev", "YPR", "1234567890"));
        System.out.println();
        Customer c = new Customer();
        Customer customer = customerService.getCustomerById(3);
        customer.print(customer);


    }
}
