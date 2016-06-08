<%-- 
    Document   : AddStudentInfo
    Created on : Jun 7, 2016, 4:10:47 PM
    Author     : zxli
--%>

<%@page import="java.util.List"%>
<%@page import="com.javabean.tables.Major"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    Major major=new Major();
    List<Major> majorList;
    List<Major> academyList;
    academyList=major.GetAllAcademyCodeAndName();
    majorList=major.GetAllMajorCodeAndName();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form>
            <table>
                <thead>添加学生用户信息</thead>
                <tr>
                    <td>学号</td>
                    <td><input type="text" name="StudentId" size="10"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" name="Password"></td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="UserName" size="20"></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td>
                        <select name="Gender">
                             <option value="0" selected="selected">未指定</option>
                             <option value="1">男</option>
                             <option value="2">女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>年级</td>
                    <td>
                        <select name="Grade">
                            <option value="<%=year%>" selected="selected"><%=year%100%>级</option>
                                 <option value="<%=year-1%>"><%=(year-1)%100%>级</option>
                                 <option value="<%=year-2%>"><%=(year-2)%100%>级</option>
                                 <option value="<%=year-3%>"><%=(year-3)%100%>级</option>
                                 <option value="<%=year-4%>"><%=(year-4)%100%>级</option>
                                 <option value="<%=year-5%>"><%=(year-5)%100%>级</option>
                                 <option value="<%=year-6%>"><%=(year-6)%100%>级</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>学院</td>
                    <td>
                        <select name="Academy">
                            <option value="-1" selected="selected">请选择</option>
                            <%  for(Major academyTemp:academyList){ %>
                            <option value="<%=academyTemp.getAcademyCode()%>"><%=academyTemp.getAcademyName()%></option>
                            <%  }   %>
                        </select></td>
                </tr>
                <tr>
                    <td>专业</td>
                    <td>
                        <select name="Major">
                            <option value="-1" selected="selected">请选择</option>
                            <%  for(Major majorTemp:majorList){ %>
                            <option value="<%=majorTemp.getMajorCode()%>"><%=majorTemp.getMajorName()%></option>
                            <%  }   %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>班级</td>
                    <td>
                        <select name="Class">
                            <option value="-1" selected="selected">请选择</option>
                            <option value="1">1班</option>
                            <option value="1">2班</option>
                            <option value="1">3班</option>
                            <option value="1">4班</option>
                            <option value="1">5班</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>入学时间</td>
                    <td>
                        <input type="text" name="IntendedTime">
                    </td>
                </tr>
                <tfoot><input type="submit" value="提交"></tfoot>
            </table>
                </form>
        </div>
    </body>
</html>
