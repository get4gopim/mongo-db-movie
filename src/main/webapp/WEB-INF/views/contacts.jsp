<%@ include file="include.jsp"%>

<!DOCTYPE html>

<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<title><spring:message code="site.title" /></title>
	
	<link href="resources/styles/reset.css" rel="stylesheet" type="text/css" />
	<link href="resources/styles/baseStyles.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="resources/scripts/templates.js" /></script>
	
	<script type="text/javascript">
		function init() {
			var myStyleTweaks = new StyleTweaker();
			myStyleTweaks
					.add("Series60/5.0", "/resources/styles/tweaks/S605th.css");
			myStyleTweaks.add("Series60/3.2",
					"/resources/styles/tweaks/S603rdFP2.css");
			myStyleTweaks.add("AppleWebKit/420+",
					"/resources/styles/tweaks/S406th.css");
			myStyleTweaks.add("N900", "/resources/styles/tweaks/maemo.css");
			myStyleTweaks.add("Firefox/3.0a1 Tablet browser 0.3.7",
					"/resources/styles/tweaks/maemo.css");
			myStyleTweaks.add("Opera Mini/4",
					"/resources/styles/tweaks/operamini.css");
			myStyleTweaks.tweak();
		}
		addEvent("onload", init);
	</script>
</head>
<body>
		
		<div class="box-rounded">
			<div class="box-rounded-inner">
				<div class="box-rounded-outer">
					<h2>Contact Us</h2>
					<p>
						<spring:message code="contact.address.line1"/><br />
						<spring:message code="contact.address.line2"/><br />
						<spring:message code="contact.address.line3"/><br />
						<spring:message code="contact.address.line4"/><br />  
						<spring:message code="contact.address.line5"/><br />
					</p>
					
					<h2>Email :</h2>
					<p>get4gopim@gmail.com</p>
					
					<h2>Contact :</h2>
					<p>99520 13448</p>	
				</div>
			</div>
		</div>
		
		<ul class="button-rounded">
			<li><a href="index.htm"><img border="0" alt="Home" src="resources/images/home.png" /></a></li>
			<li><a href="filename.htm?path=contacts"><img border="0" alt="Contact" src="resources/images/contact.png" /></a></li>
			<li><a href="filename.htm?path=about"><img border="0" alt="About" src="resources/images/about.png" /></a></li>
			<li><a href="viewfeeds.htm"><img border="0" alt="Browse" src="resources/images/viewfeeds.png" /></a></li>
		</ul>
		
		<div id="footer" class="ft-large">
			<p>
				<spring:message code="site.copyrights" />
				<a href="http://www.facebook.com/get4gopi"><img border="0" alt="Follow us on facebook" src="resources/images/facebook.png" /></a>
				<a href="https://twitter.com/get4gopi"><img border="0" alt="Follow us on twitter" src="resources/images/twitter.png" /></a>
			</p>
		</div>
		
	</div>
	
</body>
</html>