<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%@ include file="../common/header.jsp" %>
    <script type="text/javascript" src="static/javascript/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#sub_btn").click(function () {
                /**
                 * 验证用户名
                 * /(^[\u4E00-\u9FA5]{2,4}$)|(^\w{2,6}$)/
                 * 1. 中文 2~10
                 * 2. 字符 2~16(字符包括：大小写字母，下划线，中划线)
                 * 要么出现中文，要么只有字符
                 */
// 验证用户名格式
                var usernamePatt = /^[\u4E00-\u9FA5]{2,10}$|^[a-zA-Z_-]{2,16}$/;
                let usernameText = $("#username").val();
                if (!usernamePatt.test(usernameText)) {
                    $(".errorMsg").text("用户名不合法");
                    return false;
                }
// 验证密码格式
                var passwordPatt = /^[a-zA-Z0-9]{6,16}$/;
                let passwordText = $("#password").val();
                if (!passwordPatt.test(passwordText)) {
                    $(".errorMsg").text("密码不合法");
                    return false;
                }
// 确认密码
                let repwdText = $("#repwd")[0].value;
                if (repwdText != passwordText) {
                    $(".errorMsg")[0].innerText = "确认密码与密码不一致";
                    return false;
                }
// 验证邮箱格式
                var emailPatt = /^\w+@\w+\.[a-zA-Z]{3}(\.[a-zA-Z]{2})?$/;
                let emailText = $("#email").val();
                if (!emailPatt.test(emailText)) {
                    $(".errorMsg").text("邮箱格式错误");
                    return false;
                }
            })

// 验证码切换
            $("#verify").click(function () {
                /**
                 * 在事件响应的 function 函数中有一个 this 对象。这个 this 对象，是当前正在响应事件的 dom 对象
                 * src 属性表示验证码 img 标签的 图片路径。它可读，可写
                 * alert(this.src);
                 * @type {string}
                 */
                // this.src = "http://localhost/bookstore/verifycode.jpg?d=" + new Date();
                // 说是加上时间戳能跳过缓存，但是我下面这条也能实现啊！（🤔）
                this.src = this.src;
            })
        })
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">
    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>
    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <%-- 错误提示 --%>
                    <span class="errorMsg">${errorMsg}</span>
                </div>
                <div class="form">
                    <form action="/bookstore/register" method="post">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username" value="${username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password" value="${password}"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd" value="${repwd}"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email" value="${email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 100px;" name="code" id="code"/>
                        <img id="verify" alt="nothing" src="<%=basePath%>verifycode.jpg" style="float: right;
									margin-right: 40px; width: 80px; height: 40px;">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>