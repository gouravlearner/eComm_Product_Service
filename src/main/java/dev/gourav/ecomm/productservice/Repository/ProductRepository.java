package dev.gourav.ecomm.productservice.Repository;

import dev.gourav.ecomm.productservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

public interface ProductRepository extends JpaRepository  <Product, Long> {

    @Override
    Optional<Product> findById (Long id);

    @Override
    Product save (Product product);
}
