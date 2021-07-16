package tunas.grocery.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    Customer findCustomersById(UUID id);

    @Query("select c from Customer c")
    List<Customer> findAllCustomers();
}
