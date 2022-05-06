package com.demerchyan.spring_boot.DAO;

import java.util.List;

public interface IRepository<T>{

    int create(T obj);
    int delete(int id);
    int update(T obj);
    List<T> findAll();
    T findById(int id);

}
