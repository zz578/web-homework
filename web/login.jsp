<%--
  Created by IntelliJ IDEA.
  User: zhu'ting'ting
  Date: 2025/5/27
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>校园二手市场 - 登录</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/style.css">
    <style>
        body {
            background-image: url('<%=request.getContextPath()%>/static/images/logbk.jpeg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>用户登录</h2>
    <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
        <input type="text" name="username" placeholder="用户名" required>
        <input type="password" name="password" placeholder="密码" required>
        <input type="submit" value="登录">
    </form>
    <a class="switch-link" href="<%=request.getContextPath()%>/register.jsp">没有账号？去注册</a>
</div>
</body>
</html>
