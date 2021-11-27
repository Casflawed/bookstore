package com.flameking.web;

import com.flameking.service.UserService;
import com.flameking.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class RegisterServlet extends HttpServlet {
  UserService userService = new UserServiceImpl();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String email = req.getParameter("email");
    String code = req.getParameter("code");

// 获取 Session 中的验证码
    String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
// 删除 Session 中的验证码
    req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

    if (userService.registeredUsername(username)) {
      System.out.println("用户名已注册");
      resp.sendRedirect(req.getContextPath() + "/pages/user/register.html");
    } else if (userService.registeredEmail(email)) {
      System.out.println("邮箱已注册");
      resp.sendRedirect(req.getContextPath() + "/pages/user/register.html");
    }else if(token != null && token.equalsIgnoreCase(code)) {
// 注册成功
      userService.register(username, password, email);
      resp.sendRedirect(req.getContextPath() + "/pages/user/register_success.html");
    } else {
      resp.sendRedirect(req.getContextPath() + "/pages/user/register.html");
      System.out.println("验证码错误");
    }
  }
}
