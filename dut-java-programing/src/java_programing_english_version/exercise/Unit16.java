package java_programing_english_version.exercise;

import java.util.Scanner;

/*finding n Fibonacci numbers firstly*/

/**
 * @author trong
 * Jan 14, 2016
 */
public class Unit16 {
	public static void printListFibonacciNumbers(long n) {
		long before = -1;
		long after = 1;
		long current;
		
		do {
			current = before + after;
			before = after;
			after = current;
			System.out.println(current + " ");
		} while (current <= n);
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter n:");
		Unit16.printListFibonacciNumbers(keyboard.nextLong());
		keyboard.close();
	}
}
