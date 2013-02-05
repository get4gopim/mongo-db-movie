<%@ include file="include.jsp" %>

<!DOCTYPE html>

<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />  
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
<meta http-equiv="cache-control" content="max-age=200" />
<link href="style.css" media="handheld, screen" rel="stylesheet" type="text/css" />
<title><spring:message code="site.title"/></title>
</head>
<body>
<div class="mainwrapper">
	<div id="header">
		<div class="right-bg">
			<div id="logo">
				<a class="home-tab" href="index.htm">Home</a>
				<a href="index.htm"><img height="50" width="270" alt="logo" src="/resources/images/logo.jpg"/></a>
			</div>
			<div id="slogan">
				<div class="right-bg">
					<div class="left-bg">
						<img alt="" src="/resources/images/slogan.gif" /><br />
					</div>
				</div>
			</div>
			<div id="breadcrumb">
				<div class="right-bg">
					<div class="left-bg">
						<a href="#">Home Page</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="content">
		<div class="min-width">
		
			<div class="box1">
				<div class="tail-bottom">
				<div class="corner-right-top">
				<div class="corner-left-top">
				<div class="corner-right-bottom">
				<div class="corner-left-bottom">
				<div class="top-bg">
				<div class="bottom-bg">
					<div class="indent">
						<img alt="" src="/resources/images/home-title1.gif" class="title" /><br />
						Lorem ipsum dolor sit amet, consectetur adipisicing elit do eiusmod tempor incidiunt.<br />
						<div class="link">
							<a href="#">Read more</a>
						</div>
					</div>
				</div>
				</div>
				</div>
				</div>
				</div>
				</div>
				</div>
			</div>
			
			<div class="box2">
				<div class="tail-bottom">
				<div class="corner-right-top">
				<div class="corner-left-top">
				<div class="corner-right-bottom">
				<div class="corner-left-bottom">
				<div class="top-bg">
				<div class="bottom-bg">
					<div class="indent">
						<img alt="" src="/resources/images/home-title2.gif" class="title" /><br />
						Lorem ipsum dolor sit amet, consectetur adipisicing elit do eiusmod tempor incidiunt.<br />
						<div class="link">
							<a href="#">Read more</a>
						</div>
					</div>
				</div>
				</div>
				</div>
				</div>
				</div>
				</div>
				</div>
			</div>
			
		</div>
	</div>
	<div id="footer">
		<a class="home-tab" href="index.htm">Home</a>
		<p><spring:message code="site.copyrights"/> <a href="privacy.htm">Privacy policy</a></p>
	</div>
</div>
</body>
</html>