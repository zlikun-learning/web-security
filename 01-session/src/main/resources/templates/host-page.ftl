<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>iframe宿主页</title>
</head>
<body>

<!-- 嵌入登录页 -->
<!-- 同域嵌套，可以正常获取信息 -->
<!-- <iframe name="j-iframe" src="/login" width="300" height="200"></iframe> -->
<!-- 不同域嵌套，可以正常显示，但js无法获取iframe内部信息，违反同源策略 -->
<!-- host-page:24 Uncaught DOMException: Blocked a frame with origin "http://i.zlikun.com" from accessing a cross-origin frame. -->
<iframe name="j-iframe" src="http://i.zlikun.net/login" width="300" height="200"></iframe><br>

<button onclick="getInfo()">获取信息</button>
<div id="j-container"></div>

<script>
    function getInfo() {
        // 获取iframe document
        var _iframe = window.frames["j-iframe"].document ;
        // 获取表单信息
        var username = _iframe.getElementById("username").value ;

        console.log("登录用户名：" ,username) ;
        document.getElementById("j-container").innerHTML = username ;
    }
</script>

</body>
</html>