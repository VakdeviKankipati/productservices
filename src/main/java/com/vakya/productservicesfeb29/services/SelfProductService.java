package com.vakya.productservicesfeb29.services;

import com.vakya.productservicesfeb29.exceptions.ProductNotFoundException;
import com.vakya.productservicesfeb29.models.Category;
import com.vakya.productservicesfeb29.models.Product;
import com.vakya.productservicesfeb29.repositories.CategoryRepository;
import com.vakya.productservicesfeb29.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
@Service("selfProductService")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String category, double price, String image) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        //Category category1 = categoryRepository.findByTitle(category);
        Category category1 = (Category) categoryRepository.findByTitle(category);

        if(category1 == null){
            category1 = new Category();
            category1.setTitle(title);
        }
        product.setCategory(category1);
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public Product updateProduct(String title, String description, String category, double price, String image) throws URISyntaxException {
        return null;
    }

    @Override
    public Object getAllCategories() {
        return null;
    }

    @Override
    public Product deleteProduct(String title, String description, String category, double price, String image) {
        return null;
    }

    @Override
    public Object getSpecificCategory() {
        return null;
    }
}
