package org.apache.jsp.jsp.std_005finfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class student_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String stdid=(String)session.getAttribute("stdid");

      out.write("\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\" />\n");
      out.write("<title>完善信息</title>\n");
      out.write("<script src=\"../../javascript/register/html5shiv.js\"></script>\n");
      out.write("\n");
      out.write("<link href=\"../../css/register/normalize.css\" rel=\"stylesheet\"/>\n");
      out.write("<link href=\"../../css/register/jquery-ui.css\" rel=\"stylesheet\"/>\n");
      out.write("<link href=\"../../css/register/jquery.idealforms.min.css\" rel=\"stylesheet\" media=\"screen\"/>\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("body{font:normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;color: #222;background:url(pattern.png);overflow-y:scroll;padding:60px 0 0 0;}\n");
      out.write("#my-form{width:755px;margin:0 auto;border:1px solid #ccc;padding:3em;border-radius:3px;box-shadow:0 0 2px rgba(0,0,0,.2);}\n");
      out.write("#comments{width:350px;height:100px;}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"row\">\n");
      out.write("\n");
      out.write("    <div class=\"eightcol last\">\n");
      out.write("\n");
      out.write("    <!-- Begin Form -->\n");
      out.write("\n");
      out.write("    <form id=\"my-form\" action=\"/project/DetailInfoServlet\" method=\"post\">\n");
      out.write("        <div><label>学号:");
      out.print(stdid);
      out.write("</label></div>\n");
      out.write("        <div><label>寝室:</label>\n");
      out.write("            <select id=\"dorm\" name=\"dorm\">\\\n");
      out.write("                <option value=\"01\">第一学生公寓</option>\n");
      out.write("                <option value=\"02\">第二学生公寓</option>\n");
      out.write("                <option value=\"03\">第三学生公寓</option>\n");
      out.write("                <option value=\"04\">第四学生公寓</option>\n");
      out.write("                <option value=\"05\">第五学生公寓</option>\n");
      out.write("                <option value=\"06\">第六学生公寓</option>\n");
      out.write("            </select>\n");
      out.write("            <label>寝室号:</label><input type=\"text\" id=\"dorm_num\"/>            \n");
      out.write("        </div>\n");
      out.write("        <div><label>生源地:</label>\n");
      out.write("            <select id=\"origin1\" name=\"origin1\">\n");
      out.write("                <option value=\"01\">辽宁</option>\n");
      out.write("                <option value=\"02\">北京</option>\n");
      out.write("            </select>\n");
      out.write("            <select id=\"origin2\" name=\"origin2\">\n");
      out.write("                <option value=\"01\">沈阳</option>\n");
      out.write("                <option value=\"02\">大连</option>\n");
      out.write("            </select>\n");
      out.write("        </div>\n");
      out.write("        <div><label>贫困等级:</label>\n");
      out.write("            <select id=\"level\" name=\"level\">\n");
      out.write("                <option value=\"1\">很贫困</option>\n");
      out.write("                <option value=\"2\">贫困</option>\n");
      out.write("            </select>\n");
      out.write("        </div>\n");
      out.write("        <div><label>贫困原因:</label><input id=\"reason\" name=\"reason\" type=\"text\"/></div>\n");
      out.write("        <div><label>特长:</label><input id=\"skill\" name=\"skill\" type=\"text\"/></div>\n");
      out.write("        <div><label>兼职:</label>\n");
      out.write("            <select id=\"ptime\" name=\"ptime\">\n");
      out.write("                <option value=\"1\">是</option>\n");
      out.write("                <option value=\"0\">否</option>\n");
      out.write("            </select>\n");
      out.write("        </div>\n");
      out.write("        <div><label>所获奖项:</label><input id=\"prize\" name=\"prize\" type=\"text\"/></div>\n");
      out.write("      <div><hr/></div>\n");
      out.write("\n");
      out.write("      <div>\n");
      out.write("        <button type=\"submit\">提交</button>\n");
      out.write("        <button id=\"reset\" type=\"button\">重置</button>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    <!-- End Form -->\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"../../javascript/lib/jquery-1.8.2.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../../javascript/lib/jquery-ui.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../../javascript/register/jquery.idealforms.js\"></script>\n");
      out.write("\n");
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
