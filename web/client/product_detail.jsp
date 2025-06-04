<%--
  Created by IntelliJ IDEA.
  User: zhu'ting'ting
  Date: 2025/5/28
  Time: 7:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>商品详情</title></head>
<body>
<h2>${product.name}</h2>
<p>价格：￥${product.price}</p>
<p>描述：${product.description}</p>
<p>浏览次数：${product.view_count}</p>
<a href="../product/list">返回列表</a>
<c:if test="${not empty sessionScope.user}">
    <a href="../favorite/add?id=${product.id}">加入收藏</a>
</c:if>
<hr>
<h3>商品留言</h3>

<!-- 展示评论列表 -->
<c:forEach var="c" items="${comments}">
    <div>
        <p>${c.content}</p>
        <small>发表于：${c.create_time}</small>
        <hr>
    </div>
</c:forEach>

<!-- 添加评论表单（仅限登录用户） -->
<c:if test="${not empty sessionScope.user}">
    <form method="post" action="../comment/add">
        <input type="hidden" name="product_id" value="${product.id}">
        <textarea name="content" rows="4" cols="50" placeholder="请输入留言内容"></textarea><br>
        <input type="submit" value="发表评论">
    </form>
</c:if>

</body>
</html>
