package com.example.servlets;

public class Template {

	// Creates the header template to be used on every page.
	public static String createHeader(String username) {

		return "<!DOCTYPE html>"+
				"\n<head>" + 
					"\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"+
					"\n<meta name='viewport' content='width=device-width, initial-scale=1'>"+
					"\n<meta charset='utf-8'>"+
					"\n<title>Piece of Mind</title>"+
						"\n<link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800' rel='stylesheet'><link rel='stylesheet' href='css/normalize.css'><link rel='stylesheet' href='css/base.css'><link rel='stylesheet' href='css/styles.css'><script src='js/Chart.js'></script></head><body><div class='all'><div class='sidebar'><div id='logo'><h1>Piece of Mind</h1></div></div><div class='notSidebar'><div id='header'></div><div id='title'><div class='three columns' id='searchTitle'><h3>Search for a new user:</h3> </div>  <div class='six columns' id='form'> <form method='get' action='search'><div id='input'><input style='width:400px;' type='text' name='username' placeholder='Enter a userID...'></div><div id='button'><button type='submit' action='#' ></button></div></form></div></div> <div class='small'><h4>User:</h4></div><div class='small'><h4>Average:</h4></div><div class='small'><h4>Recent:</h4></div><div class='small'><h4>Overall:</h4></div><div class='big'><div id='chartCon'><canvas id='myChart' width='400' height='400'></canvas><script>var ctx = document.getElementById('myChart');var myChart = new Chart(ctx, {type: 'bar',data: {labels: ['-2', '-2', '0', '1', '2', '-'],datasets: [{label: 'Sentiment Analysis',data: [12, 19, 3, 5, 2, 3],backgroundColor: ['rgba(255, 99, 132, 0.2)','rgba(54, 162, 235, 0.2)','rgba(255, 206, 86, 0.2)','rgba(75, 192, 192, 0.2)','rgba(153, 102, 255, 0.2)','rgba(255, 159, 64, 0.2)'],borderColor: ['rgba(255,99,132,1)','rgba(54, 162, 235, 1)','rgba(255, 206, 86, 1)','rgba(75, 192, 192, 1)','rgba(153, 102, 255, 1)','rgba(255, 159, 64, 1)'], borderWidth: 1 }]},options: {scales: { yAxes: [{ticks: { beginAtZero:true }}]}}});</script></div><div id='chartCon2'><canvas id='myChart2' width='400' height='400'></canvas><script>var ctx = document.getElementById('myChart2');var myChart = new Chart(ctx, {type: 'radar',data: {labels: ['-2', '-1', '0', '1', '2', '-'],datasets: [{label: 'Sentiment Analyis',data: [12, 19, 11, 15, 0, 13],backgroundColor: ['rgba(255, 99, 132, 0.2)','rgba(54, 162, 235, 0.2)','rgba(255, 206, 86, 0.2)', 'rgba(75, 192, 192, 0.2)','rgba(153, 102, 255, 0.2)','rgba(255, 159, 64, 0.2)'],borderColor: ['rgba(255,99,132,1)', 'rgba(54, 162, 235, 1)','rgba(255, 206, 86, 1)','rgba(75, 192, 192, 1)','rgba(153, 102, 255, 1)','rgba(255, 159, 64, 1)' ],borderWidth: 1}]},options: {scales: {yAxes: [{ticks: { beginAtZero:true}}]}}});</script></div> </div>";
			}

	// Creates a footer template to be used on every page.
	public static String createFooter() {
		return "</body></html>";
	}

}