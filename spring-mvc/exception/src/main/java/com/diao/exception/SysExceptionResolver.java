package com.diao.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/19 9:39
 * @description:异常处理器
 * @version: 1.0
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常的业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e 这里的e对象就是抛出的SysException对象
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取异常对象
        SysException ex = null;
        if(e instanceof SysException){
            ex = (SysException)e;
        }else {
            new SysException("系统正进行维护。。");
        }
        //创建ModelAndView对象并添加异常对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errMsg",ex.getMessage());
        //跳到哪个页面，会经过视图解析器处理
        modelAndView.setViewName("error");
        return modelAndView;


    }
}
