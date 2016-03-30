package java_programing_english_version.exercise;

import java.util.Scanner;

/*S=1+1/2+1/3+ … +1/n*/

public class Unit6 {
	public static double calculateExpression(int n) throws IllegalArgumentException {
		if (n <= 0)
			throw new IllegalArgumentException("Please enter n > 0");
		
		double sum = 0;
		for (int i = 1; i <= n; ++i)
			sum += 1.0 / i;
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter n (n > 0):");
		int n = keyboard.nextInt();
		try {
			System.out.println("S=1+1/2+1/3+ … +1/n=" + Unit6.calculateExpression(n));
		} catch (IllegalArgumentException argEx) {
			System.out.println(argEx.getMessage());
		}
		
		keyboard.close();
	}
}
