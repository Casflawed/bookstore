package com.flameking.dao;

import com.flameking.dao.impl.UserDaoImpl;
import com.flameking.pojo.User;
import org.junit.Test;

/**
 * UserDao 接口测试类
 */
public class UserDaoTest {
  UserDao userDao = new UserDaoImpl();

  @Test
  public void saveUserTest(){
    User admin = new User(null, "flameking", "123456", "2711554770@qq.com");
    if (userDao.saveUser(admin) > 0){
      System.out.println("保存用户成功");
    }else{
      System.out.println("保存用户失败");
    }
  }

  @Test
  public void ifForUserByNameTest(){
    if (userDao.queryForUserByUsername("wangwei123456") != null){
      System.out.println("用户名不可用");
    }else{
      System.out.println("用户名可用");
    }
  }

  @Test
  public void queryForUserByNameAndPasswordTest(){
    if (userDao.queryForUserByUsernameAndPassword("wangwei", "13017162472") != null) {
      System.out.println("查询成功");
    }else{
      System.out.println("用户名不存在或密码错误");
    }
  }
}
