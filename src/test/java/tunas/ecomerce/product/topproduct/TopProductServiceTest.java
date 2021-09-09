package tunas.ecomerce.product.topproduct;

import com.fasterxml.uuid.Generators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tunas.ecomerce.category.Category;
import tunas.ecomerce.product.Product;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TopProductServiceTest {

    TopProductService topProductService;
    @Mock
    TopProductRepository topProductRepository;

    @BeforeEach
    void setUp() {
        topProductService = new TopProductService(topProductRepository);
    }

    @Test
    void addTopProduct() {
        // given
        TopProduct product = new TopProduct();
        product.setId(Generators.timeBasedGenerator().generate());
        product.setName("Broccoli");
        product.setDescription("Green vegetable, good for eyes");
        product.setPrice(1100L);
        product.setWeight(1500);
        product.setPerUnit(100);

        // when
        topProductService.addTopProduct(product);
        ArgumentCaptor<TopProduct> argumentCaptor = ArgumentCaptor.forClass(TopProduct.class);
        verify(topProductRepository).save(argumentCaptor.capture());
        assertThat(product).isEqualTo(argumentCaptor.getValue());
    }

    @Test
    void getAll() {
        //given
        // when
        topProductService.getAll();
        verify(topProductRepository).getAll();
    }

    @Test
    void getById() {
        // given
        // when
        topProductService.getById(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
        ArgumentCaptor<UUID> argumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(topProductRepository).findById(argumentCaptor.capture());
    }
}