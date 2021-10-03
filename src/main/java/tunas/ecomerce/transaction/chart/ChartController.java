package tunas.ecomerce.transaction.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chart")
public class ChartController {

    private final ChartService chartService;

    @Autowired
    public ChartController(ChartService chartService) {
        this.chartService = chartService;
    }

    @PostMapping("/{customerId}/{productId}/{total}")
    public ObjectResponse addToChart(@PathVariable UUID customerId,@PathVariable UUID productId, @PathVariable Integer total){
        boolean saved = chartService.storeToChart(customerId,productId,total);
        CustomResponse<String> customResponse = new CustomResponse<>();
        if(saved){
            return customResponse.sendResponse("", HttpStatus.CREATED);
        }
        return customResponse.sendResponse("", HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}/{productId}")
    public ObjectResponse removeFromChart(@PathVariable UUID customerId,@PathVariable UUID productId){
        Integer deleted = chartService.removeFromChart(customerId,productId);
        CustomResponse<String> customResponse = new CustomResponse<>();
        if(deleted > 0){
            return customResponse.sendResponse("", HttpStatus.OK);
        }
        return customResponse.sendResponse("", HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/{customerId}")
    public ListResponse customerChart(@PathVariable UUID customerId){
        List<ChartRepository.ICharts> charts = chartService.chartList(customerId);
        CustomResponse<ChartRepository.ICharts> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(charts,HttpStatus.OK);
    }
}
