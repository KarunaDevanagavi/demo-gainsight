package org.teamn.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Product {

    private String suk;
    @Setter
    private String name;
    @Setter
    private String productSubFamily;
    @Setter
    private String productFamily;
    @Setter
    private String brand;
    @Setter
    private String description;
    @Setter
    private String searchString;
    @Setter
    private Integer price;

    public Product(String suk){
        this.suk = suk;
    }
}
