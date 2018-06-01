package com.example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/6/1.
 * @description
 */
@RestController
public class MybatisController {

    @Autowired
    private MybatisMapper mybatisMapper;

    @RequestMapping("/mySelect")
    public void mySelect() {
        List<Student> students = mybatisMapper.mySelect();
        students.forEach(student -> {
            System.out.println(student.toString());
        });
    }
}
