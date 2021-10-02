package tunas.ecomerce.product.liked;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wishlist")
public class LikedProductController {

    private final LikedProductService likedProductService;

    @Autowired
    public LikedProductController(LikedProductService likedProductService) {
        this.likedProductService = likedProductService;
    }

    @PostMapping("/{customerId}/{productId}")
    public ObjectResponse addToChart(@PathVariable UUID customerId,@PathVariable UUID productId){
        Liked saved = likedProductService.storeToChart(customerId,productId);
        CustomResponse<String> customResponse = new CustomResponse<>();
        if(saved != null){
            return customResponse.sendResponse("", HttpStatus.CREATED);
        }
        return customResponse.sendResponse("", HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}/{productId}")
    public ObjectResponse removeFromChart(@PathVariable UUID customerId,@PathVariable UUID productId){
        int deleted = likedProductService.removeFromChart(customerId, productId);
        CustomResponse<String> customResponse = new CustomResponse<>();
        if(deleted > 0){
            return customResponse.sendResponse("", HttpStatus.OK);
        }
        return customResponse.sendResponse("", HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/{customerId}")
    public ListResponse customerChart(@PathVariable UUID customerId){
        List<LikedProductRepository.ICharts> likedProductList = likedProductService.chartList(customerId);
        CustomResponse<LikedProductRepository.ICharts> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(likedProductList,HttpStatus.OK);
    }
}
