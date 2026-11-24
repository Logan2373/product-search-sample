package com.example.search.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.search.model.Product;

public interface ProductRepository
        extends ElasticsearchRepository<Product, String> {

    List<Product> findByNameContaining(String name);

    List<Product> findByBrand(String brand);

    List<Product> findByCategory(String category);

    List<Product> findByPriceLessThan(Double price);

    List<Product> findByNameContainingAndPriceLessThan(
            String name,
            Double price);
}