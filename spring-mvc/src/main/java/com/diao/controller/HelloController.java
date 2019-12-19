package com.diao.controller;

import com.diao.bean.Account;
import com.diao.bean.People;
import com.diao.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;


@Controller
public class HelloController {

    @RequestMapping(path = "/hello", params = {"username"})
    public String sayHello() {
        System.out.println("SpringMVC");
        return "success";
    }

    @RequestMapping(path = "/params")
    public String say() {

        return "trans";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println(account.toString());
        return "success";
    }
    @RequestMapping("/saveUser")
    public String saveUser(User user, HttpServletRequest request, HttpServletResponse response){
        System.out.println(user.toString());
        HttpSession session = request.getSession();
        System.out.println(session);
        return "success";
    }
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "name",required = false) String uname){
        System.out.println(uname);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") String id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "accept") String header){
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println(cookie);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") People people){
        System.out.println(people);
        return "success";
    }
    /*@ModelAttribute
    public People getPeople(String name){
        System.out.println("ModelAttribute执行了");
        People people = new People();
        people.setName(name);
        people.setAge(20);
        Date date = new Date();
        people.setDate(date);
        return people;
    }*/
    @ModelAttribute
    public void getPeople(String name, Map<String,People> map){
        People people = new People();
        people.setName(name);
        people.setAge(20);
        people.setDate(new Date());
        map.put("abc",people);
    }

}
