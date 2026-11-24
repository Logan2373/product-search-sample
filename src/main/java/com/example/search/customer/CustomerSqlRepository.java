package com.example.search.customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerSqlRepository {

    private final Map<String, CustomerEntity> database =
            new HashMap<>();

    public CustomerEntity save(
            CustomerEntity entity) {

        database.put(
                entity.getCustomerId(),
                entity);

        return entity;
    }

    public CustomerEntity findById(
            String customerId) {

        return database.get(customerId);
    }
}