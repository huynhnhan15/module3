package repository;


import model.Customer;
import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAllCustomers();
}