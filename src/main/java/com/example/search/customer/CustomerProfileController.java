package com.example.search.customer;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService service;

    public CustomerProfileController(
            CustomerProfileService service) {

        this.service = service;
    }

    @PostMapping
    public CustomerProfileDocument createCustomer(
            @RequestBody CustomerProfileDocument document) {

        return service.createCustomer(document);
    }

    @GetMapping("/{customerId}")
    public CustomerProfileDocument getCustomer(
            @PathVariable String customerId) {

        return service.getCustomer(customerId);
    }

    @GetMapping("/sql/{customerId}")
    public CustomerEntity getCustomerFromSql(
            @PathVariable String customerId) {

        return service.getCustomerFromSql(
                customerId);
    }

    @GetMapping("/mobile/{mobile}")
    public CustomerProfileDocument getCustomerByMobile(
            @PathVariable String mobile) {

        return service.getCustomerByMobile(
                mobile);
    }

    @GetMapping("/email/{email}")
    public CustomerProfileDocument getCustomerByEmail(
            @PathVariable String email) {

        return service.getCustomerByEmail(
                email);
    }
}