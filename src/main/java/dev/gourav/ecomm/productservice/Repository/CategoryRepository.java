package dev.gourav.ecomm.productservice.Repository;

import dev.gourav.ecomm.productservice.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository <Category, Long> {

    Category findByName (String name);

    Category save(Category category);
}
