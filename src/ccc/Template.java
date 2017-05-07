package ccc;

import java.util.ArrayList;

public class Template {

	// Creates the header template to be used on every page.
	public static String createHeader(String username, ArrayList<Tweet> tweets) {
		
		int counts[] = new int[4];
		for(int i = 0; i < tweets.size(); i++){
			for(int j = 0; j < 4; j++){
				if(Double.parseDouble(tweets.get(i).getAnalysis()[j]) != 0){
					counts[j]++;
				}
			}
		}
		
		double mostNeg = 1;
		Tweet mostNegT = null;
		double mostPos = -1;
		Tweet mostPosT = null;
		double sum = 0, avg = 0, sumRel = 0, sumEd = 0, sumMon = 0;
		String posCat = null, negCat = null;
		for (int j = 0; j < tweets.size(); j++) {
			sumRel += Double.parseDouble(tweets.get(j).getAnalysis()[1]);
			sumEd += Double.parseDouble(tweets.get(j).getAnalysis()[2]);
			sumMon += Double.parseDouble(tweets.get(j).getAnalysis()[3]);
			sum = Double.parseDouble(tweets.get(j).getAnalysis()[0]);
			avg += Double.parseDouble(tweets.get(j).getAnalysis()[0]);
			
			if (avg < mostNeg) {
				mostNeg = avg;
				mostNegT = tweets.get(j);
			}
			if (avg > mostPos) {
				mostPos = avg;
				mostPosT = tweets.get(j);
			}
		}
		
		avg = avg / counts[0];
		sumRel = sumRel / counts[1];
		sumEd = sumEd / counts[2];
		sumMon = sumMon / counts[3];
		if(counts[0] == 0){
			avg = 0;
		}
		if (counts[1] == 0){
			sumRel = 0;
		}
		if (counts[2] == 0){
			sumEd = 0;
		}
		if (counts[3] == 0){
			sumMon = 0;
		}
		System.out.println(avg + " " + sumRel + " " + sumEd + " " + sumMon);

		if ((sumRel > sumEd) && (sumRel > sumMon)) {
			posCat = "Relationships";
		} else if ((sumEd > sumRel) && (sumEd > sumMon)) {
			posCat = "Education";
		} else {
			posCat = "Money";
		}

		if ((sumMon < sumEd) && (sumMon < sumRel)) {
			negCat = "Money";
		} else if ((sumEd < sumMon) && (sumEd < sumRel)) {
			negCat = "Education";
		} else {
			negCat = "Relationships";
		}
		
		return "<!DOCTYPE html>"+
				"\n<head>" + 
					"\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"+
					"\n<meta name='viewport' content='width=device-width, initial-scale=1'>"+
					"\n<meta charset='utf-8'>"+
					"\n<title>Piece of Mind</title>"+
					"\n<link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800' rel='stylesheet'>"
					+ "<link rel='stylesheet' href='http://karlodelalic.com/normalize.css'><link rel='stylesheet' href='http://karlodelalic.com/base.css'>"
					+ "<link rel='stylesheet' href='http://karlodelalic.com/styles.css'><script src='http://karlodelalic.com/Chart.js'>"
					+ "</script></head><body>"
					+ "<div class='all' style='overflow:hidden'><div class='sidebar'>"
					+ "<div id='logo'><h1 style='text-align:center'>Piece of Mind</h1></div></div><div class='notSidebar'>"
					+ "<div id='title'>"
					+ "<div class='three columns' id='searchTitle'><h3>Search for a new user:</h3> </div>"
					+ "<div class='six columns' id='form'> <form method='get' action='search'>"
					+ "<div id='input' style='background-color:#e9ecf1;'><input style='width:400px; background-color:none;' type='text' name='username' placeholder='Enter a userID...'>"
					+ "</div><div id='button'><button type='submit' action='#' ></button></div></form></div></div>"
					+ "<div class='small' style='margin-left:30px'>"
					+ "<h4>User:</h4><h5>"+username+"</h5></div><div class='small'>"
					+ "<h4>Average:</h4><h5>"+avg+"</h5></div>"
					+ "<div class='small'><h4>Recent:</h4><h5>"+tweets.get(0).getTweet()+"</h5></div>"
					+ "<div class='small'><h4>Most Negative:</h4><h5>"+mostNeg+"</h5></div>"
					+ "<div class='big'><div id='chartCon'>"
					+ "<canvas id='myChart' width='400' height='400'></canvas>"
					+ "<script>var ctx = document.getElementById('myChart');"
					+ "var myChart = new Chart(ctx, {type: 'bar',data: {labels: ['Overall', 'Relationship', 'Education', 'Money'],"
					+ "datasets: [{label: 'Sentiment Analysis',data: [" + avg + "," + sumRel + "," + sumEd + "," + sumMon + "],backgroundColor: "
					+ "['rgba(255, 99, 132, 0.2)','rgba(54, 162, 235, 0.2)','rgba(255, 206, 86, 0.2)','rgba"
					+ "(75, 192, 192, 0.2)','rgba(153, 102, 255, 0.2)','rgba(255, 159, 64, 0.2)'],borderColor: "
					+ "['rgba(255,99,132,1)','rgba(54, 162, 235, 1)','rgba(255, 206, 86, 1)','rgba(75, 192, 192, 1)',"
					+ "'rgba(153, 102, 255, 1)','rgba(255, 159, 64, 1)'], borderWidth: 1 }]},options: {scales: { yAxes: [{ticks: "
					+ "{ beginAtZero:true }}]}}});</script></div><div id='chartCon2'><canvas id='myChart2' width='400' height='400'"
					+ "></canvas><script>var ctx = document.getElementById('myChart2');var myChart = new Chart(ctx, {type: 'radar',"
					+ "data: {labels: ['Relationship', 'Education', 'Money'],datasets: [{label: 'Sentiment Analyis',data: [" + sumRel 
					+ "," + sumEd + "," + sumMon + "],backgroundColor: ['rgba(255, 99, 132, 0.2)','rgba(54, 162, 235, 0.2)','rgba(255, 206, 86, 0.2)', 'r"
					+ "gba(75, 192, 192, 0.2)','rgba(153, 102, 255, 0.2)','rgba(255, 159, 64, 0.2)'],borderColor: ['rgba(255,99,132"
					+ ",1)', 'rgba(54, 162, 235, 1)','rgba(255, 206, 86, 1)','rgba(75, 192, 192, 1)','rgba(153, 102, 255, 1)','rgb"
					+ "a(255, 159, 64, 1)' ],borderWidth: 1}]},options: {scales: {yAxes: [{ticks: { beginAtZero:true}}]}}});</scrip"
					+ "t></div> </div>";
			}

	// Creates a footer template to be used on every page.
	public static String createFooter() {
		return "</body></html>";
	}

}