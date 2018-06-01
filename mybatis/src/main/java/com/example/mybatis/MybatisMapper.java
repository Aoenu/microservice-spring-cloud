package com.example.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/6/1.
 * @description
 */
@Mapper
@Component
public interface MybatisMapper {
    /**
     * @return
     */
    List<Student> mySelect();
}
