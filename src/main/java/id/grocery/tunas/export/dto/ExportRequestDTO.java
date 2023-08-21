package id.grocery.tunas.export.dto;

import io.vertx.core.json.JsonObject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

public class ExportRequestDTO {
    @NoArgsConstructor
    @Data
    public static class Request implements Serializable {
        private String userId;
        private String requestId;
        private int pageSize;
        private int pageIndex;
    }

    @NoArgsConstructor
    @Data
    public static class Result implements Serializable {
        private String requestId;
        private String filename;
        private String status;
    }
}
