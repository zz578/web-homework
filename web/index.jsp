<%--
  Created by IntelliJ IDEA.
  User: zhu'ting'ting
  Date: 2025/5/27
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: zhu'ting'ting
  Date: 2025/5/27
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>校园二手交易平台 - 首页</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        .navbar { background-color: #333; padding: 10px; }
        .navbar a { color: white; margin: 0 15px; text-decoration: none; }
        .section { padding: 20px; }
        h2 { border-bottom: 1px solid #ccc; padding-bottom: 10px; }
        .item-box { margin-bottom: 10px; }
    </style>
</head>
<body>

<!-- 顶部导航 -->
<div class="navbar">
    <a href="index.jsp">🏠 首页</a>
    <a href="login.jsp">登录</a>
    <a href="register.jsp">注册</a>
    <a href="client/center">个人中心</a>
    <a href="post_product.jsp">发布商品</a>
    <a href="client/my_favorites.jsp">我的收藏</a>
    <a href="product/hot">热度排行</a>
    <a href="product/list">商品浏览</a>
</div>

<!-- 公告栏 -->
<div class="section">
    <h2>📢 公告</h2>
    <p>欢迎使用校园二手交易平台！请注意交易安全，避免线下支付风险。</p>
</div>

<!-- 热度排行区域 -->
<div class="section">
    <h2>🔥 热门商品排行</h2>
    <c:forEach var="p" items="${hotList}">
        <div class="item-box">
            <a href="product/detail?id=${p.id}">${p.name}</a> - ￥${p.price}
        </div>
    </c:forEach>
</div>

<!-- 评论热区（最近留言） -->
<div class="section">
    <h2>💬 评论热区</h2>
    <c:forEach var="c" items="${commentList}">
        <div class="item-box">
            <p>${c.content}</p>
            <small>评论时间：${c.create_time}</small>
            <hr>
        </div>
    </c:forEach>
</div>

</body>
</html>