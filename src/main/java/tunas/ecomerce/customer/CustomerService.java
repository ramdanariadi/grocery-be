package tunas.ecomerce.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.cutomresponse.ApiRequestException;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(UUID id){
        return customerRepository.findCustomersById(id);
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAllCustomers();
    }

    public void saveCustomer(Customer customer){
        if(customer.getName() == null || customer.getName().trim().equals(""))
            throw new ApiRequestException("Customer name cannot be null", HttpStatus.PRECONDITION_FAILED);
        customerRepository.save(customer);
    }

}
