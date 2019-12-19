package com.diao.bean;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/17 10:45
 * @description:
 * @version: 1.0
 */
public class StringToDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String s) {
        if(s==null){
            throw new RuntimeException("请传入参数");
        }
        try {
            DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dt.parse(s);
            return date;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
