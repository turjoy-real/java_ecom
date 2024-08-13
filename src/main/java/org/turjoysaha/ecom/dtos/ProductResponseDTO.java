package org.turjoysaha.ecom.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponseDTO {
    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
