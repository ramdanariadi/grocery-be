package id.grocery.tunas.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import id.grocery.tunas.category.Category;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    private UUID id;
    private String name;
    private Long price; // per unit
    private Integer perUnit; // gram
    private String description;
    private Integer weight; // on gram
    private String imageUrl;

    @Column(columnDefinition = "boolean default false")
    private Boolean deleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    Category category;
}
