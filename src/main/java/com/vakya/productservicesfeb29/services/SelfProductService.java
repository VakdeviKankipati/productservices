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
        return productRepository.findByIdIs(productId);
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String description, String category, double price, String image) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        Category category1 = (Category) categoryRepository.findByTitle(category);

        if(category1 == null){
            category1 = new Category();
            category1.setTitle(title);
        }
        product.setCategory(category1);


        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, String title, String description, String category, double price, String image) throws  ProductNotFoundException, URISyntaxException {
        Product product = getSingleProduct(productId);
        if(title !=null) {
            product.setTitle(title);
        }
        if(description != null){
            product.setDescription(description);
        }
        if(price != 0.0){
            product.setPrice(price);
        }
        if(image != null){
            product.setImageUrl(image);
        }
        if(category != null) {
            Category cat = new Category();
            cat.setTitle((product.getCategory().getTitle()));
            product.setCategory(cat);
        }
        productRepository.save(product);
        return product;
    }

    @Override
    public Object getAllCategories() {

        return categoryRepository.findAll();
    }

    @Override
    public Product deleteProducts(Long productId) throws ProductNotFoundException {
        Product p = getSingleProduct(productId);
        productRepository.delete(p);
        return p;
    }

   /* @Override
    public Object getSpecificCategorys(String category) {
        Category cat = categoryRepository.findByTitle(category);
        return  productRepository.findByCategory(cat);
      //  return productRepository.findByCategory_Title(String.valueOf(cat));
    }*/


    @Override
    public List<Product> getProducts(String category) throws ProductNotFoundException {
        Category cat = categoryRepository.findByTitle(category);
        return  productRepository.findByCategory(cat);
    }


}
