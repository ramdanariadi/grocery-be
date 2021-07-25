package tunas.ecomerce;

import com.fasterxml.uuid.Generators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tunas.ecomerce.category.Category;
import tunas.ecomerce.customer.Customer;
import tunas.ecomerce.customer.CustomerRepository;
import tunas.ecomerce.product.Product;
import tunas.ecomerce.category.CategoryRepository;
import tunas.ecomerce.product.ProductRepository;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadDataCategory();
        loadDataProduct();
        loadCustomer();
    }

    private void loadDataCategory(){
        Category category = new Category();
        category.setCategory("Vegetables");
        category.setId(Generators.timeBasedGenerator().generate());
        categoryRepository.save(category);
    }

    private void loadDataProduct(){
        Product product = new Product();
        product.setId(Generators.timeBasedGenerator().generate());
        product.setName("Broccoli");
        product.setDescription("Green vegetable, good for eyes");
        product.setPrice(1100L);
        product.setWeight(1500);
        product.setPerUnit(100);
        Category category = categoryRepository.findCategoryByCategory("Vegetables");
        product.setCategory(category);
        productRepository.save(product);
    }

    private void loadCustomer(){
        Customer customer = new Customer();
        customer.setName("GUEST");
        customer.setId(Generators.randomBasedGenerator().generate());
        customerRepository.save(customer);
    }
}
