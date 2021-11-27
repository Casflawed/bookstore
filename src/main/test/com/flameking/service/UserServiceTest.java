package com.flameking.service;

import com.flameking.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {

  UserService userService = new UserServiceImpl();
  @Test
  public void login() {
    if (userService.login("admin", "admin")){
      System.out.println("登录成功");
    }else {
      System.out.println("登录失败");
    }
  }

  @Test
  public void register() {
    if (userService.register("yuehonghao", "123456", "654321@qq.com")) {
      System.out.println("注册成功");
    }else{
      System.out.println("注册失败");
    }
  }

  @Test
  public void registeredUsername() {
    if (userService.registeredUsername("wangwei")){
      System.out.println("用户名已经注册");
    }else {
      System.out.println("用户名可用");
    }
  }

  @Test
  public void registeredEmail() {
    if (userService.registeredEmail("123456@qq.com")) {
      System.out.println("邮箱已经注册");
    }else{
      System.out.println("可用邮箱");
    }
  }
}