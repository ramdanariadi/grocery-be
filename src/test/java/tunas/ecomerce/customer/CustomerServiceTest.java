package tunas.ecomerce.customer;

import com.fasterxml.uuid.Generators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tunas.ecomerce.cutomresponse.ApiRequestException;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;
    CustomerService customerService;

    @BeforeEach
    void setUp() {
         customerService = new CustomerService(customerRepository);
    }

    @Test
    void getCustomer() {
        // given
        // when
        customerService.getCustomer(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));

        //then
        ArgumentCaptor<UUID> argumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(customerRepository).findCustomersById(argumentCaptor.capture());
    }

    @Test
    void getCustomers() {
        // given
        // when
        customerService.getCustomers();

        //then
        verify(customerRepository).findAllCustomers();
    }

    @Test
    void saveCustomer() {
        // given
        Customer customer = new Customer();
        customer.setName("GUEST");
        customer.setId(Generators.randomBasedGenerator().generate());

        // when
        customerService.saveCustomer(customer);
        ArgumentCaptor<Customer> argumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).save(argumentCaptor.capture());
        assertThat(customer).isEqualTo(argumentCaptor.getValue());
    }

    @Test
    void saveCustomerShouldThrowApiRequestError(){
        // given
        Customer customer = new Customer();
        customer.setId(Generators.randomBasedGenerator().generate());

        // when
        assertThatThrownBy(() -> customerService.saveCustomer(customer))
                .isInstanceOf(ApiRequestException.class)
                .hasMessage("Customer name cannot be null");
    }
}