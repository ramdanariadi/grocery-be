package tunas.ecomerce.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    Customer findCustomersById(UUID id);

    @Query("select c.id as id, c.name as name, c.mobile as mobile, c.email as email from Customer c")
    List<ICustomer> findAllCustomers();

    interface ICustomer{
        @Value("#{target.id}")
        UUID getId();
        String getName();
        String getMobile();
        String getEmail();
    }
}
