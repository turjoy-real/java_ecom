package org.turjoysaha.ecom.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "Category")
public class Category extends BaseModel{
    private String categoryName;
}
