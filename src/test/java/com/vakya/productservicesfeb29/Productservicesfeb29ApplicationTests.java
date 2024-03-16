package com.vakya.productservicesfeb29;

import com.vakya.productservicesfeb29.models.Category;
import com.vakya.productservicesfeb29.models.Product;
import com.vakya.productservicesfeb29.repositories.CategoryRepository;
import com.vakya.productservicesfeb29.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Productservicesfeb29ApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testingQueries(){
        //productRepository.findAllByTitle("Hello vakya");
        Optional<Category> optionalCategory = categoryRepository.findById(1L);
        Category category = optionalCategory.get();
        System.out.println("Fetch the category object ");
        ///
        ///
        //List<Product> productList = category.getProducts();
        System.out.println("Fetched the list of products from category object");

    }


}
