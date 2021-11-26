package com.flameking.dao;

import com.flameking.dao.impl.UserDaoImpl;
import com.flameking.pojo.User;
import org.junit.Test;

public class UserDaoImplTest {
  private UserDaoImpl userDaoImpl = new UserDaoImpl();

  @Test
  public void saveUserTest(){
    User admin = new User(null, "admin123", "123456", "2711554770@qq.com");
    System.out.println(userDaoImpl.saveUser(admin));
  }

  @Test
  public void queryForUserByNameTest(){
    System.out.println(userDaoImpl.queryForUserByName("flameking"));
  }

  @Test
  public void queryForUserByNameAndPasswordTest(){
    System.out.println(userDaoImpl.queryForUserByNameAndPassword("wangwei", "13017162472"));
  }
}
