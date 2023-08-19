package id.grocery.tunas.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

public class AddOrderDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private List<OrderItem> products;
    }

    @Data
    public static class OrderItem{
        private UUID productId;
        private int total;
    }
}
