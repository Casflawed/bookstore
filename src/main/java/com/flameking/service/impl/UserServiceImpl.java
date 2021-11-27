package com.flameking.service.impl;
import com.flameking.dao.UserDao;
import com.flameking.dao.impl.UserDaoImpl;
import com.flameking.pojo.User;
import com.flameking.service.UserService;

public class UserServiceImpl implements UserService {
  UserDao userDao = new UserDaoImpl();

  /**
   * 登录
   * @param username 用户名
   * @param password 密码
   * @return 登录成功，返回 true；<br/>登录失败，返回 false
   */
  @Override
  public Boolean login(String username, String password) {
    return userDao.queryForUserByUsernameAndPassword(username, password) != null;
  }

  /**
   * 注册
   * @param username 用户名
   * @param password 密码
   * @param email 邮箱
   * @return 注册成功，返回 true；<br/>注册失败，返回 false
   */
  @Override
  public Boolean register(String username, String password, String email) {
    if ( !( registeredUsername(username) || registeredEmail(email) ) ){
      return userDao.saveUser(new User(null, username, password, email)) > 0;
    }else {
      return false;
    }
  }

  /**
   * 用户名已注册
   * @param username
   * @return 已注册，返回 true；<br/>未注册，返回 false；
   */
  @Override
  public Boolean registeredUsername(String username) {
    return userDao.queryForUserByUsername(username) != null;
  }

  /**
   * 邮箱已注册
   * @param email
   * @return 已注册，返回 true；<br/>未注册，返回 false；
   */
  @Override
  public Boolean registeredEmail(String email) {
    return userDao.queryForUserByEmail(email) != null;
  }
}
