package com.demerchyan.spring_boot.controllers;

import com.demerchyan.spring_boot.DAO.storeDAO.ProductRepository;
import com.demerchyan.spring_boot.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/store/products")
public class RepositoryController {

    ProductRepository productRepository;

    public RepositoryController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(value = "/show_all", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> showAllCustomers(Model uiModel) {
        var p = productRepository.findAll();
        log.info("///////////////");
        return ResponseEntity.ok(p);

    }

}
