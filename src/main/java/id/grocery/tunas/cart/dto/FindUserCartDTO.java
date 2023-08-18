package id.grocery.tunas.cart.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

public class FindUserCartDTO {

    @NoArgsConstructor
    @Data
    public static class Request{
        private String search;
        private int pageSize;
        private int pageIndex;
    }

    @NoArgsConstructor
    @Data
    public static class Response{
        private List<SimpleCartDTO> data;
        private int pageSize;
        private int pageIndex;
        private long totalData;
    }

    @NoArgsConstructor
    @Data
    public static class SimpleCartDTO{
        private String id;
        private String productId;
        private String shopId;
        private String shopName;
        private BigDecimal price;
        private int weight;
        private String category;
        private int perUnit;
        private String description;
        private String imageUrl;
        private String name;
        private int total;
    }
}
