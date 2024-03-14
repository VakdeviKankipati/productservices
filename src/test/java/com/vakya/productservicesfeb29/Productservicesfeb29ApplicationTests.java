package com.vakya.productservicesfeb29;

import com.vakya.productservicesfeb29.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Productservicesfeb29ApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testingQueries(){
        productRepository.findAllByTitle("Hello vakya");
    }


}
