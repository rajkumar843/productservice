package com.mrk.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrk.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
