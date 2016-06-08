package org.apache.jsp.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <!-- <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">  -->\n");
      out.write("        <title>贫困生助学平台</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \n");
      out.write("        <meta name=\"description\" content=\"Login and Registration Form with HTML5 and CSS3\" />\n");
      out.write("        <meta name=\"keywords\" content=\"html5, css3, form, switch, animation, :target, pseudo-class\" />\n");
      out.write("        <meta name=\"author\" content=\"Codrops\" />\n");
      out.write("        <link rel=\"shortcut icon\" href=\"../favicon.ico\"> \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/login/demo.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/login/style_1.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/login/animate-custom.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"../../javascript/lib/jquery-1.8.2.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#CaptchaImage\").click(function () {\n");
      out.write("                    this.src = \"/project/Kaptcha.jpg?a\" + Math.random() + 10;\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#LoginSubmit\").click(function () {\n");
      out.write("                    var userId = $(\"#UserId\").val();\n");
      out.write("                    var password = $(\"#Password\").val();\n");
      out.write("                    if (userId === \"\") {\n");
      out.write("                        alert(\"请输入学号!\");\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if (password === \"\") {\n");
      out.write("                        alert(\"请输入密码!\");\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    $.post(\n");
      out.write("                            \"../../CaptchaCheckServlet\",\n");
      out.write("                            {captcha: $('#Captcha').val()},\n");
      out.write("                            function (result) {\n");
      out.write("                                if (result !== \"1\") {                               //form submit\n");
      out.write("                                    alert(\"验证码错误！\");\n");
      out.write("                                    $(\"#CaptchaImage\").attr('src', '/project/Kaptcha.jpg?a' + Math.random() + 10);\n");
      out.write("                                    $(\"#Password\").attr('value', '');\n");
      out.write("                                    $(\"#Captcha\").attr('value', '');\n");
      out.write("                                    return false;\n");
      out.write("                                } else if (result === '1') {\n");
      out.write("                                    $(\"#LoginForm\").submit();\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("                    );\n");
      out.write("                    return false;\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\t\t\t\n");
      out.write("            <div id=\"container_demo\" >\n");
      out.write("                <a class=\"hiddenanchor\" id=\"toregister\"></a>\n");
      out.write("                <a class=\"hiddenanchor\" id=\"tologin\"></a>\n");
      out.write("                <div id=\"wrapper\">\n");
      out.write("                    <div id=\"login\" class=\"animate form\">\n");
      out.write("                        <form action=\"../../LoginServlet\" method=\"post\" id=\"LoginForm\"> \n");
      out.write("                            <h1>学生 登录</h1> \n");
      out.write("                            <p> \n");
      out.write("                                <label for=\"UserId\" > 学号 </label>\n");
      out.write("                                <input id=\"UserId\" name=\"UserId\" type=\"text\" placeholder=\"请输入学号\"/>\n");
      out.write("                            </p>\n");
      out.write("                            <p> \n");
      out.write("                                <label for=\"Password\" > 密码 </label>\n");
      out.write("                                <input id=\"Password\" name=\"Password\" type=\"password\" placeholder=\"请输入密码\" /> \n");
      out.write("                            </p>\n");
      out.write("\n");
      out.write("                            <p>\n");
      out.write("                                <label for=\"Captcha\">验证码:</label>\n");
      out.write("                                <img src=\"/project/Kaptcha.jpg\" id=\"CaptchaImage\">\n");
      out.write("                                <input type=\"text\" name=\"Captcha\" id=\"Captcha\" placeholder=\"请输入验证码！\">\n");
      out.write("                            </p>\n");
      out.write("                            <input type=\"hidden\" name=\"UserType\" value=\"1\">\n");
      out.write("                            <p class=\"login button\"> \n");
      out.write("                                <input type=\"submit\" value=\"Login\" id=\"LoginSubmit\"/> \n");
      out.write("                            </p>\n");
      out.write("                        </form>\n");
      out.write("                        <p class=\"change_link\">\n");
      out.write("                            管理员登录\n");
      out.write("                            <a href=\"../administrator/login.jsp\">切换</a>\n");
      out.write("                        </p>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>  \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
