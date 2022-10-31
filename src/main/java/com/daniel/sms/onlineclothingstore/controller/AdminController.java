package com.daniel.sms.onlineclothingstore.controller;

import com.daniel.sms.onlineclothingstore.entity.*;
import com.daniel.sms.onlineclothingstore.service.*;
import com.daniel.sms.onlineclothingstore.service.impl.MySessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

//TODO: - дописать добавление нескольких фотографий и динамическое отображение их на сайте
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    private final UserAddressService userAddressService;

    private final ProductService productService;

    private final OrderService orderService;

    private final CategoryService categoryService;

    private final MySessionService mySessionService;

    private final ProductOptionService productOptionService;

    @Autowired
    public AdminController(UserService userService, UserAddressService userAddressService,
                           ProductService productService, OrderService orderService,
                           CategoryService categoryService, MySessionService mySessionService,
                           ProductOptionService productOptionService) {
        this.userService = userService;
        this.userAddressService = userAddressService;
        this.productService = productService;
        this.orderService = orderService;
        this.categoryService = categoryService;
        this.mySessionService = mySessionService;
        this.productOptionService = productOptionService;
    }

    @GetMapping("profile")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAll();
        List<Product> products = productService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("products", products);
        /*model.addAttribute("productOption", new ProductOption());
        model.addAttribute()
*/
        return "admin/adminPage";
    }

    @PostMapping("/remove/{user}")
    public String deleteUser(@PathVariable User user) {
        /*mySessionService.expireUserSessions(user.getEmail());*/
        userService.delete(user.getId());
        return "redirect:/admin/profile";
    }

    @GetMapping("/editProduct/{product}")
    public String editProduct(@PathVariable Product product, Category category, Model model) {
        List<ProductOption> options=  productOptionService.getProductOptionByProductId(product.getId());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("options", options);
        model.addAttribute("prod", product);
        model.addAttribute("discount", product.getPercentDiscount());
        model.addAttribute("oldprice", product.getOldPrice());
        model.addAttribute("category", product.getCategory().getCategoryId());
        model.addAttribute("categoryList", categories);
        return "admin/productCfg";
    }
    @PostMapping("/editProduct")
    public String editProduct(Product product) {
        Timestamp date = new Timestamp(new java.util.Date().getTime());
        productService.saveProductInfoById(product.getName(), product.getUrlName(), product.getArticle(),
                product.getDescription(), product.getImagePath(), product.getColor(),
                product.getSale(), product.getNew_product(), date, product.getId());
        return "redirect:/admin/profile";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "admin/addToDb";
    }
    @PostMapping("/addProduct")
    public String addProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        Timestamp date = new Timestamp(new java.util.Date().getTime());
        product.setCategory(categoryService.findById(1L));
        product.setCreatedAt(date);
        product.setNew_product(true);
        product.setSale(false);
        if (bindingResult.hasErrors()) {
            return "admin/addToDb";
        }
        productService.saveProduct(product);
        return "redirect:/admin/profile";
    }

    @GetMapping("/deleteProduct/{product}")
    public String deleteProduct(@PathVariable Product product) {
        productService.delete(product.getId());
        return "redirect:/admin/profile";
    }

    @PostMapping("/addDiscount")
    public String addDiscount(Product product, @RequestParam("oldPrice") Long oldPrice,
                                               @RequestParam("discount") Long discount,
                                                BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()){
            return "error";
        }else{
            productService.addDiscount(product, discount, oldPrice, product.getId());
        }
        return "redirect:/admin/profile";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(Product product, @RequestParam("categoryId") Long categoryId) throws Exception{
       productService.updateCategoryById(categoryId, product.getId());

        return "redirect:/admin/profile";
    }

    @GetMapping("/editProduct/{product}/{option}")
    public String updateProductOption(@PathVariable Product product, @PathVariable ProductOption option, Model model) {
        /*optionId = option.getSku();*/
        model.addAttribute("opt", option);
        model.addAttribute("prod", product);
        model.addAttribute("size", option.getSize());
        model.addAttribute("quantity", option.getQuantity());
        model.addAttribute("sku", option.getSku());

        return "admin/options";
    }
    @PostMapping("/updateProductOption")
    public String updateProductOption(ProductOption option, @RequestParam("sku") Long sku,
                                      @RequestParam("size") String size, @RequestParam("quantity") Long quantity){
        productOptionService.updateProductOptionByProductId(sku, size, quantity, option.getId());
        return "redirect:/admin/profile";
    }

    @GetMapping("/addNewOption/{product}")
    public String addNewOption(@PathVariable Product product, ProductOption option, Model model) {
        model.addAttribute("prod", product);
        model.addAttribute("productOption", new ProductOption());
        model.addAttribute("opt", option);
        return "admin/options";
    }
    @PostMapping("/addNewOption")
    public String addNewOption(Product product, @Valid @ModelAttribute("productOption")ProductOption option, RedirectAttributes attributes) throws Exception{
        try {
            productOptionService.saveByProduct(option.getSku(), option.getSize(), option.getQuantity(), product.getId());
            attributes.addFlashAttribute("success", "Option added successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Option already exists");
        }
        return "redirect:/admin/profile";
    }

    @PostMapping("/removeOption/{option}")
    public String removeOption(@PathVariable ProductOption option) {
        productOptionService.deleteProductOptionById(option);
        return "redirect:/admin/profile";
    }

}
