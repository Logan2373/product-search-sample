package com.example.search.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.search.model.Product;
import com.example.search.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String health() {
        return "UP";
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {

        service.delete(id);

        return "Deleted Product : " + id;
    }

    @GetMapping("/search")
    public List<Product> searchByName(
            @RequestParam String name) {

        return service.searchByName(name);
    }
    @GetMapping("/fullsearch")
    public List<Product> fullSearch(
        @RequestParam String keyword) {

        return service.search(keyword);
    }

    @GetMapping("/brand")
    public List<Product> searchByBrand(
            @RequestParam String brand) {

        return service.searchByBrand(brand);
    }

    @GetMapping("/category")
    public List<Product> searchByCategory(
            @RequestParam String category) {

        return service.searchByCategory(category);
    }

    @GetMapping("/price")
    public List<Product> searchByPrice(
            @RequestParam Double price) {

        return service.searchByPrice(price);
    }

    @GetMapping("/advanced")
    public List<Product> advancedSearch(
            @RequestParam String name,
            @RequestParam Double price) {

        return service.advancedSearch(
                name,
                price);
    }

@GetMapping("/multisearch")
public List<Product> multiSearch(
        @RequestParam String keyword) {

    return service.multiFieldSearch(keyword);
}
}
