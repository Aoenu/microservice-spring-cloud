package com.hand.demo.datasource;

import java.lang.annotation.*;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/7/10.
 * @description 在方法上使用，用于指定使用哪个数据源
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
