package service;
import model.Customer;
import repository.CustomerRepository;

import java.util.List;

public class CustomerService {
    private final CustomerRepository repository = new CustomerRepository();



    public List<Customer> findAll() {
        return repository.findAll();
    }
}

