package org.turjoysaha.ecom.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.turjoysaha.ecom.dtos.FakeStoreProductRequestDTO;
import org.turjoysaha.ecom.dtos.FakeStoreProductResponseDTO;
import org.turjoysaha.ecom.dtos.ProductListResponseDTO;
import org.turjoysaha.ecom.dtos.ProductResponseDTO;

import java.util.List;

@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;

    private String fakeStoreAPIURL;

    @Value("${fakestore.api.url}")
    private String fakeStoreAPIPathProduct;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder,
                              @Value("${fakestore.api.path.products}") String fakeStoreAPIPathProduct) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIURL = fakeStoreAPIPathProduct;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO productRequestDTO){
        String createProductURL = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.postForEntity(createProductURL, productRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public  FakeStoreProductResponseDTO getProductById(int id){
        String getAllProductsURL = fakeStoreAPIURL + fakeStoreAPIPathProduct + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.getForEntity(getAllProductsURL, FakeStoreProductResponseDTO.class);
        return  productResponse.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String getAllProductsURL = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseArray =
                restTemplate.getForEntity(getAllProductsURL, FakeStoreProductResponseDTO[].class);
       return List.of(productResponseArray.getBody());
    }

    public void deleteProductById(int id){
        String productDeleteURL = fakeStoreAPIURL + fakeStoreAPIPathProduct + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(productDeleteURL);
    }
}
