<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 设置动态 base，使得再ip访问和域名访问下程序均能正常运行 --%>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<base href="<%=basePath%>"/>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >