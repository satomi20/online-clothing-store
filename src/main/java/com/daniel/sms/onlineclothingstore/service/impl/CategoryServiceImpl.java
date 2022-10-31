package com.daniel.sms.onlineclothingstore.service.impl;

import com.daniel.sms.onlineclothingstore.entity.Category;
import com.daniel.sms.onlineclothingstore.entity.Product;
import com.daniel.sms.onlineclothingstore.repository.CategoryRepository;
import com.daniel.sms.onlineclothingstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findByCategoryId(id);
    }

    /*

    @Override
    public void updateCategory(String name,Long id){
        categoryRepository.updateCategory(name,id);
    }
*/

    /*public void saveByProduct(Product product, Category category){
        category.setProduct(product);
        categoryRepository.save(category);
    }*/
}
