package tunas.ecomerce.category;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Category {
    @Id
    private UUID id;
    @NotNull
    private String category;
    private String imageUrl;

    @Column(columnDefinition = "boolean default false")
    private Boolean deleted = false;
}
