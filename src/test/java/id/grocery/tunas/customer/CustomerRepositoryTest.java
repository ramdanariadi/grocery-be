package id.grocery.tunas.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void beforeAll() {
        Customer customer = new Customer();
        customer.setName("GUEST");
        customer.setId(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
        customerRepository.save(customer);
    }

    @Test
    void findCustomersById() {
        Customer customer = customerRepository.findCustomersById(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
        assertThat(customer.getId().toString()).isEqualTo("0b589615-f910-11eb-936c-41a335bdee2c");
    }

    @Test
    void findAllCustomers() {
        List<Customer> allCus = (List<Customer>) customerRepository.findAll();
        assertThat(allCus).isNotNull();
    }
}