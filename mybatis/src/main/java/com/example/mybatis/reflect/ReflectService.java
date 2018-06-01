package com.example.mybatis.reflect;

import java.lang.reflect.Method;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/6/1.
 * @description
 */
public class ReflectService {
    /**
     * 服务方法
     * @param name -- 姓名
     */
    public void sayHello(String name) {
        System.err.println("hello " + name);
    }

    public static void main(String[] args) throws Exception{
        // 通过类名类路径获取类的实例
        Object service = Class.forName("com.example.mybatis.reflect.ReflectService").newInstance();
        // 通过类的实例获取类  在通过方法名参数获取类的方法的实例
        Method method = service.getClass().getMethod("sayHello",String.class);
        // 这个相当于方法占主导地位，  方法 实例 参数
        method.invoke(service,"reflect!");
    }

}
