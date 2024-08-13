package org.turjoysaha.ecom.services;

import org.turjoysaha.ecom.dtos.ProductListResponseDTO;
import org.turjoysaha.ecom.dtos.ProductRequestDTO;
import org.turjoysaha.ecom.dtos.ProductResponseDTO;
import org.turjoysaha.ecom.exception.ProductNotFoundException;
import org.turjoysaha.ecom.model.Product;

public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(int id) throws ProductNotFoundException;
    ProductResponseDTO createProduct(ProductRequestDTO product);
    boolean deleteProduct(int id);
    Product updateProduct(int id, Product updatedProduct);
}
