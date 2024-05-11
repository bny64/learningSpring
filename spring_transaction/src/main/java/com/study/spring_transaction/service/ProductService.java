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

    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Map<String, String>> findProductAllList() {
        return productMapper.findProductAllList();
    }

    /**
     * 해당 메서드는 현재 메서드에서 예외를 잡기 때문에 for loop를 도는 동안 모두 정상적으로 커밋된다.
     *
     * @param map
     * @return
     */
    public int addProductCatchCurrentMethod(Map<String, String> map) {

        String prodName = map.get("prodName");
        int result = 0;

        try {
            result = productMapper.addProduct(map);

            if ("휴대폰".equalsIgnoreCase(prodName)) {
                throw new RuntimeException("휴대폰 Error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 해당 메서드는 상위 메서드에서 예외를 잡기 때문에 for loop를 돈 후 예외가 발생해서 모두 롤백된다.
     * @param map
     * @return
     */
    public int addProductCatchUpperMethod(Map<String, String> map) {

        String prodName = map.get("prodName");
        int result = 0;

        result = productMapper.addProduct(map);

        if ("휴대폰".equalsIgnoreCase(prodName)) {
            throw new RuntimeException("휴대폰 Error");
        }

        return result;
    }
}
