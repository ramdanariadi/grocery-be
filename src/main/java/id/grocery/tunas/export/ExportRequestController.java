package id.grocery.tunas.export;

import id.grocery.tunas.export.dto.ExportRequestDTO;
import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/export")
@AllArgsConstructor
public class ExportRequestController {

    private ExportRequestService exportRequestService;

    @GetMapping("/product")
    public ResponseEntity<Object> sendRequest(HttpServletRequest request, ExportRequestDTO.Request requestBody){
        JsonObject customId = new JsonObject(request.getHeader("x-custom-id"));
        exportRequestService.exportProduct(UUID.fromString(customId.getString("userId")),requestBody);
        return ResponseEntity.ok().build();
    }
}
