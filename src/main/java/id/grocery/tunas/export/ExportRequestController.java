package id.grocery.tunas.export;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/export")
@AllArgsConstructor
public class ExportRequestController {

    @Value("${messaging.outgoing.export-report-request.topic}")
    private Optional<String> exportReportRequestTopic;

    private KafkaTemplate<String, String> kafkaTemplate;
    private ExportRequestService exportRequestService;

    @GetMapping
    public ResponseEntity<Object> sendRequest(){
        kafkaTemplate.send(exportReportRequestTopic.orElse("export-request-topic"), "foo","{foo:bar}");
        exportRequestService.testUpload();
        return ResponseEntity.ok().build();
    }
}
