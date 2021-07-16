package tunas.ecomerce.product;

import tunas.ecomerce.category.Category;
import tunas.ecomerce.images.Photos;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Product {
    @Id
    UUID id;
    String name;
    Long price;
    String description;

    @OneToMany(targetEntity = Photos.class)
    List<Photos> photos;

    @ManyToOne
    Category category;

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
