<%-- 
    Document   : register
    Created on : 2015-8-14, 22:53:06
    Author     : KittyG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>贫困生助学平台</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="../../css/register/demo.css" />
        <link rel="stylesheet" type="text/css" href="../../css/register/style_1.css" />
        <link rel="stylesheet" type="text/css" href="../../css/register/animate-custom.css" />
        <script type="text/javascript" src="../../javascript/lib/jquery-1.8.2.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
               $("#captchaimg_reg").click(function(){
                  this.src="/project/Kaptcha.jpg?a"+Math.random() + 10;
               }); 
            });
        </script>
        <script>
            $(document).ready(function(){
                $("#submit_log").click(function(){
                   var stdid=$("#stdid_reg").val();
                   var username=$("username_reg").val();
                   var pwd1=$("#password_reg").val();
                   var pwd2=$("#password_confirm").val();
                   if(stdid===""){
                       alert("请输入学号!");
                       return false;
                   }
                   if(username===""){
                       alert("请输入用户名!");
                       return false;
                   }
                   if(pwd1===""){
                       alert("请输入密码!");
                       return false;
                   }
                   if(pwd2===""){
                       alert("请再次输入密码!");
                       return false;
                   }
                   if(pwd1!==pwd2){
                       alert("两次输入的密码不一致!");
                       return false;
                   }
                            $.post(
                                "../../CaptchaCheckServlet",
                                {captcha:$('#Captcha_log').val()},
                                function(result){
                                    if(result!=="1"){                               //form submit
                                        alert("验证码错误！");
                                        $("#captchaimg_reg").attr('src','/project/Kaptcha.jpg?a'+Math.random() + 10);
                                        $("#Captcha_log").attr('value','');
                                        return false;
                                    }else if(result==='1'){
                                        $("#form_reg").submit();
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
                            <form  action="../../RegisterServlet" id="form_reg" method="post"> 
                                <h1> 用户 注册 </h1> 
                                <p> 
                                    <label for="stdid_reg">学号</label>
                                    <input id="stdid_reg" name="stdid_reg" type="text" placeholder="请输入学号" />
                                </p>
                                <p> 
                                    <label for="username_reg">用户昵称</label>
                                    <input id="username_reg" name="username_reg" type="text" placeholder="请输入用户昵称" />
                                </p>
                                <p> 
                                    <label for="password_reg">密码</label>
                                    <input id="password_reg" name="password_reg" type="password" placeholder="请输入密码"/>
                                </p>
                                <p> 
                                    <label for="password_confirm">确认密码</label>
                                    <input id="password_confirm" name="password_confirm" type="password" placeholder="请再次输入密码"/>
                                </p>
                                <p>
                                    <label for="Captcha_reg">验证码:</label>
                                    <img src="/project/Kaptcha.jpg" id="captchaimg_reg">
                                    <input type="text" name="Captcha_reg" id="Captcha_reg" placeholder="请输入验证码！">
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="Sign up"/> 
								</p>
                            </form>
                                <p class="change_link">
									已经有账号 ?
									<a href="../login/login.jsp">登录</a>
								</p>
                            
                        </div>						
                    </div>
                </div>  
        </div>

  
	</body>
</html>