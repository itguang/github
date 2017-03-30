<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>个人日记-个人博客</title>
<meta name="keywords" content="个人博客" />
<meta name="description" content="" />
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/animate.css" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
</head>

<body>
	<%@include file="header.jsp"%>
	<!--content start-->
	<div id="content">
		<!--left-->
		<div class="left" id="riji">
			<div class="weizi">
				<div class="wz_text">
					当前位置：<a href="#">首页</a>>
					<h1>个人日记</h1>
				</div>
			</div>
			<div class="rj_content">
				<!--时光-->
				<div class="shiguang animated bounceIn">
					<div class="left sg_ico">
						<img src="images/my_1.jpg" width="120" height="120" alt="" />
					</div>
					<div class="right sg_text">
						<img src="images/left.png" width="13" height="16" alt="左图标" />
						时间好象一把尺子，它能衡量奋斗者前进的进程。时间如同一架天平，它能称量奋斗者成果的重量；时间就像一把皮鞭，它能鞭策我们追赶人生的目标。时间犹如一面战鼓，它能激励我们加快前进的脚步。
					</div>
					<div class="clear"></div>
				</div>
				<!--时光 end-->
				<!--时光-->
				<div class="shiguang animated bounceIn">
					<div class="left sg_ico">
						<img src="images/my_1.jpg" width="120" height="120" alt="" />
					</div>
					<div class="right sg_text">
						<img src="images/left.png" width="13" height="16" alt="左图标" />
						时间好象一把尺子，它能衡量奋斗者前进的进程。时间如同一架天平，它能称量奋斗者成果的重量；时间就像一把皮鞭，它能鞭策我们追赶人生的目标。时间犹如一面战鼓，它能激励我们加快前进的脚步。
					</div>
					<div class="clear"></div>
				</div>
				<!--时光 end-->
				<!--时光-->
				<div class="shiguang animated bounceIn">
					<div class="left sg_ico">
						<img src="images/my_1.jpg" width="120" height="120" alt="" />
					</div>
					<div class="right sg_text">
						<img src="images/left.png" width="13" height="16" alt="左图标" />
						时间好象一把尺子，它能衡量奋斗者前进的进程。时间如同一架天平，它能称量奋斗者成果的重量；时间就像一把皮鞭，它能鞭策我们追赶人生的目标。时间犹如一面战鼓，它能激励我们加快前进的脚步。
					</div>
					<div class="clear"></div>
				</div>
				<!--时光 end-->
				<!--时光-->
				<div class="shiguang animated bounceIn">
					<div class="left sg_ico">
						<img src="images/my_1.jpg" width="120" height="120" alt="" />
					</div>
					<div class="right sg_text">
						<img src="images/left.png" width="13" height="16" alt="左图标" />
						时间好象一把尺子，它能衡量奋斗者前进的进程。时间如同一架天平，它能称量奋斗者成果的重量；时间就像一把皮鞭，它能鞭策我们追赶人生的目标。时间犹如一面战鼓，它能激励我们加快前进的脚步。
					</div>
					<div class="clear"></div>
				</div>
				<!--时光 end-->
				<!--时光-->
				<div class="shiguang animated bounceIn">
					<div class="left sg_ico">
						<img src="images/my_1.jpg" width="120" height="120" alt="" />
					</div>
					<div class="right sg_text">
						<img src="images/left.png" width="13" height="16" alt="左图标" />
						时间好象一把尺子，它能衡量奋斗者前进的进程。时间如同一架天平，它能称量奋斗者成果的重量；时间就像一把皮鞭，它能鞭策我们追赶人生的目标。时间犹如一面战鼓，它能激励我们加快前进的脚步。
					</div>
					<div class="clear"></div>
				</div>
				<!--时光 end-->
				<!--时光-->
				<div class="shiguang animated bounceIn">
					<div class="left sg_ico">
						<img src="images/my_1.jpg" width="120" height="120" alt="" />
					</div>
					<div class="right sg_text">
						<img src="images/left.png" width="13" height="16" alt="左图标" />
						时间好象一把尺子，它能衡量奋斗者前进的进程。时间如同一架天平，它能称量奋斗者成果的重量；时间就像一把皮鞭，它能鞭策我们追赶人生的目标。时间犹如一面战鼓，它能激励我们加快前进的脚步。
					</div>
					<div class="clear"></div>
				</div>
				<!--时光 end-->

			</div>
		</div>
		<!--end left -->
		<!--right-->
		<%@include file="right.jsp"%>
		<!--end  right-->
		<div class="clear"></div>

	</div>
	<!--content end-->
	<!--footer-->
	<%@include file="footer.jsp"%>
	<!--footer end-->
	<script type="text/javascript">
		jQuery(".lanmubox").slide({
			easing : "easeOutBounce",
			delayTime : 400
		});
	</script>
	<script type="text/javascript" src="js/nav.js"></script>
</body>
</html>

