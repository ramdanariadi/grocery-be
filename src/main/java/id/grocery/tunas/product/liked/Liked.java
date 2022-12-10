package id.grocery.tunas.product.liked;

import lombok.Data;
import lombok.NoArgsConstructor;
import id.grocery.tunas.product.Product;
import id.grocery.tunas.security.user.User;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Liked {
    @Id
    UUID id;
    private String name;
    private String imageUrl;
    private Long price;
    private Integer perUnit;
    private Integer weight;
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @OneToOne(fetch = FetchType.LAZY)
    Product product;

    public void setProduct(Product product) {
        this.product = product;
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.setImageUrl(product.getImageUrl());
        this.setWeight(product.getWeight());
        this.setPerUnit(product.getPerUnit());
        this.setCategory(product.getCategory().getCategory());
    }
}
