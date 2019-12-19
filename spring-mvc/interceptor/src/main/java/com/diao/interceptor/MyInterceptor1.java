package com.diao.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/19 14:29
 * @description:
 * @version: 1.0
 */
public class MyInterceptor1 implements HandlerInterceptor {
    //预处理的方法，return true表示放行，执行下一个拦截器，如果没有，则执行controller中的方法；如果为false表示不放行，就不会执行controller中的方法，可以跳转到其他页面
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor.preHandle执行了222。。。");
        //request.getRequestDispatcher("/WEB-INF/pages/trans.jsp").forward(request,response);
        return true;
    }
    //后处理的方法，controller方法执行后，跳转到success页面前的处理方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor.postHandle执行了222。。。");
    }
    //最后处理的方法，success.jsp页面执行后才执行的这个方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor.afterCompletion执行了2222。。。");
    }
}
