<%--
  Created by IntelliJ IDEA.
  User: diao
  Date: 2019/12/17
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.7.2.js"></script>

    <script>
        $(function () {
            $("#btn").click(function () {
                alert("弹框")
            /*   $.ajax({
                   //编写json格式，设置属性和值
                   url:"testAjax",
                   contentType:"application/json;charset=UTF-8",
                   date:'{"name":"zhangsan","age":20,"date":"2019/12/18"}',
                   dateType:"json",
                   type:"post",
                   success:function (data) {
                       //data为服务器响应的json数据，进行解析
                   }
               })*/
            })
        })
    </script>
</head>
<body>
<%--<a href="testString">testString</a>--%>

<button id="btn">发送ajax请求</button>
</body>
</html>
