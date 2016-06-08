package org.apache.jsp.jsp.administrator.studentmanager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.javabean.tools.SystemInfo;
import java.util.List;
import com.javabean.tables.Major;
import java.util.Calendar;

public final class AddStudentInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");

    String project;
    project = SystemInfo.ProjectName;

      out.write('\n');

    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    Major major=new Major();
    List<Major> majorList;
    List<Major> academyList;
    academyList=major.GetAllAcademyCodeAndName();
    majorList=major.GetAllMajorCodeAndName();

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <form action=\"/");
      out.print(project);
      out.write("/AddStudentServlet\" method=\"POST\">\n");
      out.write("            <table>\n");
      out.write("                <thead>添加学生用户信息</thead>\n");
      out.write("                <tr>\n");
      out.write("                    <td>学号</td>\n");
      out.write("                    <td><input type=\"text\" name=\"StudentId\" size=\"10\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>密码</td>\n");
      out.write("                    <td><input type=\"password\" name=\"Password\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>姓名</td>\n");
      out.write("                    <td><input type=\"text\" name=\"UserName\" size=\"20\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>性别</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"Gender\">\n");
      out.write("                             <option value=\"0\" selected=\"selected\">未指定</option>\n");
      out.write("                             <option value=\"1\">男</option>\n");
      out.write("                             <option value=\"2\">女</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>年级</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"Grade\">\n");
      out.write("                            <option value=\"");
      out.print(year);
      out.write("\" selected=\"selected\">");
      out.print(year%100);
      out.write("级</option>\n");
      out.write("                                 <option value=\"");
      out.print(year-1);
      out.write('"');
      out.write('>');
      out.print((year-1)%100);
      out.write("级</option>\n");
      out.write("                                 <option value=\"");
      out.print(year-2);
      out.write('"');
      out.write('>');
      out.print((year-2)%100);
      out.write("级</option>\n");
      out.write("                                 <option value=\"");
      out.print(year-3);
      out.write('"');
      out.write('>');
      out.print((year-3)%100);
      out.write("级</option>\n");
      out.write("                                 <option value=\"");
      out.print(year-4);
      out.write('"');
      out.write('>');
      out.print((year-4)%100);
      out.write("级</option>\n");
      out.write("                                 <option value=\"");
      out.print(year-5);
      out.write('"');
      out.write('>');
      out.print((year-5)%100);
      out.write("级</option>\n");
      out.write("                                 <option value=\"");
      out.print(year-6);
      out.write('"');
      out.write('>');
      out.print((year-6)%100);
      out.write("级</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>学院</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"Academy\">\n");
      out.write("                            <option value=\"-1\" selected=\"selected\">请选择</option>\n");
      out.write("                            ");
  for(Major academyTemp:academyList){ 
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(academyTemp.getAcademyCode());
      out.write('"');
      out.write('>');
      out.print(academyTemp.getAcademyName());
      out.write("</option>\n");
      out.write("                            ");
  }   
      out.write("\n");
      out.write("                        </select></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>专业</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"Major\">\n");
      out.write("                            <option value=\"-1\" selected=\"selected\">请选择</option>\n");
      out.write("                            ");
  for(Major majorTemp:majorList){ 
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(majorTemp.getMajorCode());
      out.write('"');
      out.write('>');
      out.print(majorTemp.getMajorName());
      out.write("</option>\n");
      out.write("                            ");
  }   
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>班级</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"Class\">\n");
      out.write("                            <option value=\"-1\" selected=\"selected\">请选择</option>\n");
      out.write("                            <option value=\"1\">1班</option>\n");
      out.write("                            <option value=\"1\">2班</option>\n");
      out.write("                            <option value=\"1\">3班</option>\n");
      out.write("                            <option value=\"1\">4班</option>\n");
      out.write("                            <option value=\"1\">5班</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>入学时间</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"IntendedTime\">\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr><td><input type=\"submit\" value=\"提交\"></td></tr>\n");
      out.write("            </table>\n");
      out.write("                </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
