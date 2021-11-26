package com.flameking.dao;

import com.flameking.pojo.User;

public interface UserDao {
  /**
   * 保存用户信息到数据库
   * @param user
   */
  int saveUser(User user);

  /**
   * 根据用户名查询用户
   * @param name
   * @return
   */
  User queryForUserByName(String name);

  /**
   * 根据用户名和密码查询用户
   * @param name
   * @param pwd
   * @return
   */
  User queryForUserByNameAndPassword(String name, String pwd);
}
