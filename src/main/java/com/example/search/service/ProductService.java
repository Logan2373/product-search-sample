package com.example.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.search.model.Product;
import com.example.search.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ElasticsearchOperations operations;

    public ProductService(
            ProductRepository repository,
            ElasticsearchOperations operations) {

        this.repository = repository;
        this.operations = operations;
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Product> getAll() {

        List<Product> products = new ArrayList<>();

        repository.findAll().forEach(products::add);

        return products;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Product> searchByName(String name) {
        return repository.findByNameContaining(name);
    }

    public List<Product> searchByBrand(String brand) {
        return repository.findByBrand(brand);
    }

    public List<Product> searchByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Product> searchByPrice(Double price) {
        return repository.findByPriceLessThan(price);
    }

    public List<Product> advancedSearch(
            String name,
            Double price) {

        return repository.findByNameContainingAndPriceLessThan(
                name,
                price);
    }

    /**
     * Elasticsearch Full Text Search
     */
    public List<Product> search(String keyword) {

        Criteria criteria =
                new Criteria("name").contains(keyword);

        Query query =
                new CriteriaQuery(criteria);

        SearchHits<Product> hits =
                operations.search(
                        query,
                        Product.class);

        return hits.stream()
                .map(SearchHit::getContent)
                .toList();
    }

    public List<Product> multiFieldSearch(String keyword) {

    Criteria criteria = new Criteria("name")
            .contains(keyword)
            .or(new Criteria("brand")
                    .contains(keyword))
            .or(new Criteria("category")
                    .contains(keyword));

    Query query = new CriteriaQuery(criteria);

    SearchHits<Product> hits =
            operations.search(
                    query,
                    Product.class);

    return hits.stream()
            .map(SearchHit::getContent)
            .toList();
}
}