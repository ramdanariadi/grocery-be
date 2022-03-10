package tunas.ecomerce.product.recommendationproduct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tunas.ecomerce.product.ProductRepository;

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