package tunas.ecomerce.product;

import com.fasterxml.uuid.Generators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tunas.ecomerce.category.Category;
import tunas.ecomerce.category.CategoryRepository;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private CategoryRepository underTest;
    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void init(){
        Category category = new Category();
        category.setCategory("Smart Phone");
        UUID id = Generators.randomBasedGenerator().generate();
        category.setId(id);
        underTest.save(category);

        Product product = new Product();
        product.setId(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
        product.setName("Broccoli");
        product.setDescription("Green vegetable, good for eyes");
        product.setPrice(1100L);
        product.setWeight(1500);
        product.setPerUnit(100);
        Category c = underTest.findCategoryByCategory("Vegetables");
        product.setCategory(category);
        productRepository.save(product);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void findProductById() {
        Product product = productRepository.findProductById(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
        assertThat(product.getId().toString()).isEqualTo("0b589615-f910-11eb-936c-41a335bdee2c");
    }
}