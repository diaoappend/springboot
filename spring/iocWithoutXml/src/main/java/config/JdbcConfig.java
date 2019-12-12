package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import javax.validation.Valid;

public class JdbcConfig {
    //为了避免连接信息写死，用添加配置文件和@Value注解加SpEL表达式的方式注入连接信息，但前提是配置类要加@PropertyResource("配置文件")指明配置文件
    @Value("${jdbc.driver}")
    private String driver ;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;
    /*以前配置文件中的如下配置可以通过下面的方法来返回指定对象，通过构造器构造
    <bean id="runner" class="org.apache.commons.dbutils.QueryRunner" scope="prototype">
       <!--注入数据源-->
       <constructor-arg name="ds" ref="dataSource"></constructor-arg>
   </bean>

   <!-- 配置数据源 -->
   <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
       <!--连接数据库的必备信息-->
       <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
       <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/account"></property>
       <property name="user" value="root"></property>
       <property name="password" value="root"></property>
   </bean>*/
    @Bean(name = "runner") //用于把当前方法的返回值作为bean对象存入spring的Ioc容器中
    @Scope("prototype") //声明QueryRunner对象为多例
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        /*
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/account");
            ds.setUser("root");
            ds.setPassword("root");
            return ds;
        } catch (Exception e) {
            throw new RuntimeException();
        }*/

        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
