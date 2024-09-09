package org.turjoysaha.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.turjoysaha.ecom.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByTitle(String title);

    @Query(value = CustomQueries.FIND_PRODUCT_BY_TITLE, nativeQuery = true)
    Product findProductByTitleLike(String title);

    @Query(value = "select * from Products", nativeQuery = true)
    List<Product> findAllProducts();
}
