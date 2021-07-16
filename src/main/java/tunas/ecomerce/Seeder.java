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
        category.setCategory("Komputer");
        category.setId(Generators.timeBasedGenerator().generate());
        categoryRepository.save(category);
    }

    private void loadDataProduct(){
        Product product = new Product();
        product.setId(Generators.timeBasedGenerator().generate());
        product.setName("Mouse logitect MX1250");
        product.setDescription("Lightweith gaming mouse");
        product.setPrice(110000L);
        Category category = categoryRepository.findCategoryByCategory("Komputer");
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
