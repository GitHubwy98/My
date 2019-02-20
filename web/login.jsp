<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/28 0028
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="color: red">
    ${requestScope.errorMsg}
</div>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <table>
            <caption>用户登录</caption>
            <tr>
                <td>用户</td>
                <td><input type="text" name="user"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="pwd"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="password" name="pwd">
                    <img src="yzm?type=login">
                </td>
            </tr>
            <tr>
                <td rowspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>

    </form>
</body>
</html>
