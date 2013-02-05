<%@ include file="include.jsp" %>

<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
<meta http-equiv="cache-control" content="max-age=200" />
<link href="style.css" media="handheld, screen" rel="stylesheet" type="text/css" />
<title><spring:message code="site.title"/></title>
<script type="text/javascript" src="ajax.js"></script>
</head>
<body>
<script type="text/javascript">
var spinner = new Image;
spinner.src = "/resources/images/ajax-loader.gif";
</script>
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
						<a href="#">About Us</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="content">
		<div class="min-width">
		
			<h2>A few words about us</h2>
			<em>Sed ut perspiciatis unde omniste natus error sit voluptatem accu santium.</em>
			<p>Billo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam vo luptatem quia voluptas.</p>
			<div class="link2" id='read-more1'>
				<a href="about-more1.htm" onclick="return updateElm('about-more1.htm', 'read-more1');">Read more</a>
			</div>
			
			<div class="box3">
				<div class="corner-left-bottom">
					<div class="title margin1">
						<div class="right-bg">
							<div class="left-bg">
								<h2>What we offer</h2>
							</div>
						</div>
					</div>
					<div class="indent">
						<ul class="list">
							<li><a href="#">Quisque nulla Vestibul lum libero</a></li>
							<li><a href="#">Aenean nec eros Vesti bulum</a></li>
							<li><a href="#">Lorem ipsum dolor sit ameonsectetuer</a></li>
							<li><a href="#">Suspendisse sollicituin velit se</a></li>
							<li><a href="#">hendrerit sit amet tin cidunt ac</a></li>
						</ul>
						<div class="link2" id='read-more2'>
							<a href="about-more2.htm" onclick="return updateElm('about-more2.htm', 'read-more2');">Read more</a>
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