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

// 表单回显
    req.setAttribute("username", req.getParameter("username"));
    req.setAttribute("email", req.getParameter("email"));
    req.setAttribute("password", req.getParameter("password"));
    req.setAttribute("repwd", req.getParameter("repwd"));

    if (userService.registeredUsername(username)) {
      req.setAttribute("errorMsg", "用户名已注册");
      req.getRequestDispatcher("/pages/user/register.jsp").forward(req,resp);
    } else if (userService.registeredEmail(email)) {
      req.setAttribute("errorMsg", "邮箱已注册");
      req.getRequestDispatcher("/pages/user/register.jsp").forward(req,resp);
    }else if(token != null && token.equalsIgnoreCase(code)) {
// 注册成功
      userService.register(username, password, email);
// 防止表单重复提交
      resp.sendRedirect(req.getContextPath() + "/pages/user/register_success.jsp");
    } else {
      req.setAttribute("errorMsg", "验证码错误");
      req.getRequestDispatcher("/pages/user/register.jsp").forward(req,resp);
    }
  }
}
