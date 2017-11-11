<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
</head>
<body>

    <form action="/login" method="post">
        <input type="hidden" name="token" value="${token}">
        <input type="text" id="username" name="username" placeholder="请输入用户名"><br>
        <input type="password" id="password" name="password" placeholder="******"><br>
        <input type="submit" value="登录">
    </form>

</body>
</html>