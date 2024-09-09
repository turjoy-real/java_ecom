package org.turjoysaha.ecom.services;

import org.springframework.stereotype.Service;
import org.turjoysaha.ecom.dtos.ProductListResponseDTO;
import org.turjoysaha.ecom.dtos.ProductRequestDTO;
import org.turjoysaha.ecom.dtos.ProductResponseDTO;
import org.turjoysaha.ecom.mappers.ProductMapper;
import org.turjoysaha.ecom.model.Product;
import org.turjoysaha.ecom.repository.ProductRepository;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ProductMapper.convertProductsToProductListResponseDTO(products);
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        return  null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO product) {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return null;
    }

    @Override
    public  boolean deleteProduct(int id){
        return true;
    }

    @Override
    public ProductResponseDTO findProductByTitle(String title) {
        Product product = productRepository.findByTitle(title);
        return ProductMapper.convertProductToProductResponseDTO(product);
    }
}
