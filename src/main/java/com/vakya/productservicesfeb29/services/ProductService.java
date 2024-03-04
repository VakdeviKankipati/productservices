package com.vakya.productservicesfeb29.services;

import com.vakya.productservicesfeb29.models.Product;

import java.net.URISyntaxException;
import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getProduct();

    Product createProduct(  String title,
                            String description,
                            String category,
                            double price,
                            String image
    );
    Object getAllProduct();

    Product updateProduct(String title, String description, String category, double price, String image) throws URISyntaxException;

    Object getAllCategories();

    Product deleteProduct(String title, String description, String category, double price, String image);

    Object getSpecificCategory();
}
