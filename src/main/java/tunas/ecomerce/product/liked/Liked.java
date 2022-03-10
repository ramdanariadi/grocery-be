package tunas.ecomerce.product.liked;

import lombok.Data;
import lombok.NoArgsConstructor;
import tunas.ecomerce.product.Product;
import tunas.ecomerce.security.user.User;

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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @OneToOne
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
