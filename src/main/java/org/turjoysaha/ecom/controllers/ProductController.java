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


    @Autowired
    public ProductController(@Qualifier("ProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts() {
        ProductListResponseDTO response = productService.getAllProducts();
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductFromId(@PathVariable("id") int id) throws ProductNotFoundException {
        ProductResponseDTO response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products/title/{title}")
    public ResponseEntity getProductFromTitle(@PathVariable("title") String title) throws ProductNotFoundException {
        ProductResponseDTO response = productService.findProductByTitle(title);
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
