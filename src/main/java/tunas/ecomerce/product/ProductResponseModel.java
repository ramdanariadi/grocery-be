package tunas.ecomerce.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseModel {
    String imageUrl;
    Integer weight;
    String name;
    Long price;
    String category;
    UUID id;
    UUID categoryId;

}
