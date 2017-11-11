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

<h3>Hello !!!</h3>

<h4>下面表单仅用于测试请求参数传递</h4>
<form action="/receive?version=1.0" method="post" target="_blank">
    <input name="name" placeholder="请输入你的名字"><br>
    <input name="password" type="password" placeholder="******"><br>
    <input name="gender" type="radio" value="MALE"> 男
    <input name="gender" type="radio" value="FEMALE"> 女 <br>
    <input name="token" type="hidden" value="123456">
    <input type="submit" value="提交">
</form>

<h4><a href="/auth/basic" target="_blank">使用BASIC认证</a></h4>
<h4><a href="/login" target="_blank">表单登录</a></h4>
<h4><a href="/logout">注销登录</a></h4>
<h4><a href="/host-page">访问iframe宿主页</a></h4>

</body>
</html>