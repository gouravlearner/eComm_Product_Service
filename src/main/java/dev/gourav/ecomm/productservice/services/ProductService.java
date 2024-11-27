package dev.gourav.ecomm.productservice.services;

import dev.gourav.ecomm.productservice.Exceptions.ProductNotFoundException;
import dev.gourav.ecomm.productservice.Model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
     Product getProductDetails(Long id) throws ProductNotFoundException;
     Product createProduct(String title,
                           String description,
                           Double price,
                           String image,
                           String category
     ) ;
}
