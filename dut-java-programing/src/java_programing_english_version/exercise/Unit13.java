package java_programing_english_version.exercise;

import java.util.Scanner;

/*Checking symmetric number*/

public class Unit13 {
	public static boolean isSymmetricNumber(double number) {
		if (number < 0 || (long) number != number)
			return false;
		
		long tempNumber = (long) number;
		long reverseNumber = 0;
		while (tempNumber > 0) {
			reverseNumber = reverseNumber * 10 + (tempNumber % 10);
			tempNumber /= 10;
		}
		
		return reverseNumber == number;
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		double number = keyboard.nextDouble();
		if (Unit13.isSymmetricNumber(number))
			System.out.println("That is a Symmetric number");
		else
			System.out.println("That is NOT a Symmetric number");
		
		keyboard.close();
	}
}
