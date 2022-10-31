package id.grocery.tunas.product.liked;

import lombok.Data;
import lombok.NoArgsConstructor;
import id.grocery.tunas.customer.Customer;
import id.grocery.tunas.product.Product;

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
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

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
