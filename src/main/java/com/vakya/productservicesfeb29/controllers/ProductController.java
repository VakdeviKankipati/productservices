package com.vakya.productservicesfeb29.controllers;

import com.vakya.productservicesfeb29.dtos.CreateProductRequestDto;
import com.vakya.productservicesfeb29.dtos.DeleteProductDto;
import com.vakya.productservicesfeb29.dtos.ErrorDto;
import com.vakya.productservicesfeb29.dtos.UpdateProductRequestDto;
import com.vakya.productservicesfeb29.exceptions.ProductNotFoundException;
import com.vakya.productservicesfeb29.models.Product;
import com.vakya.productservicesfeb29.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    private RestTemplate restTemplate;

    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto requestDto){
        return productService.createProduct(
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getCategory(),
                requestDto.getPrice(),
                requestDto.getImage()
        );
    }


    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productsId) throws ProductNotFoundException {

        return productService.getSingleProduct(productsId);
    }


    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequestDto updateDto) throws URISyntaxException {
        return productService.updateProduct(
                updateDto.getTitle(),
                updateDto.getDescription(),
                updateDto.getCategory(),
                updateDto.getPrice(),
                updateDto.getImage()
        );

    }

  /*  @GetMapping("products")
    public Object getAllProduct() {
        //return productService.getAllProducts();
        return productService.getAllProduct();
    }*/

    @GetMapping("/products/categories")
    public Object getAllCategories(){

        return productService.getAllCategories();
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable Long id, @RequestBody DeleteProductDto deleteDto){
        return productService.deleteProduct(
                //deleteDto.getId(),
                deleteDto.getDescription(),
                deleteDto.getCategory(),
                deleteDto.getTitle(),
                deleteDto.getPrice(),
                deleteDto.getImage()
        );
    }
    @GetMapping("/products/category/jewelery")
    public Object getSpecificCategory(){
        return  productService.getSpecificCategory();
    }
}
