package com.ljw.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@org.aspectj.lang.annotation.Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER= LoggerFactory.getLogger("HttpAspect");

    @Before("log()")
    public void doBefore() {
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest=servletRequestAttributes.getRequest();
        LOGGER.info("url{}",httpServletRequest.getRequestURL());
        LOGGER.info("method{}",httpServletRequest.getMethod());
    }

    @After("log()")
    public void doAfter() {
        LOGGER.info("22222222222222");
    }


    @Pointcut(value = "execution(public * com.ljw.demo.GirlController.*(..))")
    public void log() {

    }
}
