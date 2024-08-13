package org.turjoysaha.ecom.services;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.turjoysaha.ecom.clients.FakeStoreAPIClient;
import org.turjoysaha.ecom.dtos.*;
import org.turjoysaha.ecom.exception.ProductNotFoundException;
import org.turjoysaha.ecom.model.Product;

import java.util.ArrayList;
import java.util.List;

import static  org.turjoysaha.ecom.mappers.ProductMapper.productRequestToFakeStoreProductRequest;
import static  org.turjoysaha.ecom.mappers.ProductMapper.fakeProductResponseToProductResponse;
import static org.turjoysaha.ecom.utils.ProductUtils.isNull;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{


    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;



    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder,  FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOList = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO productResponseDTOList = new ProductListResponseDTO();
        for (FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductResponseDTOList) {
            productResponseDTOList.getProducts().add(fakeProductResponseToProductResponse(fakeStoreProductResponseDTO));
        }
        return productResponseDTOList;
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
       FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);
       if(isNull(fakeStoreProductResponseDTO)){
           throw new ProductNotFoundException("Product not found with id: " + id);
       }
       return fakeProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        return fakeProductResponseToProductResponse(fakeStoreProductDTO);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return null;
    }

    @Override
    public  boolean deleteProduct(int id){
        fakeStoreAPIClient.deleteProductById(id);
        return true;
    }



}
