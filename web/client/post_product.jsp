<%--
  Created by IntelliJ IDEA.
  User: zhu'ting'ting
  Date: 2025/5/28
  Time: 6:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>发布商品</title></head>
<body>
<h2>发布商品</h2>
<form method="post" action="../product/add">
  名称：<input name="name"><br>
  描述：<textarea name="description"></textarea><br>
  价格：<input name="price"><br>
  <input type="submit" value="发布">
</form>
</body>
</html>

