package org.turjoysaha.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.turjoysaha.ecom.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
