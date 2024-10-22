package org.anton.hexlet.module4.fruit_market;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
}
