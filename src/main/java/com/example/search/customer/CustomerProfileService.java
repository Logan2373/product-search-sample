package com.example.search.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerProfileService {

    private final CustomerProfileRepository elasticRepository;

    private final CustomerSqlRepository sqlRepository;

    public CustomerProfileService(
            CustomerProfileRepository elasticRepository,
            CustomerSqlRepository sqlRepository) {

        this.elasticRepository = elasticRepository;
        this.sqlRepository = sqlRepository;
    }

    public CustomerProfileDocument createCustomer(
            CustomerProfileDocument document) {

        CustomerEntity entity =
                new CustomerEntity();

        entity.setCustomerId(
                document.getCustomerId());

        entity.setCustomerName(
                document.getCustomerName());

        entity.setMobile(
                document.getMobile());

        entity.setEmail(
                document.getEmail());

        sqlRepository.save(entity);

        return elasticRepository.save(document);
    }

    public CustomerProfileDocument getCustomer(
            String customerId) {

        return elasticRepository
                .findById(customerId)
                .orElse(null);
    }

    public CustomerEntity getCustomerFromSql(
            String customerId) {

        return sqlRepository.findById(
                customerId);
    }

    public CustomerProfileDocument getCustomerByMobile(
            String mobile) {

        return elasticRepository.findByMobile(
                mobile);
    }

    public CustomerProfileDocument getCustomerByEmail(
            String email) {

        return elasticRepository.findByEmail(
                email);
    }
}