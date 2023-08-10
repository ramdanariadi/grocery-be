package id.grocery.tunas.transaction;

import id.grocery.tunas.base.BaseModel;
import id.grocery.tunas.category.Category;
import id.grocery.tunas.product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Table(name = "transaction_details")
@NoArgsConstructor
public class TransactionDetail extends BaseModel {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "category_id", nullable = false)
    private UUID categoryId;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "price", nullable = false, columnDefinition = "numeric(19,2) default 0")
    private BigDecimal price;

    @Column(name = "per_unit", nullable = false)
    private Integer perUnit;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false)
    Transaction transaction;

    public void setProduct(Product product) {
        this.product = product;
        Category category = product.getCategory();
        this.category = category.getCategory();
        this.categoryId = category.getId();
        this.setDescription(product.getDescription());
        this.setImageUrl(product.getImageUrl());
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.setPerUnit(product.getPerUnit());
        this.setWeight(product.getWeight());
    }
}
