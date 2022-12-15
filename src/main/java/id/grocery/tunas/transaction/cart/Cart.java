package id.grocery.tunas.transaction.cart;

import id.grocery.tunas.base.BaseModel;
import id.grocery.tunas.product.Product;
import id.grocery.tunas.security.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Cart extends BaseModel {
    private String name;
    private String imageUrl;
    private Long price;
    private Integer perUnit;
    private Integer weight;
    private Integer total;
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    User user;

    @OneToOne
    Product product;

    public void setProduct(Product product) {
        this.product = product;
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.setWeight(product.getWeight());
        this.setPerUnit(product.getPerUnit());
        this.setImageUrl(product.getImageUrl());
        this.setCategory(product.getCategory().getCategory());
    }
}
