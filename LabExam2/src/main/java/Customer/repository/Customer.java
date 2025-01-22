package Customer.repository;

public class Customer {
    private int id;
    private String name;
    private String address;
    private String phone_number;

    public Customer() {
    }

    public void print(Customer customer)
    {
        System.out.println("Customer id " + customer.getId());
        System.out.println("Customer name " + customer.getName());
        System.out.println("Customer address " + customer.getAddress());
        System.out.println("Customer phone_number " + customer.getPhone_number());
    }

    public Customer(int id, String name, String address, String phone_number) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

}
