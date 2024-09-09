package org.turjoysaha.ecom.mappers;

import org.turjoysaha.ecom.dtos.*;
import org.turjoysaha.ecom.model.Product;

import java.util.List;

public class ProductMapper {
    public static FakeStoreProductRequestDTO productRequestToFakeStoreProductRequest(ProductRequestDTO productRequestDTO){
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        return fakeStoreProductRequestDTO;
    }

    public static ProductResponseDTO fakeProductResponseToProductResponse(FakeStoreProductResponseDTO fakeStoreProductResponseDTO) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(fakeStoreProductResponseDTO.getId());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());
        return productResponseDTO;
    }

    public static ProductListResponseDTO convertProductsToProductListResponseDTO(List<Product> products){
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(Product product : products){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setId(product.getId());
            productResponseDTO.setTitle(product.getTitle());
            productResponseDTO.setDescription(product.getDescription());
            productResponseDTO.setImage(product.getImage());
            productResponseDTO.setPrice(product.getPrice().getAmount());
            productResponseDTO.setCategory(product.getCategory().getCategoryName());
            productListResponseDTO.getProducts().add(productResponseDTO);
        }
        return  productListResponseDTO;
    }

    public static ProductResponseDTO convertProductToProductResponseDTO(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setImage(product.getImage());
        productResponseDTO.setPrice(product.getPrice().getAmount());
        productResponseDTO.setCategory(product.getCategory().getCategoryName());
        return productResponseDTO;
    }
}
