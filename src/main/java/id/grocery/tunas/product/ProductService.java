package id.grocery.tunas.product;

import com.google.common.base.Strings;
import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.product.dto.FindAllProductDTO;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDAO productDAO;

    public FindAllProductDTO.Response getAll(FindAllProductDTO.Request request){
        Query allProductsCount = productDAO.getAllProducts(true);
        Query allProductsData = productDAO.getAllProducts(false);
        allProductsData.setFirstResult(request.getPageIndex() * request.getPageSize()).setMaxResults(request.getPageSize());
        List<Object[]> resultList = allProductsData.getResultList();
        FindAllProductDTO.Response response = new FindAllProductDTO.Response();
        response.setTotalData(allProductsCount.getResultList().size());
        response.setPageIndex(request.getPageIndex());
        response.setPageSize(request.getPageSize());
        response.setData(resultList.stream().map(objects -> {
            FindAllProductDTO.SimpleProductDTO simpleProductDTO = new FindAllProductDTO.SimpleProductDTO();
//            id\:\:text, shop_id, shop_name, price, weight, category, perUnit, description, imageUrl, name
            simpleProductDTO.setId(UUID.fromString((String) objects[0]));
            simpleProductDTO.setShopId(null == objects[1] ? null : UUID.fromString((String) objects[1]));
            simpleProductDTO.setShopName(null == objects[2] ? null : (String) objects[2]);
            simpleProductDTO.setPrice((BigDecimal) objects[3]);
            simpleProductDTO.setWeight((int) objects[4]);
            simpleProductDTO.setCategory((String) objects[5]);
            simpleProductDTO.setPerUnit((int) objects[6]);
            simpleProductDTO.setDescription((String) objects[7]);
            simpleProductDTO.setImageUrl((String) objects[8]);
            simpleProductDTO.setName((String) objects[9]);
            return simpleProductDTO;
        }).collect(Collectors.toList()));
        return response;
    }

    public Product findProductById(UUID id){
        return productRepository.findProductById(id);
    }

    public List<ProductRepository.ICustomSelect> getAllBYCategory(UUID categoryId){
        return productRepository.findProductsByCategory(categoryId);
    }

    public void saveProduct(Product product){
        if(null == product.getCategory()){
            throw new ApiRequestException("CATEGORY_NOT_FOUND");
        }
        if(null == product.getPrice() || product.getPrice().compareTo(BigDecimal.ONE) <= 0)
            throw new ApiRequestException("PRICE_CANNOT_LOWER_THAN_0");
        productRepository.save(product);
    }

    public int updateProduct(Product product){
        if(Strings.isNullOrEmpty(product.getName())){
            throw new ApiRequestException("PRODUCT_NAME_CANNOT_EMPTY");
        }
        return productRepository.updateProduct(product.getId(),product.getName(),product.getPrice(),product.getImageUrl());
    }

    public int destroyProduct(UUID id){
        return productRepository.destroyProduct(id);
    }
}
