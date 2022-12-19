package id.grocery.tunas.product;

import id.grocery.tunas.base.BaseModel;

public class Product extends BaseModel {
    private String name;
    private Long price; // per unit
    private Integer perUnit; // gram
    private String description;
    private Integer weight; // on gram
    private String imageUrl;
}
