package com.springboot.jasperreports.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jasperreports.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{
}
