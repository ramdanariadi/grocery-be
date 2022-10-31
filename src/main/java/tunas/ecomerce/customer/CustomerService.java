package tunas.ecomerce.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.exception.ApiRequestException;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomer(UUID id){
        return customerRepository.findCustomersById(id);
    }

    public List<CustomerRepository.ICustomer> getCustomers(){
        return customerRepository.findAllCustomers();
    }

    public void saveCustomer(Customer customer){
        if(customer.getName() == null || customer.getName().trim().equals(""))
            throw new ApiRequestException("Customer name cannot be null", HttpStatus.PRECONDITION_FAILED);
        customerRepository.save(customer);
    }

}
