package com.diao.factory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Properties prop = null;
    private static Map<String,Object> beans;
    /**
     * 静态代码块中初始化Properties对象和创建bean对象
     */
    static {
        try{
            prop = new Properties();
            InputStream in = BeanFactory.class.getResourceAsStream("/beans.properties");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            prop.load(bufferedReader);
            beans = new HashMap<String,Object>();
            Enumeration<Object> keys = prop.keys();
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanPath = prop.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }

        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化Properties失败！");
        }
    }

    /**
     * 根据key获取map中bean对象的方法
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){

        String beanPath = prop.getProperty(beanName);

        return beans.get(beanName);
    }
}
