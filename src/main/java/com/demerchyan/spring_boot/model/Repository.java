package com.demerchyan.spring_boot.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Repository {
    private final List<Product> repos;

    public Repository(){
        repos = new ArrayList<>();
    }

    public Product getProduct(int id){
        for (Product p: repos) {
            if(p.getId() == id)
                return p;
        }
        return null;
    }

    public void addProduct(Product p) {

        repos.add(p);
    }
}
