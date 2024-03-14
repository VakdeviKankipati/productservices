package com.vakya.productservicesfeb29.services;

import com.vakya.productservicesfeb29.exceptions.ProductNotFoundException;
import com.vakya.productservicesfeb29.models.Product;

import java.net.URISyntaxException;
import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Product> getProducts();

    Product createProduct(  String title,
                            String description,
                            String category,
                            double price,
                            String image
    );
    //Object g

    Product updateProduct(Long productId, String title, String description, String category, double price, String image) throws ProductNotFoundException, URISyntaxException;

    Object getAllCategories();

    Product deleteProducts(Long productId) throws  ProductNotFoundException;


    Object getSpecificCategorys(String category);
    //List<Product> getProducts(String category);


}
