<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
	<head>
		<!-- Basic Page Needs -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta charset="utf-8">
	    <title>Piece of Mind</title>
	    
	    <style type="text/css"><%@include file="css/normalize.css" %></style>
	    <style type="text/css"><%@include file="css/base.css" %></style>
		<style type="text/css"><%@include file="css/styles.css" %></style>
	</head>
	
	<body>
	<div id="everything">
		<h1>Piece of Mind</h1>
	
		<div id="userSearch">
		    <form method="get" action="search">
		    	<h3>Search User</h3>
				<input id="textArea" style="width:400px;" type="text" name="username" placeholder="Enter a userID...">
				<input id="input" type="submit" value="submit"/> 	
			</form>
		</div>
	
		<div id="mapSearch">
		    <form method="get" action="/2XB3Final/Page2">
		    	<h3>Search Phrase</h3>
		        <input id="textArea" style="width:400px;" type="text" name="query" placeholder="Enter a word/phrase...">
		        <input id="input" type="submit" value="submit"/> 	
		    </form>
	    </div>
	 </div>
	</body>
</html>