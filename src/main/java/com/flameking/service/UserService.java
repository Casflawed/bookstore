package com.flameking.service;

public interface UserService {
  /**
   * 登录
   * @param username 用户名
   * @param password 密码
   * @return 登录成功，返回 true；<br/>登录失败返回 false；
   */
  Boolean login(String username, String password);

  /**
   * 注册
   * @param username 用户名
   * @param password 密码
   * @param email 邮箱
   * @return 注册成功，返回 true；<br/>注册失败返回 false；
   */
  Boolean register(String username, String password, String email);

  /**
   * 用户名已注册
   * @param username
   * @return 已注册，返回 true；<br/>未注册，返回 false；
   */
  Boolean registeredUsername(String username);

  /**
   * 邮箱已注册
   * @param email
   * @return 已注册，返回 true；<br/>未注册，返回 false；
   */
  Boolean registeredEmail(String email);

}
