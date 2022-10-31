package com.daniel.sms.onlineclothingstore.service.impl;

import com.daniel.sms.onlineclothingstore.entity.Category;
import com.daniel.sms.onlineclothingstore.entity.Product;
import com.daniel.sms.onlineclothingstore.entity.ProductOption;
import com.daniel.sms.onlineclothingstore.repository.CategoryRepository;
import com.daniel.sms.onlineclothingstore.repository.ProductRepository;
import com.daniel.sms.onlineclothingstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
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
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
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
    public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findByPriceBetween(Integer startingPrice, Integer endingPrice, Pageable pageable) {
        return productRepository.findByPriceBetween(startingPrice, endingPrice, pageable);
    }

    @Override
    public Page<Product> findProductByArticle(String article, Pageable pageable) {
        return productRepository.findProductByArticle(article, pageable);
    }

    @Override
    public Page<Product> findByColor(String color, Pageable pageable){
        return productRepository.findByColor(color, pageable);
    }

    public Page<Product> findByCategoryId(Long categoryId, int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.productRepository.findByCategoryId(categoryId, pageable);
    }

    @Override
    public List<Product> getProductOrderByPriceMax() {
        return productRepository.getProductOrderByPriceMax();
    }

    @Override
    public List<Product> getProductOrderByPriceMin() {
        return productRepository.getProductOrderByPriceMin();
    }

    @Override
    public List<Product> getProductOrderByPsOrderByPercentDiscountMax() {
        return productRepository.getProductOrderByPriceMin();
    }

    @Override
    public List<Product> getProductOrderByPsOrderByPercentDiscountMin() {
        return productRepository.getProductOrderByPriceMin();
    }

    @Transactional
    public void newPrice(Product product, Long price){
        product.setOldPrice(price);
        System.out.println(product.getOldPrice());
    }

    public static void main(String[] args) {
        Product product = new Product();
        ProductServiceImpl productService = new ProductServiceImpl(null, null);
        productService.newPrice(product, 100L);
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void saveProductInfoById(String name, String urlName, String  article, String description, String imagePath, String color,
                                    Boolean sale, Boolean newProd, Timestamp updateDate, Long id){
        productRepository.saveProductInfoById(name, urlName, article, description,
                imagePath, color, sale, newProd, updateDate, id);
    }

    @Override
    public void addDiscount(Product product, Long discount, Long oldPrice, Long id){
            productRepository.addDiscountToOldPrice(discount, oldPrice, id);
            Long price = product.getOldPrice() - (product.getOldPrice() * discount / 100);
            productRepository.updateDiscountPrice(price, id);
    }

    @Override
    public void updateCategoryById( Long categoryId, Long id){
        productRepository.updateCategoryById(categoryId, id);
    }



    @Override
    @Transactional
    public void delete(Long id){
        productRepository.deleteById(id);
    }

    /*@Override
    public void addDiscountToOldPrice(Product product, Long percentDiscount, Long id) throws NullPointerException{
        try {
            Long price = product.getOldPrice() - (product.getOldPrice() * percentDiscount / 100);
            productRepository.addDiscountToOldPrice(percentDiscount, product.getOldPrice(), price, id);
        }catch (NullPointerException exception) {
            System.out.println("Exception was processed. Program continues");
        }
    }*/


    /* public void saveProductOption(Product product, ProductOption productOption, ){
        product.setProductOptions(productOption);
        productRepository.save(product);
    }*/


   /* public void saveProductByCategory(Product product, Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            product.setCategory(category.get());
            productRepository.save(product);
        }
    }*/


}
