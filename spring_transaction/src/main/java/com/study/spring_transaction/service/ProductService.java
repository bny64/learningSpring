package com.study.spring_transaction.service;

import com.study.spring_transaction.member.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductService {

    ProductMapper productMapper;

    @Autowired
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Map> findProductAllList() {
        return productMapper.findProductAllList();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int addProduct(Map<String, String> map) {

        String prodName = map.get("prodName");
        int result = 0;

        if ("노트북".equalsIgnoreCase(prodName)) {
            throw new RuntimeException("Runtime");
        }
        result = productMapper.addProduct(map);

        return result;
    }
}
