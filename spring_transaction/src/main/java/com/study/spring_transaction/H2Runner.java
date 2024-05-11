package com.study.spring_transaction;

import com.study.spring_transaction.service.OuterService;
import com.study.spring_transaction.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class H2Runner implements ApplicationRunner {

    OuterService outerService;

    ProductService productService;

    @Autowired
    public H2Runner(OuterService outerService, ProductService productService) {
        this.outerService = outerService;
        this.productService = productService;
    }

    @Override
    public void run(ApplicationArguments args) {
        List<Map<String, String>> list = new ArrayList<>();
        list.add(Map.of("prodName", "냉장고", "prodPrice", "3000000"));
        list.add(Map.of("prodName", "텔레비전", "prodPrice", "3000000"));
        list.add(Map.of("prodName", "키보드", "prodPrice", "30000"));
        list.add(Map.of("prodName", "마우스", "prodPrice", "3000"));
        list.add(Map.of("prodName", "휴대폰", "prodPrice", "1000000"));
        list.add(Map.of("prodName", "컵", "prodPrice", "1000"));
        list.add(Map.of("prodName", "노트북", "prodPrice", "500000"));

        try {

            int result2 = outerService.addProductFromOuter(list);
            System.out.println("result2 : " + result2);

            List<Map> result = productService.findProductAllList();
            result.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
