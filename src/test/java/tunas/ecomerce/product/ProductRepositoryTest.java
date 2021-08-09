package tunas.ecomerce.product;

import com.fasterxml.uuid.Generators;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tunas.ecomerce.category.Category;
import tunas.ecomerce.category.CategoryRepository;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private CategoryRepository underTest;

    @Test
    void findTableColumn() {
    }

    @Test
    void findProductById() {
        Category category = new Category();
        category.setCategory("Smart Phone");
        UUID id = Generators.randomBasedGenerator().generate();
        category.setId(id);

        underTest.save(category);

        Category category1 = underTest.findById(id).get();
        assertThat(category1.getCategory()).isEqualTo(category.getCategory());//        assertThat(2).isEqualTo(2);
    }
}