package id.grocery.tunas.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

public class GetShopDTO {

    @AllArgsConstructor
    @Data
    public static class Response{
        public ShopDTO data;
    }

    @Data
    public static class ShopDTO {
        private UUID id;
        private String name;
        private String imageUrl;
        private String address;
    }
}
