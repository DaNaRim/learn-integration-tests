package com.example.advancedtesting.repository;

import com.example.advancedtesting.service.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
