<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/28 0028
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="reg" method="post">
    <table>
            <caption>用户注册</caption>
        <tr>
            <td>账号</td>
            <td><input type="text" name="user" id="username" onblur="jugeUser()">
                <span style="color: red" id="sp"></span>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="password" name="pwd">
                <img src="${pageContext.request.contextPath}/yzm?type=reg">
            </td>
        </tr>
        <tr>
            <td rowspan="1"> <input type="submit"  value="注册"> </td>
        </tr>
    </table>

</form>

<script>

    function  jugeAjax() {
        var ajax =null;
        if(XMLHttpRequest){
            ajax=new XMLHttpRequest();
        }
        return ajax;
    }
    function  jugeUser() {
        var ajax=jugeAjax();
        ajax.onreadystatechange=function () {
              if (ajax.readyState==4){

                  var parses = JSON.parse(ajax.responseText);
                  var elementById = document.getElementById("sp");
                  elementById.innerText=parses.msg;


              }
        };

        var username = document.getElementById("username").value;
        ajax.open("get","/web07/ju?name="+username,true);
        ajax.send();
    }






</script>
</body>
</html>
