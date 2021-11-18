package tunas.ecomerce.product.recommedationproduct;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product/recommendation")
@AllArgsConstructor
public class RecommendationProductController {

    private final RecommendationProductService recommendationProductService;

    @GetMapping("{id}")
    ObjectResponse<RecommendationProduct> getRecommendationProductById(@PathVariable UUID id){
        CustomResponse customResponse = new CustomResponse();
        return customResponse.sendResponse(recommendationProductService.getById(id).get(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ObjectResponse destroyRecommendationProduct(@PathVariable UUID id){
        return CustomResponse.getModifyingObjectResponse(recommendationProductService.destroy(id));
    }

    @GetMapping("")
    ListResponse<RecommendationProductRepository.iCustomSelect> getAll(){
        CustomResponse<RecommendationProductRepository.iCustomSelect> customResponse = new CustomResponse();
        return customResponse.sendResponse(recommendationProductService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    ObjectResponse<String> addRecommendationProduct(@PathVariable UUID id){
        Boolean saved = recommendationProductService.addRecommendationProduct(id);
        CustomResponse<String> customResponse = new CustomResponse();
        if(saved){
            return customResponse.sendResponse("", HttpStatus.CREATED);
        }
        return customResponse.sendResponse("", HttpStatus.OK);
    }
}
