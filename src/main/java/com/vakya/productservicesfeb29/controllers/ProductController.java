package com.vakya.productservicesfeb29.controllers;

import com.vakya.productservicesfeb29.dtos.*;
import com.vakya.productservicesfeb29.exceptions.ProductNotFoundException;
import com.vakya.productservicesfeb29.models.Product;
import com.vakya.productservicesfeb29.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;
import org.xml.sax.helpers.DefaultHandler;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private ProductService productService;
    private RestTemplate restTemplate;

    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/products/pagination")
    public ResponseEntity<Page<Product>> getProductss(@RequestBody GetProductRequestDto requestDto)  {
        return ResponseEntity.of(Optional.ofNullable(productService.getProductss(
                requestDto.getNumberOfResults() , requestDto.getOffset()
        )));
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

        return productService.getAllProducts();
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody UpdateProductRequestDto updateDto) throws URISyntaxException, ProductNotFoundException{
        return productService.updateProduct(productId,
               // updateDto.getId(),
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

    @DeleteMapping("/products/{productId}")
    public Product deleteProducts(@PathVariable("productId") Long productId) throws ProductNotFoundException{
        return productService.deleteProducts(productId);
    }

   /* @GetMapping("/products/category/category")
    public Object getSpecificCategorys(@PathVariable("category") String category){
        return  productService.getSpecificCategorys(category);
    }
    */
    @GetMapping("/products/category/{category}")
    public  List<Product> getProducts(@PathVariable("category") String category) throws  ProductNotFoundException{
        return  productService.getProducts(category);
    }


}
