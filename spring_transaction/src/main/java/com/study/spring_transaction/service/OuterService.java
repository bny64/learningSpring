package com.study.spring_transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OuterService {

    private ProductService productService;

    @Autowired
    public OuterService(ProductService productService) {
        this.productService = productService;
    }

    public int addProductFromOuter(List<Map<String, String>> list) {
        int success = 0;
        int fail = 0;

        for (int i = 0; i < list.size(); i++) {
            try {
                Map<String, String> element = list.get(i);
                productService.addProduct(element);
                System.out.println(" i :" + i);
                success += 1;
            } catch (Exception e) {
                e.printStackTrace();
                fail += 1;
            }
        }

        return success;
    }
}
