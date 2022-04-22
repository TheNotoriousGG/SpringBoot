package com.demerchyan.spring_boot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Product {
    private int id;
    private String title;
    private double cost;
}

