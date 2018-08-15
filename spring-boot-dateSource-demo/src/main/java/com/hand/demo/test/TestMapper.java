package com.hand.demo.test;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/7/10.
 * @description
 */
@Mapper
@Component
public interface TestMapper {

    String querySang();

    String queryTest();
}
