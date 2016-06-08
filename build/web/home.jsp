<%-- 
    Document   : index
    Created on : 2015-6-24, 16:41:38
    Author     : KittyG
--%>

<%@page import="com.javabean.common.User.Identity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>某某网站</title>
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <link href="css/index/style.css" rel="stylesheet" media="screen" type="text/css" />
        <script type="text/jscript" src="javascript/lib/jquery-1.8.2.min.js" ></script>
    </head>
    <body>
        <%
            String login_href;
            String login_text;
            String userid;
            String user;
            Identity identity;
            String identityString;
            userid = (String) session.getAttribute("userid");
            user = (String) session.getAttribute("username");
            identityString = (String) session.getAttribute("identity");
            identityString = null != identityString ? identityString : "0";
            identity = Identity.values()[Integer.parseInt(identityString)];

            if (identity == Identity.Visitor) {
                user = "游客";
            }
            if (user.length() > 10) {
                user = user.substring(0, 10) + "...";
            }
        %>
        <div class="head">
            <div class="nav1">
                <ul class="menu">
                    <li><a href="home.jsp"><span>网站首页</span></a></li>
                    <li><a href='/demo/2/about/' ><span>通知公告</span></a></li>
                    <li><a href='/demo/2/case/' ><span>活动论坛</span></a></li>
                    <li><a href='/demo/2/demo/2/services/'><span>项目申请</span></a></li>
                </ul>
            </div>
            <div class="nav2">
                <ul class="menu">
                    <li><a href="/project/jsp/std_info/detail.jsp"><span>你好,<%=user%></span></a></li>
                        <%
                            if (identity == Identity.Visitor) {
                                login_href = "/project/jsp/login/login.jsp";
                                login_text = "用户登录";
                            } else {
                                login_href = "/project/ExitLoginServlet";
                                login_text = "退出登录";
                            }
                        %>
                    <li><a href='<%=login_href%>' ><span><%=login_text%></span></a></li>
                </ul>
            </div>
        </div>
        <div class="fuwu">
            <div class="con">
                <p class="img"><img src="resources/images/index/c1.png" /></p>
                <p class="title"><a href="#">新闻公告</a></p>
                <p class="content">最新的消息都在这里，点击我成为学校里的万事通吧~</p>
                <p class="more"><a href="#">— 了解更多 —</a></p>
            </div>
            <div class="con">
                <p class="img"><img src="resources/images/index/c2.png" /></p>
                <p class="title"><a href="#">热门活动</a></p>
                <p class="content">这里有最新最热的活动信息，名额有限，人满即止，速来参加哦</p>
                <p class="more"><a href="#">— 了解更多 —</a></p>
            </div>

            <div class="con">
                <p class="img"><img src="resources/images/index/c3.png" /></p>
                <p class="title"><a href="#">项目申请</a></p>
                <p class="content">成为我们的一员，认真享受美好的大学生活吧</p>
                <p class="more"><a href="#">— 了解更多 —</a></p>
            </div>

            <div class="con">
                <p class="img"><img src="resources/images/index/c4.png" /></p>
                <p class="title"><a href="#">个人信息</a></p>
                <p class="content">完善自己的资料，让我们更加了解你，让我们给你提供更好的服务</p>
                <p class="more"><a href="#">— 了解更多 —</a></p>
            </div>



        </div>


        <div class="guanggao">—— 消息中心 ——</div>

        <div class="liebiao">

            <div class="con">
                <p class="img"><a href="/demo/2/case/14.html"><img src="resources/images/index/img.jpg" width="267" height="180" /></a></p>
                <p class="content">标准企业站模板，附带后台数据，后台可自行修改公司简介、联系方式、幻灯片，产品分类，已经做好了数据调用.</p>
                <p class="more"><a href="/demo/2/case/14.html">— 查看详情 —</a></p>
            </div>
            <div class="con">
                <p class="img"><a href="/demo/2/case/13.html"><img src="resources/images/index/img.jpg" width="267" height="180" /></a></p>
                <p class="content">此模板是基于织梦5.7gbk内核，适用于企业，工作室，个人站长。精简的代码，使用DIV+CSS布局，在修改页面的时候更加容</p>
                <p class="more"><a href="/demo/2/case/13.html">— 查看详情 —</a></p>
            </div>
            <div class="con">
                <p class="img"><a href="/demo/2/case/12.html"><img src="resources/images/index/img.jpg" width="267" height="180" /></a></p>
                <p class="content">织梦模板，导航和BANNER全部FLASH，织梦产品展示，附带后台数据，后台可自行修改公司简介、联系方式、幻灯片，产品</p>
                <p class="more"><a href="/demo/2/case/12.html">— 查看详情 —</a></p>
            </div>
            <div class="con">
                <p class="img"><a href="/demo/2/case/11.html"><img src="resources/images/index/img.jpg" width="267" height="180" /></a></p>
                <p class="content">此模板是基于织梦5.7gbk内核，适用于企业，工作室，个人站长。精简的代码，使用DIV+CSS布局，在修改页面的时候更加容</p>
                <p class="more"><a href="/demo/2/case/11.html">— 查看详情 —</a></p>
            </div>


        </div>




        <div class="guanggao">—— 合作伙伴 ——</div>
        <div class="guanggao2"></div>


        <div class="hezuo">
            <div class="hezuos">

                <ul>

                    <li><a href='http://www.dedecms.com' target='_blank'><img src='img/top_logo.jpg' width='88' height='31' border='0'></a> </li>

                    <li><a href='http://bbs.dedecms.com' target='_blank'><img src='images/wind/logo.png' width='88' height='31' border='0'></a> </li>

                </ul>
            </div>
        </div>

        <!--footer-->
        <div class="footer">

            <div class="con">
                <p class="title">最新资讯</p>
                <p class="content">
                <ul>
                    <li>
                        <a href="/demo/2/demo/2/news/3.html">为什么电商越来越难做？</a>
                    </li>
                    <li>
                        <a href="/demo/2/demo/2/news/4.html">为什么电商越来越难做？</a>
                    </li>
                    <li>
                        <a href="/demo/2/demo/2/news/5.html">为什么电商越来越难做？</a>
                    </li>
                    <li>
                        <a href="/demo/2/demo/2/news/6.html">为什么电商越来越难做？</a>
                    </li>
                    <li>
                        <a href="/demo/2/news/gonggao/2.html">进过一段时间的设计与测试</a>
                    </li>

                </ul>
                </p>
            </div>

            <div class="con">
                <p class="title">服务项目</p>
                <p class="content">
                <ul>

                </ul>
                </p>
            </div>

            <div class="con">
                <p class="title">联系我们</p>
                <p class="content">
                <ul>
                    <li>联系电话：15288888888</li>
                    <li>联系邮箱：884358@qq.com</li>
                    <li>服务QQ：884358</li>
                    <li>邮寄地址：西安市</li>
                    <li>邮政编码：610103</li>
                </ul>
                </ul>
                </p>
            </div>

            <div class="con">
                <p class="title">关于我们</p>
                <p class="content">
                    帮助客户实现网站计划，利用我们的境遇与技术应用到客户的需求并提升他们的计划，不论公司规模大小，在电脑显示屏所设定的范围内，我们的客户都将与世界各地的知名公司平分秋色！
                </p>
            </div>

        </div>

        <div class="bottom">

            <div class="bllx">
                <ul>

                    <li><a href="http://weibo.com"><img src="resources/images/index/l1.png" width="30" height="30"/></a></li>
                    <li><a href="http://t.qq.com/jason19905"><img src="resources/images/index/l2.png" width="30" height="30"/></a></li>
                    <li><a href="http://wpa.qq.com/msgrd?v=3&uin=272803886&site=dedemao&menu=yes"><img src="resources/images/index/l3.png" width="30" height="30"/></a></li>
                    <li><a href="#"><img src="resources/images/index/l4.png" width="30" height="30"/></a></li>

                </ul>
            </div>


            <div class="blrt">
                <!--需要修改底部版权、备案信息就在这里修改-->

                Copyright &copy; 2002-2011 绿风科技 版权所有 <a href=http://www.dedecms.com target='_blank'>Power by DedeCms</a>

                <!-- 以上就是可以修改的部分-->
            </div>
        </div>
    </body>
</html>
