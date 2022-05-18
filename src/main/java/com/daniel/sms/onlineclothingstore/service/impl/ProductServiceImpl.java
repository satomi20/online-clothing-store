package com.daniel.sms.onlineclothingstore.service.impl;

import com.daniel.sms.onlineclothingstore.entity.Category;
import com.daniel.sms.onlineclothingstore.entity.Product;
import com.daniel.sms.onlineclothingstore.repository.CategoryRepository;
import com.daniel.sms.onlineclothingstore.repository.ProductRepository;
import com.daniel.sms.onlineclothingstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findByNameContaining(String name, Pageable pageable) {
        return productRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Product> findByPriceBetween(Integer startingPrice, Integer endingPrice, Pageable pageable) {
        return productRepository.findByPriceBetween(startingPrice, endingPrice, pageable);
    }

    @Override
    public Page<Product> findByCategoryContaining(String category, Pageable pageable) {
        return productRepository.findByCategoryContaining(category, pageable);
    }

    @Override
    public Page<Product> findProductByArticle(String article, Pageable pageable) {
        return productRepository.findProductByArticle(article, pageable);
    }

    @Override
    public Page<Product> findProductBySize(String size, Pageable pageable) {
        return productRepository.findProductBySize(size, pageable);
    }

    @Override
    public Page<Product> findProductByColor(String color, Pageable pageable) {
        return productRepository.findProductByColor(color, pageable);
    }


    public Page<Product> findByCategories(String category, Pageable pageable) {
        Optional<Category> c = categoryRepository.findById(category);
        if (c.isPresent()) {
            return productRepository.findByCategories(c.get(), pageable);
        }
        return Page.empty();
    }

    @Override
    public Long minProductPrice() {
        return productRepository.minProductPrice();
    }

    @Override
    public Long maxProductPrice() {
        return productRepository.maxProductPrice();
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }


    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
}
