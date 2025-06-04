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
    <title>校园二手市场 - 注册</title>
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
    <h2>用户注册</h2>
    <form action="<%=request.getContextPath()%>/RegisterServlet" method="post">
        <input type="text" name="username" placeholder="用户名" required>
        <input type="password" name="password" placeholder="密码" required>
        <input type="submit" value="注册">
    </form>
    <a class="switch-link" href="<%=request.getContextPath()%>/login.jsp">已有账号？去登录</a>
</div>
</body>
</html>
