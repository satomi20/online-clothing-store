package com.daniel.sms.onlineclothingstore.controller;

import com.daniel.sms.onlineclothingstore.entity.Category;
import com.daniel.sms.onlineclothingstore.entity.Product;
import com.daniel.sms.onlineclothingstore.entity.User;
import com.daniel.sms.onlineclothingstore.service.CategoryService;
import com.daniel.sms.onlineclothingstore.service.ProductService;
import com.daniel.sms.onlineclothingstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//TODO: - создать поиск по категориям и находящимися в них товаров
//      - переход на карточку товара по айди после клика на нее
//      - обратная связь
//      - добавить переход к товарам по коллекциям*
//      - возможно создать возможность рассылок сообщений при подписке
//      - доделать остальные статичные странички по типу поддержки, о нас и тд.
//      в поддержке добавить возможность свзяи с админом

@Controller
public class HomeController {

    private final ProductService productService;

    private final UserService userService;

    private final CategoryService categoryService;

    @Autowired
    public HomeController(ProductService productService, UserService userService, CategoryService categoryService) {
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal User sessionUser) {
        /*if (sessionUser != null) {
            User user = userService.findUserById(sessionUser.getId());
            model.addAttribute("user", user);
        }*/
        List<Product> products = productService.findAll();
        model.addAttribute("prod", products);
        return "index";
    }

    @GetMapping("/aboutUs")
    public String about() {
        return "aboutUs";
    }

    @GetMapping("/faq")
    public String contact() {
        return "faq";
    }

    @GetMapping("/profile")
    public String userProfile() {
        return "user/profile";
    }
    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    public String collection(Model model){
        model.addAttribute("products", productService.findAll());
        return "collection";
    }

    @GetMapping("/search")
    public String search(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 12) Pageable pageable,
                         @RequestParam String filter, Model model) {
        Page<Product> products = productService.findByNameContaining(filter, pageable);
        model.addAttribute("products", products);
        return "shop";
    }

    /*@GetMapping("/category")
    public String categoryList(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "fragments/general";
    }*/

   /* @GetMapping("/shop/{id}")
    public String category(@PathVariable Long id, Model model, @PageableDefault(sort = {"category_id"}, direction = Sort.Direction.ASC, size = 12) Pageable pageable) {
        Page<Product> products = productService.findByCategoryId(id, pageable);
        int[] pagination = UtilController.computePagination(products);


        model.addAttribute("products", products);

        return "shop";
    }*/


    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable("id") Product product, Model model) {
        model.addAttribute("product", product);
        return "index";
    }


    /**
     * the method for feedback, the buyer writes a message and it is sent to the admin's email
     */
    public String mailSander() {
        return "mailSanders";
    }


}

