package id.grocery.tunas.category;

import com.sun.istack.NotNull;
import id.grocery.tunas.base.BaseModel;
import lombok.Data;

@Data
public class Category extends BaseModel {
    @NotNull
    private String category;
    private String imageUrl;

}
