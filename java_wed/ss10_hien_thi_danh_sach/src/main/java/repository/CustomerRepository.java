package repository;


import model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static final List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Hynh Nhan", LocalDate.of(2003, 5, 10), "Hanoi", "images/customer1.jpg"));
        customers.add(new Customer(2, "Tran Thinh", LocalDate.of(1985, 8, 22), "Saigon", "images/customer1.jpg"));
        customers.add(new Customer(3, "Le Van ", LocalDate.of(1992, 11, 15), "Danang", "images/customer1.jpg"));
    }

    public List<Customer> findAll() {
        return customers;
    }
}