<%@ include file="include.jsp" %>

<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
<meta http-equiv="cache-control" content="max-age=200" />
<link href="/resources/style.css" media="handheld, screen" rel="stylesheet" type="text/css" />
<title><spring:message code="site.title"/></title>
<script type="text/javascript" src="/resources/ajax.js"></script>
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
						<a href="#">Contacts</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="content">
		<div class="min-width">
		
			<h2>Contact information</h2>
			<em>
			<spring:message code="contact.address.line1"/><br />
			<spring:message code="contact.address.line2"/><br />
			<spring:message code="contact.address.line3"/><br /> 
			<spring:message code="contact.address.line4"/><br />  
			<spring:message code="contact.address.line5"/></em>
			<div id="contact">
				<div class="f-left">Mobile:</div><div class="f-right nowrp">+91 99520 13448</div><br class="clear" />
				<div class="f-left">E-mail:</div><div class="f-right"> <a href="#">get4gopim@gmail.com</a></div><br class="clear"/>
				<div class="f-left"><a href="www.facebook.com/facebook"><img src="/resources/images/facebook.jpg" /></a></div><br class="clear"/>
			</div>
			
			<div class="box3">
				<div class="corner-left-bottom">
					<div class="title margin1">
						<div class="right-bg">
							<div class="left-bg">
								<h2 class="text2">Contact form</h2>
							</div>
						</div>
					</div>
					<div class="indent">
						<form method="get" action="#" id="ContactForm">
							<div>
								Name:<br />
								<input id="your-name" type="text" /><br/>
								E-mail:<br />
								<input id="your-email" type="text" /><br/>
								Message:<br />
								<textarea id="your-message" rows="5" cols="10"></textarea><br/>
								<div class="taright">
									<button id="clear" type="reset"><span>Clear</span></button>&nbsp;&nbsp;<button id="send" type="submit"><span>Send</span></button>
								</div>
							</div>
						</form>
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