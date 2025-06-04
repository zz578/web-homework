<%--
  Created by IntelliJ IDEA.
  User: zhu'ting'ting
  Date: 2025/5/28
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>热度排行榜</title></head>
<body>
<h2>🔥 热门商品排行榜</h2>
<c:forEach var="p" items="${hotList}">
    <div>
        <h3><a href="../product/detail?id=${p.id}">${p.name}</a></h3>
        <p>价格：￥${p.price}</p>
    </div>
</c:forEach>
</body>
</html>
