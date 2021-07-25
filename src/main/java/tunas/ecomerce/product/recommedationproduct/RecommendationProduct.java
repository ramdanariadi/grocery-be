package tunas.ecomerce.product.recommedationproduct;

import tunas.ecomerce.product.Product;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "recommendationProducts")
public class RecommendationProduct {
    @Id
    @Column(name = "product_id")
    UUID id;
    Long price;
    String name;
    Integer perUnit; // gram
    String description;
    Integer weight; // on gram

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    Product product;

    public RecommendationProduct() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPerUnit() {
        return perUnit;
    }

    public void setPerUnit(Integer perUnit) {
        this.perUnit = perUnit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
