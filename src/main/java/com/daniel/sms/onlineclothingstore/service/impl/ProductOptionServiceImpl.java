package com.daniel.sms.onlineclothingstore.service.impl;

import com.daniel.sms.onlineclothingstore.entity.Product;
import com.daniel.sms.onlineclothingstore.entity.ProductOption;
import com.daniel.sms.onlineclothingstore.repository.ProductOptionRepository;
import com.daniel.sms.onlineclothingstore.service.ProductOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductOptionServiceImpl implements ProductOptionService {

    private final ProductOptionRepository productOptionRepository;

    @Autowired
    public ProductOptionServiceImpl(ProductOptionRepository productOptionRepository) {
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    public List<ProductOption> getProductOptionByProductId(Long id) {
        return productOptionRepository.getProductOptionByProductId(id);
    }

    @Override
    public void updateProductOptionByProductId(Long sku, String size, Long quantity, Long id) {
        productOptionRepository.updateProductOptionByProductId(sku, size, quantity, id);
    }

    @Override
    @Transactional
    public void saveByProduct(Long sku, String size, Long quantity, Long id) {
        productOptionRepository.save(sku,size, quantity, id);
    }

    @Override
    public void deleteProductOptionById(ProductOption productOption) {
        productOptionRepository.deleteProductOptionById(productOption.getId());
    }


}
