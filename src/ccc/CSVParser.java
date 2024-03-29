package ccc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVParser {

	private static final char DEFAULT_SEPARATOR = ',';
	private static final char DEFAULT_QUOTE = '"';

	public static ArrayList<User> parse(String csvFile) throws FileNotFoundException {
		System.out.println(new File(".").getAbsoluteFile());
		ArrayList<User> userList = new ArrayList<User>();
		Scanner scanner = new Scanner(new File(csvFile), "UTF-8");
		String tweetLine = null;
		Boolean pass = false;
		List<String> line = null;
		String prevUser = null;
		User user = null;

		while (scanner.hasNext()) {
			tweetLine = scanner.nextLine();
			pass = false;
			while (!pass) {
				try {
					line = parseLine(tweetLine);
					for (int i = 0; i < 8; i++) {
						line.get(i);
					}
					pass = true;
				} catch (IndexOutOfBoundsException exception) {
					tweetLine += scanner.nextLine();
				}
			}

			if (line.get(3).equals(prevUser)) {
				Tweet tweet = new Tweet(line.get(0), line.get(1), line.get(2), line.get(4), line.get(5), line.get(6),
						line.get(7));
				user.addTweetToTweets(tweet);
			} else {
				userList.add(user);
				user = new User(line.get(3));
				Tweet tweet = new Tweet(line.get(0), line.get(1), line.get(2), line.get(4), line.get(5), line.get(6),
						line.get(7));
				user.addTweetToTweets(tweet);
			}
			prevUser = line.get(3);

		}
		scanner.close();

		return userList;

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