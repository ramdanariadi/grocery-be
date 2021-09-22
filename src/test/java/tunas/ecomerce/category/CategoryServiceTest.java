package tunas.ecomerce.category;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tunas.ecomerce.cutomresponse.ApiRequestException;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    CategoryService categoryService;
    @Mock
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryService = new CategoryService(categoryRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById() {
        // given
        categoryService.findById(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));

        // when
        // then
        ArgumentCaptor<UUID> argumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(categoryRepository).findCategoryById(argumentCaptor.capture());
    }

    @Test
    void findAllCategory() {
        // given
        categoryService.findAllCategory();

        // when
        // then
        verify(categoryRepository).findAllCategories();
    }

    @Test
    void addCategory() {
        // given
        Category category = new Category();
        category.setId(UUID.fromString("0b589615-f910-11eb-936c-41a335bdee2c"));
        category.setCategory("Fruits");

        // when
        categoryService.addCategory(category);

        // then
        ArgumentCaptor<Category> argumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(argumentCaptor.capture());
    }

    @Test
    void addCategoryShouldThrownError(){
        // given
        Category category = new Category();

        // when
        // then
        assertThatThrownBy(() -> categoryService.addCategory(category))
                .isInstanceOf(ApiRequestException.class)
                .hasMessage("category empty not allowed");
    }

    @Test
    void updateCategory(){
        // given
        UUID id = UUID.randomUUID();
        Category category = new Category();
        category.setId(id);
        category.setCategory("Fruits");
        category.setImageUrl("notFound.png");

        //when
        categoryService.updateCategory(category);

        //then
        ArgumentCaptor<UUID> acId = ArgumentCaptor.forClass(UUID.class);
        ArgumentCaptor<String> acCg = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> acImUrl = ArgumentCaptor.forClass(String.class);
        verify(categoryRepository).updateCategory(acId.capture(),acCg.capture(),acImUrl.capture());

        assert(category.getId()).equals(acId.getValue());
        assert(category.getCategory()).equals(acCg.getValue());
        assert(category.getImageUrl()).equals(acImUrl.getValue());
    }

    @Test
    void updateCategoryShouldThrownError(){
        // given
        UUID id = UUID.randomUUID();
        Category category = new Category();

        //when
        //then
        assertThatThrownBy(() -> categoryService.updateCategory(category))
                .isInstanceOf(ApiRequestException.class)
                .hasMessage("category id is empty");
    }

    @Test
    void destroyCategory(){
        // given
        UUID id = UUID.randomUUID();

        //when
        categoryService.destroyCategory(id);

        //then
        ArgumentCaptor<UUID> argumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(categoryRepository).destroyCategoryById(argumentCaptor.capture());
    }
}