package id.grocery.tunas.export.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

public class CreateExportRequestDTO {
    @NoArgsConstructor
    @Data
    public static class Request{
        private String userId;
        private String requestId;
        private int pageSize;
        private int pageIndex;
    }

    @NoArgsConstructor
    @Data
    public static class Result{
        private String requestId;
        private String filename;
        private String status;
    }
}
