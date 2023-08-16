package id.grocery.tunas.shop;

import id.grocery.tunas.base.BaseModel;
import id.grocery.tunas.security.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "shops")
@NoArgsConstructor
@Data
public class Shop extends BaseModel {
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "user_id", nullable = false)
    private UUID userId;
}
