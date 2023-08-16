package id.grocery.tunas.wishlist;

import id.grocery.tunas.base.BaseModel;
import id.grocery.tunas.product.Product;
import id.grocery.tunas.security.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "wishlists")
@Data
@NoArgsConstructor
public class Wishlist extends BaseModel {

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @OneToOne(fetch = FetchType.LAZY)
    Product product;

}
