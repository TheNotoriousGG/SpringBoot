package com.demerchyan.spring_boot.controllers;

import com.demerchyan.spring_boot.model.Product;
import com.demerchyan.spring_boot.DAO.storeDAO.ProductDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductOperationController {
    private final ProductDAO productRepos;

    @Autowired
    public ProductOperationController(ProductDAO repos) {
        this.productRepos = repos;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getForm(Model uiModel){
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "add-prod";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(Product product) {
        if (productRepos.findById(product.getId()) == null){
            productRepos.create(product);
        }else {
            productRepos.update(product);
        }
        return "add-prod"; }

    @RequestMapping(value = "/get/{id}")
    public String getById(@PathVariable int id,Model model){
         Product p = productRepos.findById(id);
         model.addAttribute(p);
         return "product";
    }

    @RequestMapping(value = "/del/{id}")
    public String delById(@PathVariable int id, Model model){
        productRepos.delete(id);
        model.addAttribute("repos",productRepos.findAll());
        return "repos";
    }
}

