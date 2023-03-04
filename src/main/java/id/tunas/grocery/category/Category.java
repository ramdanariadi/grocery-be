package id.tunas.grocery.category;

import com.sun.istack.NotNull;
import id.tunas.grocery.base.BaseModel;
import lombok.Data;

@Data
public class Category extends BaseModel {
    @NotNull
    private String category;
    private String imageUrl;

}
