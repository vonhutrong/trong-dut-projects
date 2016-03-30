package java_programing_english_version.exercise;

import java.util.Scanner;

/*Checking square number*/

/**
 * @author trong
 * Jan 14, 2016
 */
public class Unit12 {
	public static boolean isSquareNumber(double number) {
		if (number < 0 || (long) number != number)
			return false;
		
		double squareRootOfNumber = Math.sqrt(number);
		if ((long) squareRootOfNumber != squareRootOfNumber)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		double number = keyboard.nextDouble();
		if (Unit12.isSquareNumber(number))
			System.out.println("That is a square number");
		else
			System.out.println("That is NOT a square number");
		
		keyboard.close();
	}
}
