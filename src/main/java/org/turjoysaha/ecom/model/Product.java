package org.turjoysaha.ecom.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}

