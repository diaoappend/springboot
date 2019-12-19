package com.diao.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 控制连接工具类，用于从数据源中获取一个连接，并实现和线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl =new ThreadLocal<Connection>();

    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getConnection(){
        Connection conn = tl.get();
        try {
            if(conn==null){
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 将连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}

