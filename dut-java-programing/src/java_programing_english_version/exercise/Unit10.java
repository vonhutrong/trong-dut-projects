package java_programing_english_version.exercise;

/*calculating sum and product of numbers in integer number*/

import java.util.Scanner;

public class Unit10 {
	public static void doIt(long number) throws IllegalArgumentException {
		if (number < 0)
			throw new IllegalArgumentException("Please enter a positive integer number");
		
		int sum = 0;
		int product = (number == 0) ? 0 : 1;
		long delta;
		while (number > 0) {
			delta = number % 10;
			number /= 10;
			sum += delta;
			product *= delta;
		}
		
		System.out.println("sum = " + sum + "\nproduct = " + product);
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a positive integer number: ");
		long number = keyboard.nextLong();
		try {
			Unit10.doIt(number);
		} catch (IllegalArgumentException argEx) {
			System.out.println(argEx.getMessage());
		}
		
		keyboard.close();
	}
}
