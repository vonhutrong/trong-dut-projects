package java_programing_english_version.exercise;

import java.util.Scanner;

/*checking prime number*/

public class Unit11 {
	public static boolean isPrimeNumber(double number) {
		if ((long) number != number || number <= 1)
			return false;
		
		long integerNumber = (long) number;
		double squareRootOfNumber = Math.sqrt(integerNumber);
		for (int i = 2; i <= squareRootOfNumber; ++i) {
			if (integerNumber % i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		double number = keyboard.nextDouble();
		if (Unit11.isPrimeNumber(number))
			System.out.println("That is a prime number");
		else
			System.out.println("That is NOT a prime number");
		
		keyboard.close();
	}
}
