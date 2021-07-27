package tunas.ecomerce.product.recommedationproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.UUID;

@RequestMapping("/product/recommendation")
public class RecommendationProductController {
    @Autowired
    RecommendationProductService recommendationProductService;

    @GetMapping("{id}")
    ObjectResponse<RecommendationProduct> getRecommendationProductById(@RequestParam UUID id){
        CustomResponse customResponse = new CustomResponse();
        return customResponse.sendResponse(recommendationProductService.getById(id),200);
    }

    @GetMapping("/all")
    ListResponse<RecommendationProduct> getAll(){
        CustomResponse customResponse = new CustomResponse();
        return customResponse.sendResponse(recommendationProductService.getAll(),200);
    }
}
