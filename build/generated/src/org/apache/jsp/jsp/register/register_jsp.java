package org.apache.jsp.jsp.register;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--[if lt IE 7 ]> <html lang=\"en\" class=\"no-js ie6 lt8\"> <![endif]-->\n");
      out.write("<!--[if IE 7 ]>    <html lang=\"en\" class=\"no-js ie7 lt8\"> <![endif]-->\n");
      out.write("<!--[if IE 8 ]>    <html lang=\"en\" class=\"no-js ie8 lt8\"> <![endif]-->\n");
      out.write("<!--[if IE 9 ]>    <html lang=\"en\" class=\"no-js ie9\"> <![endif]-->\n");
      out.write("<!--[if (gt IE 9)|!(IE)]><!--> <html lang=\"en\" class=\"no-js\"> <!--<![endif]-->\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <!-- <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">  -->\n");
      out.write("        <title>贫困生助学平台</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \n");
      out.write("        <meta name=\"description\" content=\"Login and Registration Form with HTML5 and CSS3\" />\n");
      out.write("        <meta name=\"keywords\" content=\"html5, css3, form, switch, animation, :target, pseudo-class\" />\n");
      out.write("        <meta name=\"author\" content=\"Codrops\" />\n");
      out.write("        <link rel=\"shortcut icon\" href=\"../favicon.ico\"> \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/register/demo.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/register/style_1.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/register/animate-custom.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"../../javascript/lib/jquery-1.8.2.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function(){\n");
      out.write("               $(\"#captchaimg_reg\").click(function(){\n");
      out.write("                  this.src=\"/project/Kaptcha.jpg?a\"+Math.random() + 10;\n");
      out.write("               }); \n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $(\"#submit_log\").click(function(){\n");
      out.write("                   var stdid=$(\"#stdid_reg\").val();\n");
      out.write("                   var username=$(\"username_reg\").val();\n");
      out.write("                   var pwd1=$(\"#password_reg\").val();\n");
      out.write("                   var pwd2=$(\"#password_confirm\").val();\n");
      out.write("                   if(stdid===\"\"){\n");
      out.write("                       alert(\"请输入学号!\");\n");
      out.write("                       return false;\n");
      out.write("                   }\n");
      out.write("                   if(username===\"\"){\n");
      out.write("                       alert(\"请输入用户名!\");\n");
      out.write("                       return false;\n");
      out.write("                   }\n");
      out.write("                   if(pwd1===\"\"){\n");
      out.write("                       alert(\"请输入密码!\");\n");
      out.write("                       return false;\n");
      out.write("                   }\n");
      out.write("                   if(pwd2===\"\"){\n");
      out.write("                       alert(\"请再次输入密码!\");\n");
      out.write("                       return false;\n");
      out.write("                   }\n");
      out.write("                   if(pwd1!==pwd2){\n");
      out.write("                       alert(\"两次输入的密码不一致!\");\n");
      out.write("                       return false;\n");
      out.write("                   }\n");
      out.write("                            $.post(\n");
      out.write("                                \"../../CaptchaCheckServlet\",\n");
      out.write("                                {captcha:$('#Captcha_log').val()},\n");
      out.write("                                function(result){\n");
      out.write("                                    if(result!==\"1\"){                               //form submit\n");
      out.write("                                        alert(\"验证码错误！\");\n");
      out.write("                                        $(\"#captchaimg_reg\").attr('src','/project/Kaptcha.jpg?a'+Math.random() + 10);\n");
      out.write("                                        $(\"#Captcha_log\").attr('value','');\n");
      out.write("                                        return false;\n");
      out.write("                                    }else if(result==='1'){\n");
      out.write("                                        $(\"#form_reg\").submit();\n");
      out.write("                                    }\n");
      out.write("                                }\n");
      out.write("                                );\n");
      out.write("               return false;                    \n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\t\t\t\n");
      out.write("                <div id=\"container_demo\" >\n");
      out.write("                    <a class=\"hiddenanchor\" id=\"toregister\"></a>\n");
      out.write("                    <a class=\"hiddenanchor\" id=\"tologin\"></a>\n");
      out.write("                    <div id=\"wrapper\">\n");
      out.write("                        <div id=\"login\" class=\"animate form\">\n");
      out.write("                            <form  action=\"../../RegisterServlet\" id=\"form_reg\" method=\"post\"> \n");
      out.write("                                <h1> 用户 注册 </h1> \n");
      out.write("                                <p> \n");
      out.write("                                    <label for=\"stdid_reg\">学号</label>\n");
      out.write("                                    <input id=\"stdid_reg\" name=\"stdid_reg\" type=\"text\" placeholder=\"请输入学号\" />\n");
      out.write("                                </p>\n");
      out.write("                                <p> \n");
      out.write("                                    <label for=\"username_reg\">用户昵称</label>\n");
      out.write("                                    <input id=\"username_reg\" name=\"username_reg\" type=\"text\" placeholder=\"请输入用户昵称\" />\n");
      out.write("                                </p>\n");
      out.write("                                <p> \n");
      out.write("                                    <label for=\"password_reg\">密码</label>\n");
      out.write("                                    <input id=\"password_reg\" name=\"password_reg\" type=\"password\" placeholder=\"请输入密码\"/>\n");
      out.write("                                </p>\n");
      out.write("                                <p> \n");
      out.write("                                    <label for=\"password_confirm\">确认密码</label>\n");
      out.write("                                    <input id=\"password_confirm\" name=\"password_confirm\" type=\"password\" placeholder=\"请再次输入密码\"/>\n");
      out.write("                                </p>\n");
      out.write("                                <p>\n");
      out.write("                                    <label for=\"Captcha_reg\">验证码:</label>\n");
      out.write("                                    <img src=\"/project/Kaptcha.jpg\" id=\"captchaimg_reg\">\n");
      out.write("                                    <input type=\"text\" name=\"Captcha_reg\" id=\"Captcha_reg\" placeholder=\"请输入验证码！\">\n");
      out.write("                                </p>\n");
      out.write("                                <p class=\"signin button\"> \n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"Sign up\"/> \n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("                            </form>\n");
      out.write("                                <p class=\"change_link\">\n");
      out.write("\t\t\t\t\t\t\t\t\t已经有账号 ?\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"../login/login.jsp\">登录</a>\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("                            \n");
      out.write("                        </div>\t\t\t\t\t\t\n");
      out.write("                    </div>\n");
      out.write("                </div>  \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("  \n");
      out.write("\t</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
