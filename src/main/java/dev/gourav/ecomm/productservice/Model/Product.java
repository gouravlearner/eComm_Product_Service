package dev.gourav.ecomm.productservice.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends Base {
    private String title;
    private String description;
    private Double price;
    private String imageurl;
    @ManyToOne(cascade = {CascadeType.PERSIST})
private Category category;
}
