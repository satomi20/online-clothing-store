package com.daniel.sms.onlineclothingstore.controller;

import com.daniel.sms.onlineclothingstore.entity.Category;
import com.daniel.sms.onlineclothingstore.entity.Product;
import com.daniel.sms.onlineclothingstore.repository.CategoryRepository;
import com.daniel.sms.onlineclothingstore.repository.ProductRepository;
import com.daniel.sms.onlineclothingstore.service.ProductService;
import com.daniel.sms.onlineclothingstore.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
public class ShopController {

    private final ProductServiceImpl productService;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShopController(ProductServiceImpl productService, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @GetMapping
    public String shopList(Model model) {
        return allProducts(1,"id", "asc", model);
    }


   @GetMapping("/category/{id}")
    public String shopListByCategory(@PathVariable("id") Long id, Model model) {
        int pageSize = 5;
        int pageNo = 1;
        String sortField = "name";
        String sortDir = "asc";
        Page<Product> page = productService.findByCategoryId(id, pageNo, pageSize, sortField, sortDir);
        List<Product> productList = page.getContent();


       model.addAttribute("currentPage", pageNo);
       model.addAttribute("totalPages", page.getTotalPages());
       model.addAttribute("totalElements", page.getTotalElements());
       model.addAttribute("sortField", sortField);
       model.addAttribute("sortDir", sortDir);
       model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
       model.addAttribute("listProducts", productList);
       model.addAttribute("categoryId", id);
        return "shop";
    }

    @GetMapping("/products/{pageNo}")
    public String allProducts(@PathVariable (value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
                              @RequestParam("sortDir") String sortDir, Model model){
        int pageSize = 5;
        Page<Product> page = productService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Product> listProducts = page.getContent();


        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalElements", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listProducts", listProducts);
        return "shop";
    }

    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        List<Product> products = productService.findAll();
        model.addAttribute("prod", products);
        model.addAttribute("product", product);
        return "product";
    }









}

