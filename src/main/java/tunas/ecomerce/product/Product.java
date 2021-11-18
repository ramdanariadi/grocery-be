package tunas.ecomerce.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import tunas.ecomerce.category.Category;
import tunas.ecomerce.images.Photos;

import javax.persistence.*;
import java.util.List;
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

    @OneToMany(mappedBy = "product")
    List<Photos> photos;

    @ManyToOne
    Category category;
}
