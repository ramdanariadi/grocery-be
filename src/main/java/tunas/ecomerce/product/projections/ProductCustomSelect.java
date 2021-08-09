package tunas.ecomerce.product.projections;

import java.util.UUID;

public class ProductCustomSelect {
    private String name;
    private String description;
    private Long price;
    private Integer weight;
    private UUID id;
    private UUID categoryId;

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProductCustomSelect(String name, String description, Long price, Integer weight, UUID id, UUID categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.id = id;
        this.categoryId = categoryId;
    }
}
