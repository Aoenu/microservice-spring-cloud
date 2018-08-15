package com.hand.demo.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/7/10.
 * @description 切换数据源
 */
@Aspect
@Order(-10) // 保证AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {


    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    /**
     * “@before” :在方法执行之前执行
     * “@annotation(targetDataSource)” ：会拦截加上注解targetDataSource的方法
     *
     * @param joinPoint
     * @param targetDataSource
     */
    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        // 获取当前指定的数据源
        String dataSourceName = targetDataSource.value();
        // 如果注解的数据源不在配置注入的所有数据源范围中，则输出警告信息，并使用默认数据源
        if (!DynamicDataSourceContextHolder.containsDataSource(dataSourceName)) {
            logger.error("数据源[{}]不存在，使用默认数据源 > {}", targetDataSource.value(), joinPoint.getSignature());
        } else {
            logger.debug("切换数据源Use DataSource : {} > {}", targetDataSource.value(), joinPoint.getSignature());
            // 数据源存在 并设置到动态数据源的上下文中
            DynamicDataSourceContextHolder.setDataSourceType(dataSourceName);
        }
    }

    @After("@annotation(targetDataSource)")
    public void resetDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        logger.debug("Reset DateSource : {} > {}", targetDataSource.value(), joinPoint.getSignature());
        // 方法执行完毕后 销毁当前数据源信息，进行垃圾回收
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}
