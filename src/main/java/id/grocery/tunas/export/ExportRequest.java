package id.grocery.tunas.export;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/export")
public class ExportRequest {

    @Value("${messaging.outgoing.export-report-request.topic}")
    private Optional<String> exportReportRequestTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping
    public ResponseEntity<Object> sendRequest(){
        kafkaTemplate.send(exportReportRequestTopic.orElse("export-request-topic"), "foo","{foo:bar}");
        return ResponseEntity.ok().build();
    }
}
