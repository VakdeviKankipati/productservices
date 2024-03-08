package com.vakya.productservicesfeb29.repositories;

import com.vakya.productservicesfeb29.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product p);
}
