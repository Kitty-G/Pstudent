
<html>
<!DOCTYPE html>
<html  class="no-js">
    <head>
        <meta charset="utf-8">
        <title>登录(Login)</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="stylesheet" href="../../css/login/reset.css">
        <link rel="stylesheet" href="../../css/login/supersized.css">
        <link rel="stylesheet" href="../../css/login/style.css">
        <script type="text/javascript" src="../../javascript/lib/jquery-1.8.2.min.js"></script>
        <script>
            $(document).ready(function(){
               $("#captchaimg").click(function(){
                  this.src="/project/Kaptcha.jpg?a"+Math.random() + 10;
               }); 
            });
        </script>
        <script>
            $(docunment).ready(function(){
               $("#form").submit(function(){
                   
               });
            });
        </script>
    </head>
    <body>
        <div class="page-container">
            <h1>登录(Login)</h1>
            <form action="/LoginCheckServlet" method="post" id="form">
                <input type="text" name="username" class="username" placeholder="请输入您的用户名！">
                <input type="password" name="password" class="password" placeholder="请输入您的用户密码！">
                <img src="/project/Kaptcha.jpg" id="captchaimg">
                <input type="Captcha" class="Captcha" name="Captcha" class="Captcha" placeholder="请输入验证码！">
                <button type="submit" class="submit_button" id="submit">登录</button>
                <div class="error"><span>+</span></div>
            </form>
        </div>
        <script src="../../javascript/login/jquery-1.8.2.min.js" ></script>
        <script src="../../javascript/login/supersized.3.2.7.min.js" ></script>
        <script src="../../javascript/login/supersized-init.js" ></script>
        <script src="../../javascript/login/scripts.js" ></script>

    </body>

</html>

