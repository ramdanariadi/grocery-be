package id.grocery.tunas.export.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

public class GetListRequestExportDTO {

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
    public static class Response{
        private List<SimpleRequestExport> data;
        private long totalData;
        private int pageSize;
        private int pageIndex;
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class SimpleRequestExport{
        private UUID id;
        private String date;
        private String filename;
        private String status;
    }
}
