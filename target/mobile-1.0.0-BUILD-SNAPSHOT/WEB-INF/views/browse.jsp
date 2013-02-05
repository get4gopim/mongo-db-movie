<%@ include file="include.jsp"%>

<!DOCTYPE html>

<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<title><spring:message code="site.title" /></title>
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
	<div id="wrap">
		<div id="header"></div>
		
		<h3>Movie Browse</h3>
		<table>
	  		<caption>
	    		All Movie Categories
	  		</caption>
	  		<tr>
	    		<th scope="col">Movie Name</th>
	    		<th scope="col">Director</th>
	    		<th scope="col">Music By</th>
	 		</tr>
	  		<tr>
	    		<td>Lorem ipisum</td>
	    		<td>Lorem ipisum</td>
	    		<td>Lorem ipisum</td>
	  		</tr>
	  		<tr class="odd">
	    		<td>Lorem ipisum</td>
	    		<td>Lorem ipisum</td>
	    		<td>Lorem ipisum</td>
	  		</tr>
	  		<tr>
	    		<td>Lorem ipisum</td>
	    		<td>Lorem ipisum</td>
	    		<td>Lorem ipisum</td>
	  		</tr>
	  		 <tr class="odd">
	    		<td>Lorem ipisum</td>
	    		<td>Lorem ipisum</td>
	    		<td>Lorem ipisum</td>
	  		</tr>
		</table>
		
		<div class="home"><a href="index.htm">Home</a></div>
		
		<div id="footer" class="ft-large">
			<p>
				<spring:message code="site.copyrights" />
			</p>
		</div>
	</div>
</body>
</html>