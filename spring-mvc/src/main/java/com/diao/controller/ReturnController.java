package com.diao.controller;

import com.diao.bean.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/17 18:28
 * @description:
 * @version: 1.0
 */
@Controller
public class ReturnController {
    @RequestMapping("/testString")
    public String testString(Model model) {
        People people = new People();
        people.setDate(new Date());
        people.setName("tom");
        people.setAge(20);
        //通过model对象将people对象保存到request的域中，然后在页面上通过request的域将对象取出
        model.addAttribute("peo", people);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行");
        //编写请求转发的程序，不会通过视图解析器，所以要写jsp文件的全路径
        //request.getRequestDispatcher("WEB-INF/pages/success.jsp").forward(request,response);
        //response.sendRedirect(request.getContextPath()+"/response.jsp");
        //解决中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接进行响应
        response.getWriter().print("直接进行响应");
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mv = new ModelAndView();
        People people = new People();
        people.setDate(new Date());
        people.setName("tom");
        people.setAge(20);
        //把people对象存到mv对象中，也会把people对象存入到request域对象中
        mv.addObject("people",people);
        //还可以设置跳转到哪个页面，会经过视图解析器
        mv.setViewName("success");
        return mv;
    }
    @RequestMapping("/testAjax")
    public void  testAjax(@RequestBody String people){
        System.out.println(people);
    }
}
