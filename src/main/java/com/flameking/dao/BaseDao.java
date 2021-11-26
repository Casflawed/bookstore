package com.flameking.dao;

import com.flameking.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * BaseDao 一般被用来复用代码，因此定义为抽象类
 */
public abstract class BaseDao {
  private QueryRunner queryRunner = new QueryRunner();

  /**
   * 通用 insert/delete/update 方法
   * @param sql
   * @param args
   * @return 无效的更新，返回-1；<br/>有效更新，返回影响的行数
   */
  public int update(String sql, Object... args){
    Connection conn = JdbcUtils.getConnection();
    try {
      return queryRunner.update(conn, sql, args);
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    }finally {
      JdbcUtils.close(conn);
    }
    return -1;
  }

  /**
   * 查询一条记录，返回一个 Bean 对象
   * @param type Class 对象
   * @param sql
   * @param args
   * @param <T>
   * @return 查询失败，返回 null；
   */
  public <T> T queryForOne(Class<T> type, String sql, Object... args){
    Connection conn = JdbcUtils.getConnection();
    try {
      return queryRunner.query(conn, sql, new BeanHandler<>(type), args);
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    } finally {
      JdbcUtils.close(conn);
    }
    return null;
  }

  /**
   * 查询多条记录,返回多个 Bean 对象
   * @param type
   * @param sql
   * @param args
   * @param <T>
   * @return 查询失败，返回 null；
   */
  public <T> List<T> queryForList(Class<T> type, String sql, Object... args){
    Connection conn = JdbcUtils.getConnection();
    try {
      return queryRunner.query(conn, sql, new BeanListHandler<>(type), args);
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    } finally {
      JdbcUtils.close(conn);
    }
    return null;
  }

  /**
   * 查询某个字段的值
   * @param sql
   * @param agrs
   * @return 查询失败，返回 null；
   */
  public Object queryForSingleValue(String sql, Object... agrs){
    Connection conn = JdbcUtils.getConnection();
    try {
      return queryRunner.query(conn, sql, new ScalarHandler<>(), agrs);
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    } finally {
      JdbcUtils.close(conn);
    }
    return null;
  }
}
