package amazon.demo;

import java.util.Arrays;

/**
 * The greatest common divisor (GCD), also called highest common factor (HCF) of
 * N numbers is the largest positive integer that divides all numbers without
 * giving a remainder.
 * <p>
 * Write an algorithm to determine the GCD of N positive integers.<br>
 * Input<br>
 * The input to the function/method consists of two arguments: <br>
 * num, an integer representing the number of positive integers(N).<br>
 * arr, a list of positive integers.<br>
 * Output<br>
 * Return an integer representing the GCD of the given integers.
 * <p>
 * Example<br>
 * Input:<br>
 * num = 5<br>
 * arr = [2, 4, 6, 8, 10]<br>
 * Output:<br>
 * 2<br>
 * Explanation:<br>
 * The largest positive integer that divides all the positive integers 2, 4, 6,
 * 8, 10 without a remainder is 2. So, the output is 2.
 */
public class Demo2 {

	public int generalizedGCD(int num, int[] arr) {
		// array validation
		if (arr == null || arr.length == 0) {
			return 0;
		}
		// set gcd and counter
		int gcd = 0;
		int counter = 1;
		// sort array
		Arrays.sort(arr);
		// iterate until hits the first element
		while (counter <= arr[0]) {
			// check if the counter is divisible
			if (isDivisible(arr, counter)) {
				gcd = counter;
			}
			counter++;
		}
		// return higher GCD
		return gcd;

	}

	/**
	 * check if all elements are divisible by a number. True if they are, otherwise
	 * false.
	 */
	private boolean isDivisible(int[] array, int number) {
		for (int element : array) {
			if (element % number != 0) {
				return false;
			}
		}
		return true;
	}
}