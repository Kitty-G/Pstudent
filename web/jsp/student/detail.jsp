<%-- 
    Document   : detail
    Created on : 2015-8-26, 20:51:04
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
        <div><label>真实姓名;</label><input id="rname" name="rname" type="text"></div>
        <div>
            <label>性别</label>
            <select id="sex" name="sex">
            <option value ="2">请选择</option>
            <option value ="1">男</option>
            <option value="0">女</option>
            </select>
        </div>
        <div><label>身份证号:</label><input id="id" name="id" type="text"/></div>
        <div><label>学院:</label>
        <select name="dept" id="dept">
	<option value="-1">请选择</option>
        <option value="01">轻工与化学工程学院</option>
        <option value="02">生物工程学院</option>
        <option value="03">纺织与材料工程学院</option>
        <option value="04">机械工程与自动化学院</option>
        <option value="05">信息科学与工程学院</option>
        <option value="06">艺术设计学院</option>
        <option value="07">管理学院</option>
        <option value="08">外国语学院</option>
        <option value="09">体育部</option>
        <option value="10">现代教育技术部</option>
        <option value="11">研究生部</option>
        <option value="12">医务所</option>
        <option value="13">保卫处</option>
        <option value="99">其他</option>
        <option value="14">因材施教班</option>
        <option value="98">外聘</option>
        <option value="15">教务处</option>
        <option value="16">学生处</option>
        <option value="18">校领导</option>
        <option value="19">机关单位</option>
        <option value="20">服装学院</option>
        <option value="22">爱丁堡国际航空服务学院</option>
        <option value="23">国际教育学院</option>
        <option value="24">思政部</option>
        <option value="17">食品学院</option>
        <option value="25">教辅人员</option>
        </select>
        </div>
        <div><label>专业:</label>
        <select name="major" id="major">
          <option value="-1">请选择</option>
          <option value="0101">轻化工程</option>
        <option value="0102">应用化学</option>
        <option value="0103">化学工程与工艺</option>
        <option value="0104">环境工程</option>
        <option value="0305">材料科学与工程(高分子材料方向)</option>
        <option value="0306">材料科学与工程(无机非金属材料方向)</option>
        <option value="0107">材料科学与工程(电子信息材料方向)</option>
        <option value="0201">生物工程</option>
        <option value="0202">生物技术</option>
        <option value="1701">食品科学与工程</option>
        <option value="1702">食品质量与安全</option>
        <option value="0301">纺织工程</option>
        <option value="0109">印刷工程</option>
        <option value="0110">包装工程</option>
        <option value="0401">机械工程及自动化</option>
        <option value="0402">工业工程</option>
        <option value="0403">机械工程及自动化(中职升本)</option>
        <option value="0501">计算机科学与技术</option>
        <option value="0502">信息工程类</option>
        <option value="0503">信息与计算科学</option>
        <option value="0504">网络工程</option>
        <option value="0701">工商管理</option>
        <option value="0702">信息管理与信息系统</option>
        <option value="0703">国际经济与贸易</option>
        <option value="0704">人力资源管理</option>
        <option value="0801">英语</option>
        <option value="0707">国际经济与贸易（英语强化）</option>
        <option value="0601">艺术设计（视觉传达设计方向）</option>
        <option value="0602">艺术设计（环境艺术设计方向）</option>
        <option value="0603">艺术设计（设计管理方向）</option>
        <option value="0604">艺术设计（数字媒体艺术方向）</option>
        <option value="2301">艺术设计（中外合作办学）</option>
        <option value="2302">服装设计与工程（中外合作办学）</option>
        <option value="0811">日语（商务日语方向）</option>
        <option value="0608">服装设计与工程(工科)</option>
        <option value="0609">工业设计</option>
        <option value="0304">纺织工程（服装工程方向）</option>
        <option value="0611">雕塑</option>
        <option value="0612">艺术设计(专升本)</option>
        <option value="0505">电子信息工程</option>
        <option value="0506">自动化</option>
        <option value="0507">通信工程</option>
        <option value="0613">艺术设计</option>
        <option value="0614">服装设计与工程（中职升本）</option>
        <option value="0803">服装设计与工程（艺术类-亚太）</option>
        <option value="0804">计算机科学与技术（亚太）</option>
        <option value="0805">工商管理（亚太）</option>
        <option value="0307">材料化学</option>
        <option value="0705">工商管理（英语强化）</option>
        <option value="1401">教改班</option>
        <option value="9801">外聘</option>
        <option value="0615">数字媒体艺术</option>
        <option value="0706">物流管理</option>
        <option value="0806">英语（日语方向）</option>
        <option value="0404">机械工程及自动化（模具设计与制造方向）</option>
        <option value="0807">日语</option>
        <option value="0616">艺术设计（景观设计方向）</option>
        <option value="1703">食品科学与工程（公共营养方向）</option>
        <option value="0802">国际经济与贸易(英语强化）</option>
        <option value="0405">机械电子工程</option>
        <option value="2001">艺术设计（饰品设计）</option>
        <option value="1402">英语分级</option>
        <option value="2303">中外合作英语分级</option>
        <option value="0509">光源与照明</option>
        <option value="0619">艺术设计（建筑空间设计方向)</option>
        <option value="0620">数字媒体艺术（数字传播设计方向）</option>
        <option value="0621">艺术设计（视觉传达设计方向）(中职升本)</option>
        <option value="0622">艺术设计（环境艺术设计方向）(中职升本)</option>
        <option value="0711">工商管理（中职升本）</option>
        <option value="1403">信息创新实验班</option>
        <option value="0812">汉语国际教育</option>
        <option value="0408">机械工程</option>
        <option value="2201">空乘</option>
        <option value="0617">美术学</option>
        <option value="0708">电子商务</option>
        <option value="0808">对外汉语</option>
        <option value="0809">英语（商务）</option>
        <option value="2202">空中保安</option>
        <option value="1704">食品质量与安全（2+2）</option>
        <option value="0618">艺术设计（视觉传达设计2+2）</option>
        <option value="0709">国际经济与贸易（2+2）</option>
        <option value="2002">服装设计与工程（服装设计2+2）</option>
        <option value="0508">计算机科学与技术（2+2）</option>
        <option value="0810">英语(商务方向2+2)</option>
        <option value="0406">材料成型及控制工程</option>
        <option value="2003">服装设计与工程(服装设计方向)</option>
        <option value="2004">服装设计与工程(形象设计方向)</option>
        <option value="2005">服装设计与工程(服装设计与表演方向)</option>
        <option value="2006">服装设计与工程</option>
        <option value="2007">摄影</option>
        <option value="0710">国际经济与贸易（英语强化2+2）</option>
        <option value="0623">艺术设计（中职升本）</option>
        <option value="1705">食品科学与工程（创新班）</option>
        <option value="0407">机械工程及自动化（创新班）</option>
        <option value="0308">无机非金属材料工程</option>
        <option value="0309">高分子材料与工程</option>
        <option value="0624">视觉传达设计</option>
        <option value="0625">环境设计</option>
        <option value="0626">产品设计</option>
        <option value="2008">服装与服饰设计</option>
        <option value="0627">视觉传达设计（2+2）</option>
        <option value="0813">英语（2+2）</option>
        <option value="0628">文化产业管理</option>
        <option value="0629">风景园林</option>
        <option value="0630">艺术与科技</option>
        <option value="1706">海洋资源开发技术</option>
        <option value="0203">生物技术（中职升本）</option>
        <option value="0409">机械工程（中职升本）</option>
        <option value="0510">自动化（中职升本）</option>
        <option value="0631">产品设计（中职升本）</option>
        <option value="0632">环境设计（专升本）</option>
        <option value="0633">数字媒体艺术（专升本）</option>
        <option value="0634">视觉传达设计（专升本）</option>
        <option value="0635">产品设计（专升本）</option>
        <option value="2009">服装与服饰设计（2+2）</option>
        <option value="2304">视觉传达设计（中外合作办学）</option>
        <option value="1707">食品科学与工程（2+2）</option>
        <option value="0410">机械工程（创新班）</option>
        <option value="2010">表演</option>
        <option value="0204">葡萄与葡萄酒工程</option>
        <option value="0636">工艺美术</option>
        <option value="0111">轻化类因材施教班</option>
        <option value="2305">服装与服饰设计（中外合作办学）</option>
        <option value="0205">生物类因材施教班</option>
        <option value="0310">纺织类因材施教班</option>
        <option value="0311">材料类因材施教班</option>
        <option value="0411">机械类因材施教班</option>
        </select>

        </div>
        <div><label>年级:</label><input id="grade" name="grade" type="text"/></div>
        <div><label>班级:</label><input id="class" name="class" type="text"/></div>
        <div><label>电话:</label><input id="tel" name="tel" type="text"/></div>
        <div><label>邮箱:</label><input id="email1" name="email1" type="text"/><label>@</label><input id="email2" name="email2" type="text"/></div>
        <div><label>家庭住址:</label><input id="addr" name="addr" type="text"/></div>
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
