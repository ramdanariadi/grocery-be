<<<<<<<< HEAD:src/test/java/id/grocery/tunas/product/recommedationproduct/RecommendationProductServiceTest.java
package id.grocery.tunas.product.recommedationproduct;
========
package tunas.ecomerce.product.recommendationproduct;
>>>>>>>> f8208d6d0d4fbd1adfc3c8e3c91ab72a08783d41:src/test/java/tunas/ecomerce/product/recommendationproduct/RecommendationProductServiceTest.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import id.grocery.tunas.product.ProductRepository;

import java.util.UUID;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RecommendationProductServiceTest {

    RecommendationProductService recommendationProductService;
    @Mock
    RecommendationProductRepository recommendationProductRepository;
    @Mock
    ProductRepository productRepository;
    @BeforeEach
    void setUp() {
        recommendationProductService = new RecommendationProductService(recommendationProductRepository,productRepository);
    }

    @Test
    void getAll() {
        // given
        // when
        recommendationProductService.getAll();

        //then
        verify(recommendationProductRepository).getAll();
    }

    @Test
    void getById() {
        // given
        // when
        recommendationProductService.getById(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
        ArgumentCaptor<UUID> argumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(recommendationProductRepository).findById(argumentCaptor.capture());
    }
}