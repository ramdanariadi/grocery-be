package id.grocery.tunas.cart;

import id.grocery.tunas.base.BaseModel;
import id.grocery.tunas.product.Product;
import id.grocery.tunas.security.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "carts")
@Data
public class Cart extends BaseModel {
    private Integer total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    User user;

    @OneToOne
    Product product;

    public void setProduct(Product product) {
        this.product = product;
    }
}
