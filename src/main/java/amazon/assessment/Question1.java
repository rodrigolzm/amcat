package amazon.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * You work on a team whose job is to understand the most sought after toys for
 * the holiday season. A teammate of yours has built a webcrawler that extracts
 * a list of quotes about toys from different articles. You need to take these
 * quotes and identify which toys are mentioned most frequently. Write a
 * algorithm that identifies the top N toys out of a list of quotes and list of
 * toys.
 * <p>
 * Your algorithm should output the top N toys mentioned most frequently in the
 * quotes.<br>
 * Input:<br>
 * The input to the function/method consists of five arguments:<br>
 * numToys, an integer representing the number of toys;<br>
 * topToys, an integer representing the number of top toys your algorithm needs
 * to return;<br>
 * toys, a list of strings representing the toys;<br>
 * numQuotes, an integer representing the number of quotes about toys;<br>
 * quotes, a list of strings that consist of space-separated words representing
 * articles about toys.<br>
 * Output:<br>
 * Return a list of strings of the most popular N toys in order of most to least
 * frequently mentioned.
 * <p>
 * Note:<br>
 * The comparison of strings is case-insensitive.<br>
 * Multiple occurrences of a toy in a quote should be considered as a single
 * mention.<br>
 * If the value of topToys is more than the number of toys, return the names of
 * only the toys mentioned in the quotes.<br>
 * If toys are mentioned an equal number of times in quotes, sort
 * alphabetically.
 * <p>
 * Example<br>
 * Input:<br>
 * numToys = 6<br>
 * topToys = 2<br>
 * toys = ["elmo", "elsa", "legos", "drone", "tablet", "warcraft"]<br>
 * numQuotes = 6<br>
 * quotes = ["Emo is the hottest of the season! Elmo will be on every kid's
 * wishlist!", "The new Elmo dolls are super high quality", "Expect the Elsa
 * dolls to be very popular this year", "Elsa and Elmo are the toys I'll be
 * buying for my kids", "For parents of older kids, look into buying them a
 * drone", "Warcraft is slowly rising in popularity ahead of the holiday
 * season"];<br>
 * Output: ["elmo", "elsa"]<br>
 * Explanation:<br> 
 * "elmo" occurs in three different quotes, "elsa" occurs in two,
 * and "drone" and "warcraft" occur in one quote each.
 * 
 * 10 out of 21 passed.
 */
public class Question1 {

	public ArrayList<String> popularNToys(int numToys, int topToys, List<String> toys, int numQuotes,
			List<String> quotes) {

		Map<String, Integer> map = new TreeMap<>();

		for (String quote : quotes) {
			for (String toy : toys) {
				if (quote.contains(toy)) {
					map.put(toy, map.get(toy) == null ? 1 : map.get(toy) + 1);
				}
			}
		}

		Integer[] topCounters = new Integer[map.values().size()];
		int i = 0;
		for (Integer counter : map.values()) {
			topCounters[i] = counter;
			i++;
		}

		Arrays.sort(topCounters, Collections.reverseOrder());

		ArrayList<String> topToysList = new ArrayList<>();

		for (Entry<String, Integer> entry : map.entrySet()) {
			for (int index = 0; index < topToys && index < topCounters.length; index++) {
				if (entry.getValue() == topCounters[index] && !topToysList.contains(entry.getKey())) {
					topToysList.add(entry.getKey());
				}
			}
		}

		return topToysList;
	}
}
