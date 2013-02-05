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
			<form action="addmovie.htm" method="post" id="addMovieForm">
				<fieldset>
					<legend>Movie Information</legend>
					
					<c:if test="${movie != null}">
						<p align="left">
							<img alt="" src="<c:if test="${movie != null}">${movie.imageUrl}</c:if>" />
						</p>
					</c:if>
					
					<label>Movie Name</label>
					<input name="title" id="title" type="text" value="<c:if test="${movie != null}">${movie.title}</c:if>" />
					<label>Actor Name</label>
					<input name="actor" id="actor" type="text" value="<c:if test="${movie != null}">${movie.actorName}</c:if>" />
					<label>Actress Name</label>
					<input name="actress" id="actress" type="text" value="<c:if test="${movie != null}">${movie.actressName}</c:if>" />
					<label>Directed By</label>
					<input name="director" id="director" type="text" value="<c:if test="${movie != null}">${movie.flimDirector}</c:if>" />
					<label>Music By</label>
					<input name="music" id="music" type="text" value="<c:if test="${movie != null}">${movie.musicDirector}</c:if>" />
					<label>Image Url</label>
					<input name="imageUrl" id="imageUrl" type="text" value="<c:if test="${movie != null}">${movie.imageUrl}</c:if>" />
					
					<!--alternate submit button-->
					<!--input name="button" type="button" id="button" value="Submit" /-->
					<c:if test="${movie == null}">
		    			<input name="btnAddMovie" id="btnAddMovie" value="Add Movie" type="submit" class="button-submit" />
		    		</c:if>
		    		<c:if test="${movie != null}">
		    				<input name="btnAddMovie" id="btnAddMovie" value="Update Movie" type="submit" class="button-submit" />
		    				<input name="id" id="id" value="${movie.id}" type="hidden" />
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