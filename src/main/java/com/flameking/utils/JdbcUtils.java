package com.flameking.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtils {
  private static DruidDataSource dataSource;

  // 加载 jdbc.properties 文件，初始化数据连接池；
  static {
    InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
    try {
      Properties prop = new Properties();
      prop.load(inputStream);
      dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 获取连接池的连接
   * @return 获取连接失败，返回 null
   */
  public static Connection getConnection(){
    Connection conn = null;
    try {
      conn = dataSource.getConnection();
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    }
    return conn;
  }

  /**
   * 关闭连接，把连接还给连接池
   * @param conn
   */
  public static void close(Connection conn){
    if (conn != null){
      try {
        conn.close();
      } catch (SQLException throwable) {
        throwable.printStackTrace();
      }
    }
  }

}
