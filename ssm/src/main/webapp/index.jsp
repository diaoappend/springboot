<%--
  Created by IntelliJ IDEA.
  User: diao
  Date: 2019/12/19
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="findAll">测试查询</a>
<h3>测试保存</h3>
<form action="saveAccount" method="post">
    姓名：<input type="text" name="name" /><br/>
    金额：<input type="text" name="money" /><br/>
    <input type="submit" value="保存"/><br/>
</form>
</body>
</html>
