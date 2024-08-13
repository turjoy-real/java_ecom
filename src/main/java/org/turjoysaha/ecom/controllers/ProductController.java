package org.turjoysaha.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.turjoysaha.ecom.dtos.ProductListResponseDTO;
import org.turjoysaha.ecom.dtos.ProductRequestDTO;
import org.turjoysaha.ecom.dtos.ProductResponseDTO;
import org.turjoysaha.ecom.exception.ProductNotFoundException;
import org.turjoysaha.ecom.model.Product;
import org.turjoysaha.ecom.services.ProductService;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

//    @Autowired
//    @Qualifier("FakeStoreProductService")
//    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts() {
        ProductListResponseDTO response = productService.getAllProducts();
        return  ResponseEntity.ok(response);
//        ProductResponseDTO p1 = new ProductResponseDTO();
//        p1.setId(1);
//        p1.setTitle("iPhone 15");
//        p1.setPrice(150000);
//        p1.setImage("www.google.com/images/iphone");
//        p1.setDescription(("Kafi Mehenga phone"));
//        p1.setCategory("Electronics");
//
//        ProductResponseDTO p2 = new ProductResponseDTO();
//        p2.setId(1);
//        p2.setTitle("Macbook Pro");
//        p2.setPrice(150000);
//        p2.setImage("www.google.com/images/macbook");
//        p2.setDescription(("Kafi Mehenga phone"));
//        p2.setCategory("Electronics");
//
//        List<ProductResponseDTO> products = Arrays.asList(p1,p2);
//        return ResponseEntity.ok(products);

    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductFromId(@PathVariable("id") int id) throws ProductNotFoundException {
        ProductResponseDTO response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO responseDTO = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProductById(@PathVariable("id") int id){
        boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }
}
