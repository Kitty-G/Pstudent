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
            $(document).ready(function(){
               $("#captchaimg_log").click(function(){
                  this.src="/project/Kaptcha.jpg?a"+Math.random() + 10;
               }); 
            });
        </script>
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
                   var stdid=$("#stdid_log").val();
                   var pwd=$("#password_log").val();
                   if(stdid===""){
                       alert("请输入学号!");
                       return false;
                   }
                   if(pwd===""){
                       alert("请输入密码!");
                       return false;
                   }
                    $.post(
                        "../../CaptchaCheckServlet",
                        {captcha:$('#Captcha_log').val()},
                        function(result){
                            if(result!=="1"){                               //form submit
                                alert("验证码错误！");
                                $("#captchaimg_log").attr('src','/project/Kaptcha.jpg?a'+Math.random() + 10);
                                $("#password_log").attr('value','');
                                $("#Captcha_log").attr('value','');
                                return false;
                            }else if(result==='1'){
                                $("#form_log").submit();
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
                            <form action="../../LoginCheckServlet" method="post" id="form_log"> 
                                <h1>学生 登录</h1> 
                                <p> 
                                    <label for="stdid_log" > 学号 </label>
                                    <input id="stdid_log" name="stdid_log" type="text" placeholder="请输入学号"/>
                                </p>
                                <p> 
                                    <label for="password_log" > 密码 </label>
                                    <input id="password_log" name="password_log" type="password" placeholder="请输入密码" /> 
                                </p>
                                
                                <p>
                                    <label for="Captcha_log">验证码:</label>
                                    <img src="/project/Kaptcha.jpg" id="captchaimg_log">
                                    <input type="text" name="Captcha_log" id="Captcha_log" placeholder="请输入验证码！">
                                </p>
                                <p class="login button"> 
                                    <input type="submit" value="Login" id="submit_log"/> 
								</p>
                           </form>
                                <p class="change_link">
									没有帐号？
									<a href="../register/register.jsp">注册</a>
								</p>
                            
                        </div>

                        
						
                    </div>
                </div>  
        </div>

  
	</body>

</html>
