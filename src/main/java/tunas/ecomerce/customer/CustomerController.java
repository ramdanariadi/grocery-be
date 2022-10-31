package tunas.ecomerce.customer;

import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity getCustomer(@PathVariable UUID id){
        Customer customer = customerService.getCustomer(id);
        JsonObject result = new JsonObject();
        result.put("data", customer);
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping
    public ResponseEntity getAllCustomers(){
        List<CustomerRepository.ICustomer> customers = customerService.getCustomers();
        JsonObject result = new JsonObject();
        result.put("data", customers);
        return ResponseEntity.ok(result.getMap());
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return ResponseEntity.ok().build();
    }
}
