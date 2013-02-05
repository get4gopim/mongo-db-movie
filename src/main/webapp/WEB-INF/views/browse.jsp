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
					.add("Series60/5.0", "resources/styles/tweaks/S605th.css");
			myStyleTweaks.add("Series60/3.2",
					"resources/styles/tweaks/S603rdFP2.css");
			myStyleTweaks.add("AppleWebKit/420+",
					"resources/styles/tweaks/S406th.css");
			myStyleTweaks.add("N900", "resources/styles/tweaks/maemo.css");
			myStyleTweaks.add("Firefox/3.0a1 Tablet browser 0.3.7",
					"resources/styles/tweaks/maemo.css");
			myStyleTweaks.add("Opera Mini/4",
					"resources/styles/tweaks/operamini.css");
			myStyleTweaks.tweak();
		}
		addEvent("onload", init);
	</script>
</head>
<body>
	<div id="wrap">
		<div id="header"></div>
		
		<h3>Movie Browse</h3>
		<table border="0" cellpadding="1" cellspacing="1">
	  		<caption>
	    		All Movie Categories
	  		</caption>
	  		<tr>
	  			<th scope="col">S.No</th>
	    		<th scope="col">Movie</th>
	    		<th scope="col">Director</th>
	    		<th scope="col">Music</th>
	    		<th scope="col">Actions</th>
	 		</tr>
	 		<c:forEach var="row" items="${listMovies}" varStatus="status">
		  		<tr>
		    		<td>${status.count}</td>
		    		<td><a href="editmovie.htm?id=${row.id}">${row.title}</a></td>
		    		<td><a href="browse.htm?searchBy=director&value=${row.flimDirector}">${row.flimDirector}</a></td>
		    		<td><a href="browse.htm?searchBy=music&value=${row.musicDirector}">${row.musicDirector}</a></td>
		    		<td align="left">
		    			<a href="deletemovie.htm?id=${row.id}"><img border="0" alt="Delete" src="resources/images/delete.png" /></a>
		    		</td>
		  		</tr>		  		
	  		</c:forEach>
		</table>
		
		<br />
		<br />
		
		<ul class="button-rounded">
			<li><a href="index.htm"><img border="0" alt="Home" src="resources/images/home.png" /></a></li>
			<li><a href="filename.htm?path=addmovie"><img border="0" alt="Add" src="resources/images/cd_add.png" /></a></li>
			<li><a href="browse.htm"><img border="0" alt="Browse" src="resources/images/browse.png" /></a></li>
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