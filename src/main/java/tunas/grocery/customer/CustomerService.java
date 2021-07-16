package tunas.grocery.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(UUID id){
        return customerRepository.findCustomersById(id);
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAllCustomers();
    }

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

}
