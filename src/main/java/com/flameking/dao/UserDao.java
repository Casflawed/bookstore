package com.flameking.dao;

import com.flameking.pojo.User;

public interface UserDao {
  /**
   * 保存用户信息到数据库
   * @param user
   * 保存成功，返回影响的行数；<br/>否则返回-1；
   */
  int saveUser(User user);

  /**
   * 查询用户名
   * @param username
   * @return 查询成功返回 User 对象；<br/>否则返回 null；
   */
  User queryForUserByUsername(String username);

  /**
   * 查询邮箱
   * @param email
   * @return 查询成功返回 User 对象；<br/>否则返回 null；
   */
  User queryForUserByEmail(String email);

  /**
   * 根据用户名和密码查询用户
   * @param username
   * @param password
   * @return 查询成功返回 User 对象；<br/>否则返回 null；
   */
  User queryForUserByUsernameAndPassword(String username, String password);
}
