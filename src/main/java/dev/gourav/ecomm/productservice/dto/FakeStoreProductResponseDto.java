package dev.gourav.ecomm.productservice.dto;

import dev.gourav.ecomm.productservice.Model.Product;
import dev.gourav.ecomm.productservice.Model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDto {
    Long id;
    String title;
    String description;
    String price;
    String image;
    String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setPrice(Double.parseDouble(getPrice()));

        Category category = new Category();

        category.setName(getCategory());
        product.setCategory(category);

        return product;
    }
}
