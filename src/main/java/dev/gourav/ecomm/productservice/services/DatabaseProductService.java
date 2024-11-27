package dev.gourav.ecomm.productservice.services;

import dev.gourav.ecomm.productservice.Exceptions.ProductNotFoundException;
import dev.gourav.ecomm.productservice.Model.Category;
import dev.gourav.ecomm.productservice.Model.Product;
import dev.gourav.ecomm.productservice.Repository.CategoryRepository;
import dev.gourav.ecomm.productservice.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service ("databaseProductService")
public class DatabaseProductService implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public DatabaseProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override

    public Product getProductDetails (Long id) throws ProductNotFoundException {

        Optional<Product> responseProduct = productRepository.findById(id);
        if (responseProduct.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }
        return responseProduct.get();
    }

    @Override
    public Product createProduct(String title, String description, Double price, String image, String category) {

        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageurl(image);

        Category responseCategory = categoryRepository.findByName(category);

        if(responseCategory==null) {
            Category categoryResponse = new Category();
            categoryResponse.setName(category);
            responseCategory = categoryResponse;
        }

        product.setCategory(responseCategory);

        return productRepository.save(product);

    }

}
