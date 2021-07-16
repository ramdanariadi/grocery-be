package tunas.grocery.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tunas.grocery.cutomresponse.CustomResponse;
import tunas.grocery.cutomresponse.ListResponse;
import tunas.grocery.cutomresponse.ObjectResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ObjectResponse<Customer> getCustomer(@PathVariable UUID id){
        Customer customer = customerService.getCustomer(id);
        CustomResponse<Customer> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(customer,200);
    }

    @GetMapping("/all")
    public ListResponse<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getCustomers();
        CustomResponse<Customer> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(customers,200);
    }

    @PostMapping
    public ObjectResponse<String> saveCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        customerService.saveCustomer(customer);
        CustomResponse<String> customResponse = new CustomResponse<>();
        return customResponse.sendResponse("",201);
    }
}
