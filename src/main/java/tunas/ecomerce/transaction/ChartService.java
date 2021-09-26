package tunas.ecomerce.transaction;

import com.fasterxml.uuid.Generators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunas.ecomerce.customer.Customer;
import tunas.ecomerce.customer.CustomerRepository;
import tunas.ecomerce.product.Product;
import tunas.ecomerce.product.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChartService {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final ChartRepository chartRepository;

    @Autowired
    public ChartService(ProductRepository productRepository, CustomerRepository customerRepository, ChartRepository chartRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.chartRepository = chartRepository;
    }

    public Chart storeToChart(UUID customerId,UUID productId){
        Product product = productRepository.findProductById(productId);
        Customer customer = customerRepository.findCustomersById(customerId);
        Chart chart = new Chart();
        chart.setId(Generators.timeBasedGenerator().generate());
        chart.setTotal(1);
        chart.setProduct(product);
        chart.setCustomer(customer);
        return chartRepository.save(chart);
    }

    public List<ChartRepository.ICharts> chartList(UUID customerId){
        List<ChartRepository.ICharts> charts = chartRepository.findChartsByCustomerId(customerId);
        return charts;
    }
}
