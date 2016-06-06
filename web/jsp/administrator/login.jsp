<%-- 
    Document   : login
    Created on : 2015-8-14, 23:03:18
    Author     : KittyG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>贫困生助学平台</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="../../css/login/demo.css" />
        <link rel="stylesheet" type="text/css" href="../../css/login/style_1.css" />
        <link rel="stylesheet" type="text/css" href="../../css/login/animate-custom.css" />
        <script type="text/javascript" src="../../javascript/lib/jquery-1.8.2.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#CaptchaImage").click(function () {
                    this.src = "/project/Kaptcha.jpg?a" + Math.random() + 10;
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                $("#LoginSubmit").click(function () {
                    var userId = $("#UserId").val();
                    var password = $("#Password").val();
                    if (userId === "") {
                        alert("请输入学号!");
                        return false;
                    }
                    if (password === "") {
                        alert("请输入密码!");
                        return false;
                    }
                    $.post(
                            "../../CaptchaCheckServlet",
                            {captcha: $('#Captcha').val()},
                            function (result) {
                                if (result !== "1") {                               //form submit
                                    alert("验证码错误！");
                                    $("#CaptchaImage").attr('src', '/project/Kaptcha.jpg?a' + Math.random() + 10);
                                    $("#Password").attr('value', '');
                                    $("#Captcha").attr('value', '');
                                    return false;
                                } else if (result === '1') {
                                    $("#LoginForm").submit();
                                }
                            }
                    );
                    return false;
                });
            });
        </script>
    </head>
    <body>
        <div class="container">			
            <div id="container_demo" >
                <a class="hiddenanchor" id="toregister"></a>
                <a class="hiddenanchor" id="tologin"></a>
                <div id="wrapper">
                    <div id="login" class="animate form">
                        <form action="../../LoginServlet" method="post" id="LoginForm"> 
                            <h1>管理员 登录</h1> 
                            <p> 
                                <label for="UserId" > 工号 </label>
                                <input id="UserId" name="UserId" type="text" placeholder="请输入学号"/>
                            </p>
                            <p> 
                                <label for="Password" > 密码 </label>
                                <input id="Password" name="Password" type="password" placeholder="请输入密码" /> 
                            </p>

                            <p>
                                <label for="Captcha">验证码:</label>
                                <img src="/project/Kaptcha.jpg" id="CaptchaImage">
                                <input type="text" name="Captcha" id="Captcha" placeholder="请输入验证码！">
                            </p>
                            <input type="hidden" name="UserType" value="2">
                            <p class="login button"> 
                                <input type="submit" value="Login" id="LoginSubmit"/> 
                            </p>
                        </form>
                        <p class="change_link">
                            学生登录
                            <a href="../login/login.jsp">切换</a>
                        </p>

                    </div>
                </div>
            </div>  
        </div>
    </body>
</html>
