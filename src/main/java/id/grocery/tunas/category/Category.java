package id.grocery.tunas.category;

import id.grocery.tunas.base.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Data
public class Category extends BaseModel {
    @Column(name = "category", length = 100, nullable = false)
    private String category;

    @Column(name = "image_url")
    private String imageUrl;

}
