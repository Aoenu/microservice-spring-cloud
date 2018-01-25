package com.hand.spring.test.exception.handler;

import com.hand.spring.test.exception.dto.ErrorInfo;
import com.hand.spring.test.exception.dto.TestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/1/25.
 * @description
 */
@RestControllerAdvice
public class CommonExceptionHandler {
    private static final String SYS_EXCEPTION_CODE = "000000";
    private Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    public CommonExceptionHandler() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ErrorInfo<String> exceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) {
        this.logger.error("请求失败", exception);
        ErrorInfo<String> r = new ErrorInfo<>();
        if (exception instanceof TestException) {
            r.setMessage(exception.getMessage());
            r.setCode(ErrorInfo.ERROR);
            r.setData("TestException Data");
            r.setUrl(request.getRequestURL().toString());
        }else {
            r.setMessage(exception.getMessage());
            r.setCode(ErrorInfo.ERROR);
            r.setData("Some Data");
            r.setUrl(request.getRequestURL().toString());
        }
        return r;
    }
}
