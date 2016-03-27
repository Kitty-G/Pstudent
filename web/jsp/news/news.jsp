<%-- 
    Document   : news
    Created on : 2015-10-27, 21:13:36
    Author     : KittyG
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.javabean.news.NewsInfo"%>
<%@page import="com.javabean.news.News"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
       
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table align="center" width="600px"> 
            <%
                News news=new News();
                NewsInfo ni;
                List list;
                Iterator it;
                list=news.getNewsList();
                it = list.iterator();
                while(it.hasNext()){
                    ni=(NewsInfo)it.next();
                    
            %>    
            <tr>
                <td colspan="3">
                    <a href="" ><%=ni.getFormatNewsName()%></a>
                    
                </td>
                <td colspan="1">
                    <%=ni.getNews_time()%>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
