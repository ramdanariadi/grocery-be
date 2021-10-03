package tunas.ecomerce.transaction.chart;

import com.fasterxml.uuid.Generators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.customer.Customer;
import tunas.ecomerce.customer.CustomerRepository;
import tunas.ecomerce.cutomresponse.ApiRequestException;
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

    public boolean storeToChart(UUID customerId,UUID productId,Integer total){
        Optional<Chart> optionalChart = chartRepository.findChartByCustomerIdAndProductId(customerId,productId);
        if(optionalChart.isPresent()){
            return chartRepository.incrementProductTotalInChart(customerId,productId) > 0;
        }
        Product product = productRepository.findProductById(productId);
        Customer customer = customerRepository.findCustomersById(customerId);
        Chart chart = new Chart();
        chart.setId(Generators.timeBasedGenerator().generate());
        chart.setTotal(total);
        chart.setProduct(product);
        chart.setCustomer(customer);
        return chartRepository.save(chart) != null;
    }

    public List<ChartRepository.ICharts> chartList(UUID customerId){
        return chartRepository.findChartsByCustomerId(customerId);
    }

    public Integer removeFromChart(UUID customerId, UUID productId) {
        return chartRepository.removeFromChart(customerId,productId);
    }
}
