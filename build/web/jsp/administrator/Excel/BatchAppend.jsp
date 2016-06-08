<%-- 
    Document   : BatchAppend
    Created on : 2016-6-5, 16:20:39
    Author     : KittyG
--%>

<%@page import="com.javabean.tools.SystemInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String project;
    project = SystemInfo.ProjectName;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>批量添加信息</title>
        <script type="text/javascript" src="/<%=project%>/javascript/lib/jquery-1.8.2.min.js"></script>
        <script>
            $(document).ready(function () {
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
            }
        </script>
    </head>
    <body>
        <div>
            <form id="fileupload" action="/<%=project%>/UploadExcelFileServlet" method="POST" enctype="multipart/form-data">
                <p><input type="file" name="file"></p>
                <p><input type="submit" name="submit" value="submit"></p>
            </form>
        </div>
    
        <iframe src="/project/jsp/login/login.jsp" name=left scrolling=no id="left"></iframe>
    
</body>
</html>
