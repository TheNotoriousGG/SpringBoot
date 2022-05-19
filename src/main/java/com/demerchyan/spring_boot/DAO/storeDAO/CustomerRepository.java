package com.demerchyan.spring_boot.DAO.storeDAO;


import org.springframework.data.jpa.repository.JpaRepository;
import com.demerchyan.spring_boot.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

