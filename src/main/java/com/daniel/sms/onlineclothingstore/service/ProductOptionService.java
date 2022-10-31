package com.daniel.sms.onlineclothingstore.service;

import com.daniel.sms.onlineclothingstore.entity.Product;
import com.daniel.sms.onlineclothingstore.entity.ProductOption;

import java.util.List;

public interface ProductOptionService {
    List<ProductOption> getProductOptionByProductId(Long id);
    void updateProductOptionByProductId(Long sku, String size, Long quantity, Long id);
    void saveByProduct(Long sku, String size, Long quantity, Long id);
    /*void deleteProductOptionById(Long id);*/
    void deleteProductOptionById(ProductOption productOption);


}
