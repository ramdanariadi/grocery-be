package id.grocery.tunas.product.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductDTO {
    private String name;
    private BigDecimal price;
    private int weight;
    private int perUnit;
    private String description;
    private String imageUrl;
    private String categoryId;
}
