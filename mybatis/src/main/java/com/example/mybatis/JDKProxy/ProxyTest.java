package com.example.mybatis.JDKProxy;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/6/1.
 * @description
 */
public class ProxyTest {
    public static void main(String[] args) {
        HelloServiceProxy proxy = new HelloServiceProxy();
        HelloService service = new HelloServiceImpl();
        service = (HelloService) proxy.bind(service, new Class[]{HelloServiceImpl.class});
        service.sayHello("Proxy!");
    }
}
