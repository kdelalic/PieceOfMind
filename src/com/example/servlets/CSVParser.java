package com.example.servlets;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVParser {

	private static final char DEFAULT_SEPARATOR = ',';
	private static final char DEFAULT_QUOTE = '"';

	public static void main(String[] args) throws Exception {

		String csvFile = "sortedTweets.csv";
		Scanner scanner = new Scanner(new File(csvFile),"UTF-8");
		String tweetLine = null, check;
		Boolean pass = false;
		List<String> line = null;

		while (scanner.hasNext()) {
			tweetLine = scanner.nextLine();
			pass = false;
			while (!pass) {
				try {
					line = parseLine(tweetLine);
					for (int i = 0; i < 8; i++) {
						check = line.get(i);
					}
					pass = true;
				} catch (IndexOutOfBoundsException exception) {
					tweetLine += scanner.nextLine();
				}
			}
			System.out.println("Location= " + line.get(0) + ", Date and Time= " + line.get(1) + " , Tweet="
					+ line.get(2) + " , Username=" + line.get(3) + " , Relationship=" + line.get(4) + " , Education="
					+ line.get(5) + " , Money=" + line.get(6) + " , IDK=" + line.get(7));
		}
		scanner.close();

	}

	public static List<String> parseLine(String cvsLine) {
		return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
	}

	public static List<String> parseLine(String cvsLine, char separators) {
		return parseLine(cvsLine, separators, DEFAULT_QUOTE);
	}

	public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

		List<String> result = new ArrayList<>();

		// if empty, return!
		if (cvsLine == null && cvsLine.isEmpty()) {
			return result;
		}

		if (customQuote == ' ') {
			customQuote = DEFAULT_QUOTE;
		}

		if (separators == ' ') {
			separators = DEFAULT_SEPARATOR;
		}

		StringBuffer curVal = new StringBuffer();
		boolean inQuotes = false;
		boolean startCollectChar = false;
		boolean doubleQuotesInColumn = false;

		char[] chars = cvsLine.toCharArray();

		for (char ch : chars) {

			if (inQuotes) {
				startCollectChar = true;
				if (ch == customQuote) {
					inQuotes = false;
					doubleQuotesInColumn = false;
				} else {

					// Fixed : allow "" in custom quote enclosed
					if (ch == '\"') {
						if (!doubleQuotesInColumn) {
							curVal.append(ch);
							doubleQuotesInColumn = true;
						}
					} else {
						curVal.append(ch);
					}

				}
			} else {
				if (ch == customQuote) {

					inQuotes = true;

					// Fixed : allow "" in empty quote enclosed
					if (chars[0] != '"' && customQuote == '\"') {
						curVal.append('"');
					}

					// double quotes in column will hit this!
					if (startCollectChar) {
						curVal.append('"');
					}

				} else if (ch == separators) {

					result.add(curVal.toString());

					curVal = new StringBuffer();
					startCollectChar = false;

				} else if (ch == '\r') {
					// ignore LF characters
					continue;
				} else if (ch == '\n') {
					// the end, break!
					break;
				} else {
					curVal.append(ch);
				}
			}

		}

		result.add(curVal.toString());

		return result;
	}

}