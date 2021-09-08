package tunas.ecomerce.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepository);
    }


    @Test
    void getAll() {
        // when
        productService.getAll();
        // then
        verify(productRepository).findCustomColumn();
    }

    @Test
    void findProductById() {
        // when
        productService.findProductById(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
        // then
        verify(productRepository).findProductById(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
    }

    @Test
    void saveProduct() {
        // given
        Product product = new Product();
        product.setId(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
        product.setName("tes");

        // when
        productService.saveProduct(product);

        // then
        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(productArgumentCaptor.capture());
        Product capturedProduct = productArgumentCaptor.getValue();
        assertThat(product).isEqualTo(capturedProduct);
    }

    @Test
    void willThrowWhenPriceIsLessThanOne(){
        // given
        Product product = new Product();
        product.setPrice(0L);
        product.setId(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));

        Product product1 = new Product();
        product1.setPrice(0L);
        product1.setId(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));

        given(productRepository.
                findProductById(product.getId()))
                .willReturn(product1);

        // when
        // then
        assertThatThrownBy(() -> productService.saveProduct(product))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("price must be greater than 0");
    }
}