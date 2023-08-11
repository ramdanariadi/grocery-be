package id.grocery.tunas.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

public class FindAllCategoryDTO {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Request{
        private int pageSize;
        private int pageIndex;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Response{
        private List<SimpleCategoryDTO> data;
        private int pageSize;
        private int pageIndex;
        private long totalData;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class SimpleCategoryDTO{
        private UUID id;
        private String category;
        private String imageUrl;
    }

}
