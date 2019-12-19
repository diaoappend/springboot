<%--
  Created by IntelliJ IDEA.
  User: diao
  Date: 2019/12/16
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form action="saveAccount" method="post">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>
    用户姓名：<input type="text" name="user.name"/><br/>
    用户年龄：<input type="text" name="user.age"/><br/>
    <input type="submit" value="提交"/><br/>
</form>--%>
<form action="saveAccount" method="post">
用户名：<input type="text" name="username"/><br/>
密码：<input type="text" name="password"/><br/>
金额：<input type="text" name="money"/><br/>

用户姓名：<input type="text" name="user.name"/><br/>  <!--通过对象的属性名给指定属性赋值-->
用户年龄：<input type="text" name="user.age"/><br/>

用户姓名：<input type="text" name="list[0].name"/><br/>  <!--通过集合中指定元素的属性名给指定属性赋值-->
用户年龄：<input type="text" name="list[0].age"/><br/>

用户姓名：<input type="text" name="map['one'].name"/><br/>  <!--通过map中指定key的value的属性名给指定属性赋值-->
用户年龄：<input type="text" name="map['one'].age"/><br/>
<input type="submit" value="提交"/><br/>
</form>
</body>
</html>
