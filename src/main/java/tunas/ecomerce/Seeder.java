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

import java.util.UUID;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    private UUID categoryID;
    private UUID productID;
    private UUID customerID;

    @Override
    public void run(String... args) throws Exception {
        categoryID = UUID.fromString("8c2c184e-11d2-11ec-82a8-0242ac130003");
        productID = UUID.fromString("a3c02e8c-11d2-11ec-82a8-0242ac130003");
        customerID = UUID.fromString("ac723ce6-11d2-11ec-82a8-0242ac130003");
        loadDataCategory();
        loadDataProduct();
        loadCustomer();
    }

    private void loadDataCategory(){
        Category categoryCheck = categoryRepository.findCategoryById(categoryID);
        if(categoryCheck == null){
            Category category = new Category();
            category.setCategory("Vegetables");
            category.setId(categoryID);
            categoryRepository.save(category);
        }
    }

    private void loadDataProduct(){
        Product productCheck = productRepository.findProductById(productID);
        if(productCheck == null){
            Product product = new Product();
            product.setId(productID);
            product.setName("Broccoli");
            product.setDescription("Green vegetable, good for eyes");
            product.setPrice(1100L);
            product.setWeight(1500);
            product.setPerUnit(100);
            Category category = categoryRepository.findCategoryById(categoryID);
            product.setCategory(category);
            productRepository.save(product);
        }
    }

    private void loadCustomer(){
        Customer customerCheck = customerRepository.findCustomersById(customerID);
        if(customerCheck == null){
            Customer customer = new Customer();
            customer.setName("GUEST");
            customer.setId(customerID);
            customerRepository.save(customer);
        }
    }
}
