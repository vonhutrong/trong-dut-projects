package java_programing_english_version.exercise;

import java.util.Scanner;

/*
n!! = 1*3*5*…*n (odd)
	= 2*4*6*…*n (even)
*/

/**
 * @author trong
 * Jan 13, 2016
 */
public class Unit9 {
	public static long doubleFactorial(int n) throws IllegalArgumentException {
		if (n < 0)
			throw new IllegalArgumentException("Please enter n >= 0");
		
		long result = 1;
		if (n % 2 == 0) {
			while (n >= 2) {
				result *= n;
				n -= 2;
			}
		} else {
			while (n >= 1) {
				result *= n;
				n -= 2;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Calculate n!!\n" + "Please enter n(n >= 0): ");
		int n = keyboard.nextInt();
		try {
			System.out.println(n + "!! = " + Unit9.doubleFactorial(n));
		} catch (IllegalArgumentException argEx) {
			System.out.println(argEx.getMessage());
		}
		
		keyboard.close();
	}
}
