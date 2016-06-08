package org.apache.jsp.jsp.administrator.Excel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.javabean.tools.SystemInfo;

public final class BatchAppend_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    String project;
    project = SystemInfo.ProjectName;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>批量添加信息</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"/");
      out.print(project);
      out.write("/javascript/lib/jquery-1.8.2.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $.post(\n");
      out.write("                        \"../../CaptchaCheckServlet\",\n");
      out.write("                        {captcha: $('#Captcha').val()},\n");
      out.write("                        function (result) {\n");
      out.write("                            if (result !== \"1\") {                               //form submit\n");
      out.write("                                alert(\"验证码错误！\");\n");
      out.write("                                $(\"#CaptchaImage\").attr('src', '/project/Kaptcha.jpg?a' + Math.random() + 10);\n");
      out.write("                                $(\"#Password\").attr('value', '');\n");
      out.write("                                $(\"#Captcha\").attr('value', '');\n");
      out.write("                                return false;\n");
      out.write("                            } else if (result === '1') {\n");
      out.write("                                $(\"#LoginForm\").submit();\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                );\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <form id=\"fileupload\" action=\"/");
      out.print(project);
      out.write("/UploadExcelFileServlet\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("                <p><input type=\"file\" name=\"file\"></p>\n");
      out.write("                <p><input type=\"submit\" name=\"submit\" value=\"submit\"></p>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    \n");
      out.write("        <iframe src=\"/project/jsp/login/login.jsp\" name=left scrolling=no id=\"left\"></iframe>\n");
      out.write("    \n");
      out.write("</body>\n");
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
