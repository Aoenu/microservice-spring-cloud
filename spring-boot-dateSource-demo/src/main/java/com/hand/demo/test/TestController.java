package com.hand.demo.test;

import com.hand.demo.datasource.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/7/10.
 * @description
 */
@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("/testDefalutDateSource")
    public String test() {
        return testMapper.querySang();
    }

    @GetMapping("/testDateSource1")
    @TargetDataSource("data1")
    public String test1() {
        return testMapper.queryTest();
    }

}
