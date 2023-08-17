//package id.grocery.tunas.product;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
//import static org.mockito.Mockito.verify;
//
//import java.math.BigDecimal;
//import java.util.UUID;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import id.grocery.tunas.exception.ApiRequestException;
//
//@ExtendWith(MockitoExtension.class)
//class ProductServiceTest {
//
//    @Mock
//    private ProductRepository productRepository;
//    private ProductService productService;
//
//    @BeforeEach
//    void setUp() {
//        productService = new ProductService(productRepository);
//    }
//
//
//    @Test
//    void getAll() {
//        // when
//        productService.getAll();
//        // then
//        verify(productRepository).findCustomColumn();
//    }
//
//    @Test
//    void findProductById() {
//        // when
//        productService.findProductById(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
//        // then
//        verify(productRepository).findProductById(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
//    }
//
//    @Test
//    void saveProduct() {
//        // given
//        Product product = new Product();
//        product.setId(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
//        product.setPrice(BigDecimal.valueOf(1000L));
//        product.setName("tes");
//
//        // when
//        productService.saveProduct(product);
//
//        // then
//        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
//        verify(productRepository).save(productArgumentCaptor.capture());
//        Product capturedProduct = productArgumentCaptor.getValue();
//        assertThat(product).isEqualTo(capturedProduct);
//    }
//
//    @Test
//    void willThrowWhenPriceIsLessThanOne(){
//        // given
//        Product product = new Product();
//        product.setPrice(BigDecimal.ZERO);
//        product.setId(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
//
//        // when
//        // then
//        assertThatThrownBy(() -> productService.saveProduct(product))
//                .isInstanceOf(ApiRequestException.class)
//                .hasMessage("Price cannot lower than 1");
//    }
//
//    @Test
//    void testGetAll() {
//    }
//
//    @Test
//    void testFindProductById() {
//    }
//
//    @Test
//    void testSaveProduct() {
//    }
//}