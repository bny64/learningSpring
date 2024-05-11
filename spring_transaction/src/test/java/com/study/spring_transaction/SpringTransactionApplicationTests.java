package com.study.spring_transaction;

import com.study.spring_transaction.config.MybatisConfig;
import com.study.spring_transaction.service.OuterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application.properties")
class SpringTransactionApplicationTests {

    @Autowired
    private OuterService outerService;

    private final String PROD_NAME = "prodName";
    private final String PROD_PRICE = "prodPrice";

//    @Test
//    @DisplayName("일반적인 트랜잭션 테스트")
//    void transactionTest1() {
//        /*
//        for loop를 도는 경우 for loop 안에서 특정 인덱스에서 예외가 발생했을 때 기본 설정은 전역 롤백이기 때문에 하위 메서드에서
//         */
//        List<Map<String, String>> list = new ArrayList<>();
//        list.add(Map.of(PROD_NAME, "냉장고", PROD_PRICE, "3000000"));
//        list.add(Map.of(PROD_NAME, "텔레비전", PROD_PRICE, "3000000"));
//        list.add(Map.of(PROD_NAME, "키보드", PROD_PRICE, "30000"));
//        list.add(Map.of(PROD_NAME, "마우스", PROD_PRICE, "3000"));
//        list.add(Map.of(PROD_NAME, "휴대폰", PROD_PRICE, "1000000"));
//        list.add(Map.of(PROD_NAME, "컵", PROD_PRICE, "1000"));
//        list.add(Map.of(PROD_NAME, "노트북", PROD_PRICE, "500000"));
//
//        try {
//
//            int result2 = outerService.addProductFromOuter(list);
//            System.out.println("result2 : " + result2);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
