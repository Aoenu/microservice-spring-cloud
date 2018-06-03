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
        //绑定代理对象。
        service = (HelloService) proxy.bind(service, new Class[] {HelloService.class});
        //这里service经过绑定，就会进入invoke方法里面了。
        service.sayHello("Proxy！");
    }
}
