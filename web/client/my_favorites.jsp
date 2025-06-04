<%--
  Created by IntelliJ IDEA.
  User: zhu'ting'ting
  Date: 2025/5/28
  Time: 7:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>我的收藏</title></head>
<body>
<h2>我收藏的商品</h2>
<c:forEach var="p" items="${products}">
    <div>
        <h3><a href="../product/detail?id=${p.id}">${p.name}</a></h3>
        <p>价格：￥${p.price}</p>
    </div>
</c:forEach>
</body>
</html>

