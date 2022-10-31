package id.grocery.tunas.product.projections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class ProductCustomSelect {
    private String name;
    private String description;
    private Long price;
    private Integer weight;
    private UUID id;
    private UUID categoryId;
}
