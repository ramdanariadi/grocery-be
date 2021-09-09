package tunas.ecomerce.product.topproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TopProductService {

    private final TopProductRepository topProductRepository;

    @Autowired
    public TopProductService(TopProductRepository topProductRepository){
        this.topProductRepository = topProductRepository;
    }

    Boolean addTopProduct(TopProduct topProduct){
        topProductRepository.save(topProduct);
        return true;
    }

    List<TopProduct> getAll(){
        return topProductRepository.getAll();
    }

    Optional<TopProduct> getById(UUID id){
        return topProductRepository.findById(id);
    }


}
