<%--
  Created by IntelliJ IDEA.
  User: zhu'ting'ting
  Date: 2025/5/28
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>个人中心</title>
    <link rel="stylesheet" href="../static/css/style.css">
    <style>
        .section {
            padding: 30px;
        }

        h2 {
            border-bottom: 2px solid #ccc;
            padding-bottom: 10px;
            color: #444;
        }

        h3 {
            margin-top: 30px;
            color: #5d4037;
        }

        .item-box {
            margin: 10px 0;
        }

        .more-link {
            display: inline-block;
            margin-top: 5px;
            color: #007bff;
            text-decoration: none;
        }

        .more-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="section">
    <h2>👤 个人中心</h2>

    <!-- 发布商品 -->
    <h3>🛒 发布商品</h3>
    <c:forEach var="p" items="${myProducts}" varStatus="s">
        <c:if test="${s.index < 3}">
            <div class="item-box">
                <a href="product_detail.jsp"id=${p.id}>${p.name}</a> - ￥${p.price}
            </div>
        </c:if>
    </c:forEach>
    <a href="post_product.jsp" class="more-link">查看更多 ></a>

    <!-- 我收藏的商品 -->
    <h3>⭐ 我的收藏</h3>
    <c:forEach var="f" items="${myFavorites}" varStatus="s">
        <c:if test="${s.index < 3}">
            <div class="item-box">
                <a href="../product/detail?id=${f.id}">${f.name}</a> - ￥${f.price}
            </div>
        </c:if>
    </c:forEach>
    <a href="../client/my_favorites.jsp" class="more-link">查看更多 ></a>

    <!-- 我的评论 -->
    <h3>💬 我的评论</h3>
    <c:forEach var="c" items="${myComments}">
        <div class="item-box">
            <p>${c.content}</p>
            <small>评论时间：${c.create_time}</small>
            <hr>
        </div>
    </c:forEach>
</div>
</body>
</html>
