package id.grocery.tunas.category.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

public class FindAllCategoryDTO {

    @NoArgsConstructor
    @Data
    public static class Request{
        private int pageSize;
        private int pageIndex;
    }

    @NoArgsConstructor
    @Data
    public static class Response{
        private List<SimpleCategoryDTO> data;
        private int pageSize;
        private int pageIndex;
        private long totalData;
    }

    @NoArgsConstructor
    @Data
    public static class SimpleCategoryDTO{
        private UUID id;
        private String category;
        private String imageUrl;
    }

}
