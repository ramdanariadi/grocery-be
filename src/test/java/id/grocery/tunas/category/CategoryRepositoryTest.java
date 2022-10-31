package id.grocery.tunas.category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void should_find_all_category() {
        // given
        // when
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        assertThat(categories.isEmpty()).isTrue();
    }

    @Test
    void should_store_category() {
        // given
        Category category = new Category();
        category.setId(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
        category.setCategory("Fruits");

        // when
        Category savedCategory = categoryRepository.save(category);

        // then
        assertThat(savedCategory.getId()).isEqualTo(category.getId());

    }

    @Test
    void should_find_category_by_id() {
        // given
        Category category = new Category();
        category.setId(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
        category.setCategory("Fruits");
        categoryRepository.save(category);

        // when
        Optional<Category> categoryOpt = categoryRepository.findById(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));

        //then
        assertThat(categoryOpt.isEmpty()).isFalse();
    }
}