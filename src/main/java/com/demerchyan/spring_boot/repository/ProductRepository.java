package com.demerchyan.spring_boot.repository;

import com.demerchyan.spring_boot.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Transactional
@Repository
public class ProductRepository implements IRepository<Product> {
    @PersistenceContext
    EntityManager em;

    @Override
    public int create(Product obj) {
        Product product = new Product();
        product.setTitle(obj.getTitle());
        product.setCost(obj.getCost());
        em.persist(product);
        return 1;
    }

    @Override
    public int delete(int id) {
        if(findById(id) != null)
            em.remove(findById(id));
        return 0;
    }

    @Override
    public int update(Product obj) {
        em.merge(obj);

        return 0;
    }

    @Override
    public List<Product> findAll() {
        return em.createNativeQuery("select * from product",Product.class)
                .getResultList();
    }

    @Override
    public Product findById(int id) {
       return em.find(Product.class,id);
    }
}
