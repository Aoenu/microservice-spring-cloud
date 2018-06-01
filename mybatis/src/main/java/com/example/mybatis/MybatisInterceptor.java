package com.example.mybatis;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/5/31.
 * @description
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
@Component
public class MybatisInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("拦截开始 ：");
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        System.out.println("拦截前sql : " + statementHandler.getBoundSql().getSql());

        BoundSql boundSql = statementHandler.getBoundSql();
        Field field = boundSql.getClass().getDeclaredField("sql");
        field.setAccessible(true);
        field.set(boundSql, boundSql.getSql() + " WHERE StudentId = 1");

        System.out.println("拦截后sql : " + statementHandler.getBoundSql().getSql());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        System.out.println("plugin :");
        System.out.println("target : " + o);
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("setProperties :");
    }
}
