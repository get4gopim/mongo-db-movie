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
		
		<div id="content">
			<h1 class="top-aligned">Add Movie Request</h1>
			<div class="box-flat">
			<form action="imdbsearchmovie.htm" method="post" id="addMovieForm">
				<fieldset>
					<legend>Movie Information</legend>
					
						<p align="left">
							<input name="searchTitle" id="searchTitle" type="text" value="" /> 
							<input name="btnSearchMovie" id="btnSearchMovie" value="Search" type="submit" class="button-submit" />
						</p>
						
						<c:if test="${error != null}">
							<font color="red">Error : ${error}</font>
						</c:if>
					
					<c:if test="${movie != null}">
						<label>Movie Name</label>
						<input name="title" id="title" type="text" value="${movie.title}" />
						<label>Languages</label>
						<input name="actor" id="languages" type="text" value="${movie.languages}" />
						<label>Country</label>
						<input name="actress" id="actress" type="text" value="${movie.country}" />
						<label>Year</label>
						<input name="director" id="director" type="text" value="${movie.year}" />
						<label>Genres</label>
						<input name="music" id="music" type="text" value="${movie.genres}" />
						<label>Runtime</label>
						<input name="imageUrl" id="imageUrl" type="text" value="${movie.runtime}" />
					</c:if>
					
					
				</fieldset>
			</form>
		</div>
		
		<ul class="button-rounded">
			<li><a href="index.htm"><img border="0" alt="Home" src="resources/images/home.png" /></a></li>
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