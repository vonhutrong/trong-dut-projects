package java_programing_english_version.exercise;

import java.util.Scanner;

/*checking if number k is Fibonacci number?*/

/**
 * @author trong
 * Jan 14, 2016
 */
public class Unit17 {
	public static boolean isFibonacciNumber(double number) {
		return Unit12.isSquareNumber(5 * number * number + 4) ||
				Unit12.isSquareNumber(5 * number * number - 4);
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter n: ");
		if (Unit17.isFibonacciNumber(keyboard.nextDouble()))
			System.out.println("It is Fibonacci number");
		else
			System.out.println("It is NOT Finbonacci number");
		keyboard.close();
	}
}
