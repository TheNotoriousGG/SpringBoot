package com.demerchyan.spring_boot.DAO.storeDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demerchyan.spring_boot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

