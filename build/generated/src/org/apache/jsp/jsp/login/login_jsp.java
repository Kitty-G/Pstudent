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

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html  class=\"no-js\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>登录(Login)</title>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"author\" content=\"\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../css/login/reset.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../css/login/supersized.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../css/login/style.css\">\r\n");
      out.write("        <script type=\"text/javascript\" src=\"../../javascript/lib/jquery-1.8.2.min.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            $(document).ready(function(){\r\n");
      out.write("               $(\"#captchaimg\").click(function(){\r\n");
      out.write("                  this.src=\"/project/Kaptcha.jpg?a\"+Math.random() + 10;\r\n");
      out.write("                  $(\"#Captcha\").focus();\r\n");
      out.write("               }); \r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("        <script>\r\n");
      out.write("//            $(docunment).ready(function(){\r\n");
      out.write("//\r\n");
      out.write("//\r\n");
      out.write("//            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"page-container\">\r\n");
      out.write("            <h1>登录(Login)</h1>\r\n");
      out.write("            <form action=\"../../LoginCheckServlet\" method=\"post\" id=\"form\">\r\n");
      out.write("                <input type=\"text\" name=\"username\" class=\"username\" placeholder=\"请输入您的用户名！\">\r\n");
      out.write("                <input type=\"password\" name=\"password\" class=\"password\" placeholder=\"请输入您的用户密码！\">\r\n");
      out.write("                <img src=\"/project/Kaptcha.jpg\" id=\"captchaimg\">\r\n");
      out.write("                <input type=\"Captcha\" class=\"Captcha\" name=\"Captcha\" id=\"Captcha\" class=\"Captcha\" placeholder=\"请输入验证码！\">\r\n");
      out.write("                <button type=\"submit\" class=\"submit_button\" id=\"submit\">登录</button>\r\n");
      out.write("                <div class=\"error\"><span>+</span></div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"../../javascript/login/supersized.3.2.7.min.js\" ></script>\r\n");
      out.write("        <script src=\"../../javascript/login/supersized-init.js\" ></script>\r\n");
      out.write("        <script src=\"../../javascript/login/scripts.js\" ></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
