<%-- 
    Document   : student
    Created on : 2015-9-12, 8:52:29
    Author     : KittyG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String stdid=(String)session.getAttribute("stdid");
%>
<head>
<meta charset="UTF-8" />
<title>完善信息</title>
<script src="../../javascript/register/html5shiv.js"></script>

<link href="../../css/register/normalize.css" rel="stylesheet"/>
<link href="../../css/register/jquery-ui.css" rel="stylesheet"/>
<link href="../../css/register/jquery.idealforms.min.css" rel="stylesheet" media="screen"/>

<style type="text/css">
body{font:normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;color: #222;background:url(pattern.png);overflow-y:scroll;padding:60px 0 0 0;}
#my-form{width:755px;margin:0 auto;border:1px solid #ccc;padding:3em;border-radius:3px;box-shadow:0 0 2px rgba(0,0,0,.2);}
#comments{width:350px;height:100px;}
</style>

</head>
<body>


<div class="row">

    <div class="eightcol last">

    <!-- Begin Form -->

    <form id="my-form" action="/project/DetailInfoServlet" method="post">
        <div><label>学号:<%=stdid%></label></div>
        <div><label>寝室:</label>
            <select id="dorm" name="dorm">\
                <option value="01">第一学生公寓</option>
                <option value="02">第二学生公寓</option>
                <option value="03">第三学生公寓</option>
                <option value="04">第四学生公寓</option>
                <option value="05">第五学生公寓</option>
                <option value="06">第六学生公寓</option>
            </select>
            <label>寝室号:</label><input type="text" id="dorm_num"/>            
        </div>
        <div><label>生源地:</label>
            <select id="origin1" name="origin1">
                <option value="01">辽宁</option>
                <option value="02">北京</option>
            </select>
            <select id="origin2" name="origin2">
                <option value="01">沈阳</option>
                <option value="02">大连</option>
            </select>
        </div>
        <div><label>贫困等级:</label>
            <select id="level" name="level">
                <option value="1">很贫困</option>
                <option value="2">贫困</option>
            </select>
        </div>
        <div><label>贫困原因:</label><input id="reason" name="reason" type="text"/></div>
        <div><label>特长:</label><input id="skill" name="skill" type="text"/></div>
        <div><label>兼职:</label>
            <select id="ptime" name="ptime">
                <option value="1">是</option>
                <option value="0">否</option>
            </select>
        </div>
        <div><label>所获奖项:</label><input id="prize" name="prize" type="text"/></div>
      <div><hr/></div>

      <div>
        <button type="submit">提交</button>
        <button id="reset" type="button">重置</button>
      </div>

    </form>

    <!-- End Form -->

  </div>

</div>


<script type="text/javascript" src="../../javascript/lib/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../../javascript/lib/jquery-ui.min.js"></script>
<script type="text/javascript" src="../../javascript/register/jquery.idealforms.js"></script>

</body>
</html>
