package amazon.demo;

import java.util.ArrayList;
//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;

/**
 * Eight houses, represented as cells, are arranged in a straight line. Each day
 * every cell competes with its adjacent cells (neighbors). An integer value of
 * 1 represents an active cell and a value of 0 represents an inactive cell. If
 * the neighbors on both the sides of a cell are either active or inactive,
 * the cell becomes inactive on the next day; otherwise the cell becomes active.
 * The two cells on each and have a single adjacent cell, so assume that the
 * unoccupied space on the opposite side is an inactive cell. Even after
 * updating the cell state, consider its previous state when updating the state
 * of other cells. The state information of all cells should be updated
 * simultaneously.
 * <p>
 * Write an algorithm to output the state of the cells after the given number of
 * days.<br>
 * Input:<br>
 * The input to the function/method consists of two arguments:<br>
 * states, a list of integers representing the current state of cells;<br>
 * days, an integer representing the number of days.<br>
 * Output:<br>
 * Return a list of integers representing the state of the cells after the given
 * number of days.<br>
 * Note:<br>
 * The elements of the list states contains 0s and 1s only.
 */
public class Demo1 {

	public List<Integer> cellCompete(int[] states, int days) {
		// list of integer to be return
		List<Integer> result = new ArrayList<>();
		// states validation
		if (states == null) {
			return null;
		} else if (states.length == 0) {
			return result;
		}
		// check number of days
		if (days > 0) {
			// iterate by number of days
			for (int day = 0; day < days; day++) {
				// create temp repo for new values
				int[] temp = new int[states.length];
				// iterate and get new values
				for (int index = 0; index < states.length; index++) {
					temp[index] = check(states, index);
				}
				// update the current array for the next day
				states = temp;
			}
		}
		// convert array to list
		for (int state : states) {
			result.add(state);
		}
		// return updated list
		return result;
	}

	/**
	 * Determine neighbor values and compare them. True if they are different,
	 * otherwise false.
	 */
	private int check(int[] states, int index) {
		int before = 0;
		int after = 0;
		// left boundary
		if (index - 1 >= 0) {
			before = states[index - 1];
		}
		// right boundary
		if (index + 1 < states.length) {
			after = states[index + 1];
		}
		// compare neighbors
		if (before != after) {
			return 1;
		}
		return 0;
	}
}
