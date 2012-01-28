<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
	<head>
		<meta charset="UTF-8"/>
		
		<title><sitemesh:write property='title'/></title>
		<meta name="description" content=""/>
		<meta name="author" content="matthew reid"/>
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
				
		<link rel="shortcut icon" href="<c:url value="/resources/favicon.ico"/>"/>
		<link rel="apple-touch-icon" href="<c:url value="/resources/apple-touch-icon.png"/>"/>
		<link rel="stylesheet" href="<c:url value="/resources/css/style.css?v=2"/>"/>
		<link rel="stylesheet" media="handheld" href="<c:url value="/resources/css/handheld.css?v=2"/>"/>
		<link href='http://fonts.googleapis.com/css?family=Leckerli+One&v2' rel='stylesheet' type='text/css'>
		<script type="text/javascript" src="<c:url value="/resources/js/libs/modernizr-1.7.min.js"/>"></script>
		
		<sitemesh:write property='head'/>
	</head>
	<body>
		<div id="container">
			<header>
				<h1 class="title"><a>CodeFish</a></h1>
			</header>
	
			<div id="main" role="main">
				<section class="content">
					<menu>
						<li><a href="#">home</a></li>
						<li><a href="#">blog</a></li>
						<li><a href="#">apps</a></li>
						<li><a href="#">contact</a></li>
					</menu>
					<article class="article"><sitemesh:write property='body'/></article>
				</section>				
			</div>
	
			<footer class="footer">
				&copy; 2011 CodeFish | Matthew Reid
				
				<span class="logos">
					<a href="http://www.w3.org/html/logo/">
						<img src="http://www.w3.org/html/logo/badge/html5-badge-h-css3-semantics.png" width="82" height="32" alt="HTML5 Powered with CSS3 / Styling, and Semantics" title="HTML5 Powered with CSS3 / Styling, and Semantics"/>
					</a>
				</span>			
			</footer>
		</div>
	
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
		<script type="text/javascript">!window.jQuery && document.write(unescape('%3Cscript src="<c:url value="/resources/js/libs/jquery-1.5.1.min.js"/>"%3E%3C/script%3E'))</script>
		<script type="text/javascript" src="<c:url value="/resources/js/plugins.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>
		<!--[if lt IE 7 ]>
		<script src="<c:url value="/resources/js/libs/dd_belatedpng.js"/>"></script>
		<script> DD_belatedPNG.fix('img, .png_bg');</script>
		<![endif]-->
	</body>
</html>
