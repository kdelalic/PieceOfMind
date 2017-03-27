<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
	<!-- Basic Page Needs -->
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <title>Piece of Mind</title>
    
    <!-- FONT€“ -->    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">	

   	<!-- CSS --> 
    <link rel="stylesheet" href="css/normalize.css">
  	<link rel="stylesheet" href="css/base.css">
  	<link rel="stylesheet" href="css/styles.css">
  	
  	<!-- Javascript --> 
  	<script src="js/Chart.js"></script>
  	
</head>

<body>
	<div class="all">
		<div class="sidebar">
			<div id="logo">
				<h1>Piece of Mind</h1>
			</div>
		</div>
		
		<div class="notSidebar">
			<div id="header"></div>
			<div id="title">
				
				<div class="three columns" id="searchTitle">
					<h3>Search for a new user:</h3> 
				</div>  
		        <div class="six columns" id="form">
		            <form method="get" action="search">
		                <div id="input"><input style="width:400px;" type="text" name="username" placeholder="Enter a userID..."></div>
		                <div id="button"><button type="submit" action="#" ></button></div>
		            </form>
		        </div>
			</div>
			
		     
		     <!--<div class="full"></div>-->
	    </div>
    </div>
</body>
</html>