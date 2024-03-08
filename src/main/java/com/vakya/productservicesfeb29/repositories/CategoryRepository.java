package com.vakya.productservicesfeb29.repositories;

import com.vakya.productservicesfeb29.models.Product;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByTitle(String title);
}
