package com.study.spring_transaction.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    List<Map> findProductAllList();
    int addProduct(Map map);
}
