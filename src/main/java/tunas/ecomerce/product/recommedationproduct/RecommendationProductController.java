package tunas.ecomerce.product.recommedationproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product/recommendation")
public class RecommendationProductController {
    @Autowired
    RecommendationProductService recommendationProductService;

    @GetMapping("{id}")
    ObjectResponse<RecommendationProduct> getRecommendationProductById(@RequestParam UUID id){
        CustomResponse customResponse = new CustomResponse();
        return customResponse.sendResponse(recommendationProductService.getById(id).get(),HttpStatus.OK);
    }

    @GetMapping("/all")
    ListResponse<RecommendationProduct> getAll(){
        CustomResponse customResponse = new CustomResponse();
        return customResponse.sendResponse(recommendationProductService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    ObjectResponse<String> addRecommendationProduct(@PathVariable UUID id){
        recommendationProductService.addRecommendationProduct(id);
        CustomResponse<String> customResponse = new CustomResponse();
        return customResponse.sendResponse("", HttpStatus.OK);
    }
}
