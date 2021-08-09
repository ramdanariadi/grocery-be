package tunas.ecomerce.product;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import tunas.ecomerce.category.Category;
import tunas.ecomerce.images.Photos;
import tunas.ecomerce.product.projections.ProductCustomSelect;
import tunas.ecomerce.product.topproduct.TopProduct;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    UUID id;
    String name;
    Long price; // per unit
    Integer perUnit; // gram
    String description;
    Integer weight; // on gram

    @OneToMany(targetEntity = Photos.class)
    List<Photos> photos;

    @ManyToOne
    Category category;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    TopProduct topProduct;

    public Integer getPerUnit() {
        return perUnit;
    }

    public void setPerUnit(Integer perUnit) {
        this.perUnit = perUnit;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
