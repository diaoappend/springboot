package net.cnki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication注解来标注一个主程序类，说明这是一个SpringBoot应用
 */

@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        //启动SpringB应用
        SpringApplication.run(HelloWorldApplication.class, args);
    }

}
