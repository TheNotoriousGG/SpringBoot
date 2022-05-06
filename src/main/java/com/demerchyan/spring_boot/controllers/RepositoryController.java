package com.demerchyan.spring_boot.controllers;

import com.demerchyan.spring_boot.DAO.storeDAO.CustomerDAO;
import com.demerchyan.spring_boot.DAO.storeDAO.ProductDAO;
import com.demerchyan.spring_boot.model.Customer;
import com.demerchyan.spring_boot.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/repos")
public class RepositoryController {
    private ProductDAO repos;
    private CustomerDAO customerDAO;
    private ProductDAO productDAO;

    @Autowired
    public RepositoryController(CustomerDAO customerDAO,ProductDAO productDAO) {
        this.customerDAO = customerDAO;
        this.productDAO = productDAO;
    }

    @RequestMapping()
    public String getForm(Model uiModel) {
        uiModel.addAttribute("repos", repos.findAll());
        return "repos";
    }

    @RequestMapping("/test2")
    public ResponseEntity<Product> getTest2(Model model) {
        Product c = productDAO.findById(1);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(c);
    }
}
