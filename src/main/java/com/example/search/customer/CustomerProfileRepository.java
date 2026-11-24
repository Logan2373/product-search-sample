package com.example.search.customer;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CustomerProfileRepository
        extends ElasticsearchRepository<
                CustomerProfileDocument,
                String> {

    CustomerProfileDocument findByMobile(
            String mobile);

    CustomerProfileDocument findByEmail(
            String email);
}