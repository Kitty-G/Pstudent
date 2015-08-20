package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>某某网站</title>\n");
      out.write("<meta name=\"description\" content=\"\" />\n");
      out.write("<meta name=\"keywords\" content=\"\" />\n");
      out.write("<link href=\"css/index/style.css\" rel=\"stylesheet\" media=\"screen\" type=\"text/css\" />\n");
      out.write("<script type=\"text/jscript\" src=\"javascript/lib/jquery-1.8.2.min.js\" ></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");

        String stdid;
        String user;
        String power;
        stdid=(String)session.getAttribute("stdid");
        user=(String)session.getAttribute("username");
        power=(String)session.getAttribute("power");
        if(power==null){
            user="游客";
        }
    
      out.write("\n");
      out.write("<div class=\"head\">\n");
      out.write("<div class=\"nav1\">\n");
      out.write("    <ul class=\"menu\">\n");
      out.write("        <li><a href=\"index.jsp\"><span>网站首页</span></a></li>\n");
      out.write("        <li><a href='/demo/2/about/' ><span>通知公告</span></a></li>\n");
      out.write("        <li><a href='/demo/2/case/' ><span>爱心论坛</span></a></li>\n");
      out.write("        <li><a href='/demo/2/demo/2/services/'><span>自强互助</span></a></li>\n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("<div class=\"nav2\">\n");
      out.write("    <ul class=\"menu\">\n");
      out.write("        <li><a><span>你好,");
      out.print(user);
      out.write("</span></a></li>\n");
      out.write("        <li><a href='/project/jsp/login/login.jsp' ><span>用户登录</span></a></li>\n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<div class=\"fuwu\">\n");
      out.write("<div class=\"con\">\n");
      out.write("<p class=\"img\"><img src=\"resources/images/index/c1.png\" /></p>\n");
      out.write("<p class=\"title\"><a href=\"#\">互联网服务介绍</a></p>\n");
      out.write("<p class=\"content\">随着互联网在全球范围内的扩展,中国互联网快速发展,中国ISP的数量不断增加,提供的业务也不断丰富。然而要实现..</p>\n");
      out.write("<p class=\"more\"><a href=\"#\">— 了解更多 —</a></p>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"con\">\n");
      out.write("<p class=\"img\"><img src=\"resources/images/index/c2.png\" /></p>\n");
      out.write("<p class=\"title\"><a href=\"#\">我们的团队</a></p>\n");
      out.write("<p class=\"content\">我们是一个崭新的团队，我们专注于WEB前端设计，如果您对这方面感兴趣或者想加入我们一起创业，那么就联系我们吧...</p>\n");
      out.write("<p class=\"more\"><a href=\"#\">— 了解更多 —</a></p>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"con\">\n");
      out.write("<p class=\"img\"><img src=\"resources/images/index/c3.png\" /></p>\n");
      out.write("<p class=\"title\"><a href=\"#\">功能定制/二次开发</a></p>\n");
      out.write("<p class=\"content\">现如今开发一套程序需要很大的人力物力投入，所以许多朋友会选择购买一套商业源码，然后对其进行二次开发...</p>\n");
      out.write("<p class=\"more\"><a href=\"#\">— 了解更多 —</a></p>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"con\">\n");
      out.write("<p class=\"img\"><img src=\"resources/images/index/c4.png\" /></p>\n");
      out.write("<p class=\"title\"><a href=\"#\">WEB前端设计</a></p>\n");
      out.write("<p class=\"content\">好的作品就好像一件名贵的衣服，如果您需要对您的网站以及其他相关产品进行美化，请与我们取得联系，我们将竭诚为您服务...</p>\n");
      out.write("<p class=\"more\"><a href=\"#\">— 了解更多 —</a></p>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"guanggao\">—— 案例展示 ——</div>\n");
      out.write("\n");
      out.write("<div class=\"liebiao\">\n");
      out.write("\n");
      out.write("<div class=\"con\">\n");
      out.write("<p class=\"img\"><a href=\"/demo/2/case/14.html\"><img src=\"uploads/allimg/141014/1-14101411155bZ.jpg\" width=\"267\" height=\"180\" /></a></p>\n");
      out.write("<p class=\"content\">标准企业站模板，附带后台数据，后台可自行修改公司简介、联系方式、幻灯片，产品分类，已经做好了数据调用.</p>\n");
      out.write("<p class=\"more\"><a href=\"/demo/2/case/14.html\">— 查看详情 —</a></p>\n");
      out.write("</div>\n");
      out.write("<div class=\"con\">\n");
      out.write("<p class=\"img\"><a href=\"/demo/2/case/13.html\"><img src=\"uploads/allimg/141014/1-14101411155bZ.jpg\" width=\"267\" height=\"180\" /></a></p>\n");
      out.write("<p class=\"content\">此模板是基于织梦5.7gbk内核，适用于企业，工作室，个人站长。精简的代码，使用DIV+CSS布局，在修改页面的时候更加容</p>\n");
      out.write("<p class=\"more\"><a href=\"/demo/2/case/13.html\">— 查看详情 —</a></p>\n");
      out.write("</div>\n");
      out.write("<div class=\"con\">\n");
      out.write("<p class=\"img\"><a href=\"/demo/2/case/12.html\"><img src=\"uploads/allimg/141014/1-14101411155bZ.jpg\" width=\"267\" height=\"180\" /></a></p>\n");
      out.write("<p class=\"content\">织梦模板，导航和BANNER全部FLASH，织梦产品展示，附带后台数据，后台可自行修改公司简介、联系方式、幻灯片，产品</p>\n");
      out.write("<p class=\"more\"><a href=\"/demo/2/case/12.html\">— 查看详情 —</a></p>\n");
      out.write("</div>\n");
      out.write("<div class=\"con\">\n");
      out.write("<p class=\"img\"><a href=\"/demo/2/case/11.html\"><img src=\"uploads/allimg/141014/1-14101411155bZ.jpg\" width=\"267\" height=\"180\" /></a></p>\n");
      out.write("<p class=\"content\">此模板是基于织梦5.7gbk内核，适用于企业，工作室，个人站长。精简的代码，使用DIV+CSS布局，在修改页面的时候更加容</p>\n");
      out.write("<p class=\"more\"><a href=\"/demo/2/case/11.html\">— 查看详情 —</a></p>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"guanggao\">—— 合作伙伴 ——</div>\n");
      out.write("<div class=\"guanggao2\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"hezuo\">\n");
      out.write("\t\t<div class=\"hezuos\">\n");
      out.write("\n");
      out.write("\t<ul>\n");
      out.write("    \n");
      out.write("\t<li><a href='http://www.dedecms.com' target='_blank'><img src='img/top_logo.jpg' width='88' height='31' border='0'></a> </li>\n");
      out.write("    \n");
      out.write("\t<li><a href='http://bbs.dedecms.com' target='_blank'><img src='images/wind/logo.png' width='88' height='31' border='0'></a> </li>\n");
      out.write("    \n");
      out.write("\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--footer-->\n");
      out.write("<div class=\"footer\">\n");
      out.write("\n");
      out.write("\t\t<div class=\"con\">\n");
      out.write("        <p class=\"title\">最新资讯</p>\n");
      out.write("        <p class=\"content\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("            <li>\n");
      out.write("<a href=\"/demo/2/demo/2/news/3.html\">为什么电商越来越难做？</a>\n");
      out.write("\t\t\t</li>\n");
      out.write("<li>\n");
      out.write("<a href=\"/demo/2/demo/2/news/4.html\">为什么电商越来越难做？</a>\n");
      out.write("\t\t\t</li>\n");
      out.write("<li>\n");
      out.write("<a href=\"/demo/2/demo/2/news/5.html\">为什么电商越来越难做？</a>\n");
      out.write("\t\t\t</li>\n");
      out.write("<li>\n");
      out.write("<a href=\"/demo/2/demo/2/news/6.html\">为什么电商越来越难做？</a>\n");
      out.write("\t\t\t</li>\n");
      out.write("<li>\n");
      out.write("<a href=\"/demo/2/news/gonggao/2.html\">进过一段时间的设计与测试</a>\n");
      out.write("\t\t\t</li>\n");
      out.write("\n");
      out.write("\t\t\t</ul>\n");
      out.write("        </p>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"con\">\n");
      out.write("        <p class=\"title\">服务项目</p>\n");
      out.write("        <p class=\"content\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t</ul>\n");
      out.write("        </p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"con\">\n");
      out.write("        <p class=\"title\">联系我们</p>\n");
      out.write("        <p class=\"content\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li>联系电话：15288888888</li>\n");
      out.write("\t\t\t\t<li>联系邮箱：884358@qq.com</li>\n");
      out.write("\t\t\t\t<li>服务QQ：884358</li>\n");
      out.write("\t\t\t\t<li>邮寄地址：西安市</li>\n");
      out.write("\t\t\t\t<li>邮政编码：610103</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</p>\n");
      out.write("        </div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"con\">\n");
      out.write("        <p class=\"title\">关于我们</p>\n");
      out.write("        <p class=\"content\">\n");
      out.write("帮助客户实现网站计划，利用我们的境遇与技术应用到客户的需求并提升他们的计划，不论公司规模大小，在电脑显示屏所设定的范围内，我们的客户都将与世界各地的知名公司平分秋色！\n");
      out.write("        </p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"bottom\">\n");
      out.write("\n");
      out.write("<div class=\"bllx\">\n");
      out.write("<ul>\n");
      out.write("\n");
      out.write("<li><a href=\"http://weibo.com\"><img src=\"resources/images/index/l1.png\" width=\"30\" height=\"30\"/></a></li>\n");
      out.write("<li><a href=\"http://t.qq.com/jason19905\"><img src=\"resources/images/index/l2.png\" width=\"30\" height=\"30\"/></a></li>\n");
      out.write("<li><a href=\"http://wpa.qq.com/msgrd?v=3&uin=272803886&site=dedemao&menu=yes\"><img src=\"resources/images/index/l3.png\" width=\"30\" height=\"30\"/></a></li>\n");
      out.write("<li><a href=\"#\"><img src=\"resources/images/index/l4.png\" width=\"30\" height=\"30\"/></a></li>\n");
      out.write("\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"blrt\">\n");
      out.write("<!--需要修改底部版权、备案信息就在这里修改-->\n");
      out.write("\n");
      out.write("Copyright &copy; 2002-2011 绿风科技 版权所有 <a href=http://www.dedecms.com target='_blank'>Power by DedeCms</a>\n");
      out.write("\n");
      out.write("<!-- 以上就是可以修改的部分-->\n");
      out.write("</div>\n");
      out.write("</div>\n");
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
