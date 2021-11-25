package com.flameking.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
  private static DruidDataSource dataSource;

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
   * 返回 null 说明获取连接失败
   * @return
   */
  public static Connection getConnection(){
    Connection conn = null;
    try {
      conn = dataSource.getConnection();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return conn;
  }

  public static void close(Connection conn){
    if (conn != null){
      try {
        conn.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }

}
