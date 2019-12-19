package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


/**
 * 配置类
 */
@Configuration //表明该类是配置类
@ComponentScan(value = "com.diao") //指定扫描的包，属性包括value和basePackages，两个可以互换，作用一致，后面是一个数组，如果只有一个元素，{}可省略
@Import(JdbcConfig.class)//将其他配置类导入主配置类，这样即使其他类不加@Configuration注解，也不是AnnotationConfigApplicationContext创建对象的参数时，也可以将配置信息注入容器
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {


}
