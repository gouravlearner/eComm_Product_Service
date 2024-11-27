package dev.gourav.ecomm.productservice.Controller;

import dev.gourav.ecomm.productservice.Exceptions.ProductNotFoundException;
import dev.gourav.ecomm.productservice.Model.Product;
import dev.gourav.ecomm.productservice.dto.ProductRequestDto;
import dev.gourav.ecomm.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("databaseProductService") ProductService productService) {
        this.productService = productService;
    }


@GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id) throws ProductNotFoundException {

        return productService.getProductDetails(id);

    }
@PostMapping("/products")
    public Product createProduct(@RequestBody ProductRequestDto productRequestDto) {

    return productService.createProduct(
            productRequestDto.getTitle(),
            productRequestDto.getDescription(),
            productRequestDto.getPrice(),
            productRequestDto.getImage(),
            productRequestDto.getCategory()
    );

}

@GetMapping ("/products")
public List<Product> getAllProducts(){
        return null;
}
}
