package id.grocery.tunas.product;

import id.grocery.tunas.base.BaseModel;
import id.grocery.tunas.category.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Index;

@Entity
@Table(name = "products", indexes = {
        @Index(name = "idx_product_name", columnList = "name"),
        @Index(name = "idx_product_category",columnList = "category_id")
})
@Data
@NoArgsConstructor
public class Product extends BaseModel {
    private String name;
    private Long price; // per unit
    private Integer perUnit; // gram
    private String description;
    private Integer weight; // on gram
    private String imageUrl;

    private Boolean isTop = false;
    private Boolean isRecommended = false;

    @ManyToOne(fetch = FetchType.LAZY)
    Category category;
}
