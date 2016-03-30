package java_programing_english_version.exercise;

import java.util.Scanner;

/*finding all prime number smaller than a number*/

public class Unit14 {
	public static void showAllPrimeNumberSmallerThanNumber(long n) {
		if (n <= 1) {
			System.out.println("We have no prime number");
			return;
		}
		
		StringBuffer s = new StringBuffer("We have some prime numbers:");
		for (long i = 2; i <= n; ++i) {
			if (Unit11.isPrimeNumber(i))
				s.append(" " + i + ";");
		}
		System.out.println(s.toString());
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a bound number: ");
		Unit14.showAllPrimeNumberSmallerThanNumber(keyboard.nextLong());
		
		keyboard.close();
	}
}
