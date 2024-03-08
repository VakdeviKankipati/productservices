package com.vakya.productservicesfeb29.services;

import com.vakya.productservicesfeb29.dtos.FakeStoreProductsDto;
import com.vakya.productservicesfeb29.exceptions.ProductNotFoundException;
import com.vakya.productservicesfeb29.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{




    private RestTemplate restTemplate;
   // private long id;

    public FakeStoreProductService(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        ResponseEntity<FakeStoreProductsDto> fakeStoreProductResponse = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductsDto.class
                );
        FakeStoreProductsDto fakeStoreProduct = fakeStoreProductResponse.getBody();

        if (fakeStoreProduct == null) {
            throw new ProductNotFoundException("Product with id: " + productId + " doesn't exist. Retry some other product.");
        }
        return fakeStoreProduct.toProduct();
    }

    @Override
    public List<Product> getProducts() {
        FakeStoreProductsDto[] fakeStoreProducts =
                restTemplate.getForObject(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductsDto[].class
                );
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductsDto fakeStoreProduct  : fakeStoreProducts){
            products.add(fakeStoreProduct.toProduct());
        }
        return  products;

    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 String category,
                                 double price,
                                 String image) {

        FakeStoreProductsDto fakeStoreProductsDto = new FakeStoreProductsDto();
        fakeStoreProductsDto.setTitle(title);
        fakeStoreProductsDto.setCategory(category);
        fakeStoreProductsDto.setPrice(price);
        fakeStoreProductsDto.setImage(image);
        fakeStoreProductsDto.setDescription(description);

        FakeStoreProductsDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductsDto,
                FakeStoreProductsDto.class
        );
        if(response == null){
            return new Product();
        }
        return response.toProduct();
    }

   /* @Override
    public Object getAllProduct() {
       Object fake = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                Object.class

        );

       return fake;
    }*/

    @Override
    public Product updateProduct(String title, String description, String category, double price, String image) throws URISyntaxException {
        FakeStoreProductsDto fakeStore = new FakeStoreProductsDto();
       // fakeStore.setId(7);
        fakeStore.setTitle(title);
        fakeStore.setCategory(category);
        fakeStore.setPrice(price);
        fakeStore.setImage(image);
        fakeStore.setDescription(description);
        URI uri = new URI("https://fakestoreapi.com/products/7");
       // FakeStoreProductsDto response =
        restTemplate.put(
                uri,
                fakeStore
              // FakeStoreProductsDto.class
        );
      /*  if(response == null){
            return new Product();
        }*/
        //return response.toProduct();
        return fakeStore.toProduct();
    }

    @Override
    public Object getAllCategories() {
        Object object = restTemplate.getForObject(
               "https://fakestoreapi.com/products/categories",
                Object.class
        );
        return object;
    }

    @Override
    public Product deleteProduct(String title, String description, String category, double price, String image) {
        FakeStoreProductsDto dto = new FakeStoreProductsDto();
        //dto.setId(id);
        dto.setImage(image);
        dto.setTitle(title);
        dto.setDescription(description);
        dto.setCategory(category);
        dto.setPrice(price);
        // FakeStoreProductsDto response =
        restTemplate.delete(
                "https://fakestoreapi.com/products/6",
                dto,
                FakeStoreProductsDto.class
        );
       /* FakeStoreProductsDto storeProductsDto = restTemplate.delete(
                "https://fakestoreapi.com/products/6",
                dto,
                FakeStoreProductsDto.class

        );*/

        return dto.toProduct();
    }

    @Override
    public Object getSpecificCategory() {
        Object ob = restTemplate.getForObject(
                "https://fakestoreapi.com/products/category/jewelery",
                Object.class
        );
        return ob;
    }


}
