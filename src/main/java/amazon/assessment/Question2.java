package amazon.assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You have been given a task of reordering some data from a log file. In the
 * log file, every line is a space-delimited list of strings; all lines begin
 * with an alphanumeric identifier. There will be no lines consisting only of an
 * identifier. After the alphanumeric identifier, a line will consist of either:
 * <ul>
 * <li>a list of words using only lowercase English letters,
 * <li>or list of only integers.
 * </ul>
 * You have to reorder the data such that all of the lines with words are at the
 * top if the log file. The lines with words are ordered lexicographically,
 * ignoring the identifier except in the case of ties. In the case of the
 * ties(if there are two lines that are identical except for the identifier),
 * the identifier is used to order lexicographically.<br>
 * Alphanumeric should be sorted ASCII order (numbers come before letters). The
 * identifiers must still be part of the lines in the output strings. Lines with
 * integers must be left in the original order they were in the file.
 * <p>
 * Write an algorithm to reorder the data in the log file, according to the
 * rules above.<br>
 * Input<br>
 * The input to the function/method consists of two arguments:<br>
 * logFileSize, an integer representing the number of lines in the log file;<br>
 * logLines, a list of string representing the log file.<br>
 * Output:<br>
 * Return a list of strings representing the reordered log file data.
 * <p>
 * Note:<br>
 * Identifiers consists of the only English letters and numbers.<br>
 * <p>
 * Example:<br>
 * Input:<br>
 * logFileSize = 5<br>
 * logLines = <br>
 * [a1 9 2 3 1]<br>
 * [g1 Act car]<br>
 * [zo4 4 7]<br>
 * [ab1 off KEY dog]<br>
 * [a8 act zoo]<br>
 * Output:<br>
 * [g1 Act car]<br>
 * [a8 act zoo]<br>
 * [ab1 off KEY dog]<br>
 * [a1 9 2 3 1]<br>
 * [z04 4 7]<br>
 * <p>
 * Explanation:<br>
 * Second, fourth, and fifth lines are the lines with words. According to the
 * lexicographical order, the second line will be re-ordered first in log file,
 * then fifth, and fourth comes in the log file. Next, the lines with numbers
 * come in order in which these lines were in the input.
 * 
 * 9 out of 23 passed.
 */
public class Question2 {

	public List<String> reorderLines(int logFileSize, List<String> logLines) {

		Collections.sort(logLines);

		List<String> words = new ArrayList<>();
		List<String> numbers = new ArrayList<>();

		for (String line : logLines) {
			String noId = line.substring(line.indexOf(" ") + 1);
			if (noId.matches("^(\\d).*")) {
				numbers.add(noId);
			} else {
				words.add(noId);
			}
		}

		Collections.sort(words);
		Collections.sort(numbers);

		List<String> lines = new ArrayList<>();
		lines.addAll(words);
		lines.addAll(numbers);

		List<String> result = new ArrayList<>();
		for (String line : lines) {
			for (String fullLine : logLines) {
				if (fullLine.contains(line) && !result.contains(fullLine)) {
					result.add(fullLine);
				}
			}
		}

		return result;
	}

}
