<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Index</title>
</head>
<body>

<h3>Hello ${Session["login_user"]!""} !!!</h3>

<h4><a href="/login">登录</a> | <a href="/logout">登出</a></h4>

<div>
    <!-- 现代浏览器会检查到XSS，导致无法测试(实际使用表单POST请求实现)，测试使用浏览器为IE，其它如Chrome系、Firefox等浏览器仍会拦截XSS攻击 -->
    <!-- 实际输入关键字： <script>alert(document.cookie);</script> ，搜索页将会弹出Cookie信息(可以弹出就可以通过Ajax等方式传递给攻击用户) -->
    <form action="/search" method="post">
        <input name="keyword" placeholder="请输入搜索关键字" size="40">
        <input type="submit" value="搜索">
    </form>
</div>

<h4><a href="/xss" target="_blank">走，去钓鱼</a></h4>

</body>
</html>