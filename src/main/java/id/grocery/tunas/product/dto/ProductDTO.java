package id.grocery.tunas.product.dto;

import java.math.BigDecimal;

public class ProductDTO{
    private String name;
    private BigDecimal price;
    private int perUnit;
    private String description;
    private int weight;
    private String imageUrl;
    private Boolean isTop = false;
    private Boolean isRecommended = false;
    private String category;
    private String categoryId;
    private String shop;
    private String shopId;
}
