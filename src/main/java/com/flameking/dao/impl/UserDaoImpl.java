package com.flameking.dao.impl;

import com.flameking.dao.BaseDao;
import com.flameking.dao.UserDao;
import com.flameking.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
  /**
   * 保存用户信息到数据库
   * @param user
   * @return 保存成功，返回影响的行数；<br/>否则返回-1；
   */
  @Override
  public int saveUser(User user) {
    String sql = "insert into t_user(username, password, email) VALUES(?, ?, ?)";
    return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
  }

  /**
   * 通过用户名查询用户
   * @param username
   * @return 查询成功返回 User 对象；<br/>否则返回 null；
   */
  @Override
  public User queryForUserByName(String username) {
    String sql = "select id, username, password, email from t_user where username=?";
    return queryForOne(User.class, sql, username);
  }

  /**
   * 根据用户名和密码查询用户
   * @param username
   * @param pwd
   * @return 查询成功返回 User 对象；<br/>否则返回 null；
   */
  @Override
  public User queryForUserByNameAndPassword(String username, String pwd) {
    String sql = "select id, username, password, email from t_user where username=? and password=?";
    return queryForOne(User.class, sql, username, pwd);
  }
}
