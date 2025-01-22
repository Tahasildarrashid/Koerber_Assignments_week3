package Customer.repository.implementation;

import Customer.exceptions.DatabaseException;
import Customer.factory.ConnectionFactory;
import Customer.repository.Customer;
import Customer.repository.CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class CustomerDAOImplementation implements CustomerDAO {

    private Connection connection;

    public CustomerDAOImplementation(){
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addCustomer(Customer customer) {
        try{
            connection= ConnectionFactory.getConnection();
            PreparedStatement preparedStatement=connection
                    .prepareStatement("insert into customerdetails(id, name, address, phone_number) values(?,?,?,?)");

            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getPhone_number());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new DatabaseException("Error while adding customer with ID " + customer.getId(), e);
        }
        finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from customerdetails where id=?");

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"),
                        rs.getString("phone_number"));
            } else {
                throw new DatabaseException("Customer with ID: " + id + " not found.");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error while retrieving customer with ID: " + id, e);
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return customer;
    }
}
