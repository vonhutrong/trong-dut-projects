package java_programing_english_version.exercise;

import java.util.Scanner;

/*S=1+1/3!+1/5!+ … +1/(2n-1)!*/

/**
 * @author trong
 * Jan 13, 2016
 */
public class Unit8 {
	public static Fraction calculateExpression(int n) throws IllegalArgumentException {
		if (n <= 0)
			throw new IllegalArgumentException("Please enter n > 0");
		
		Fraction sum = new Fraction(1);
		Fraction delta = new Fraction(1);
		
		for (int i = 2; i <= n; ++i) {
			sum.add(delta.mul(new Fraction(1, 2 * i - 2)).mul(new Fraction(1, 2 * i - 1)));
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("S=1+1/3!+1/5!+ … +1/(2n-1)!\n"
				+ "Please enter n (n > 0): ");
		int n = keyboard.nextInt();
		try {
			Fraction sum = Unit8.calculateExpression(n);
			System.out.println("S = " + sum.toString() + " = " + sum.toRealNumber());
		} catch (IllegalArgumentException argEx) {
			System.out.println(argEx.getMessage());
		}
		
		keyboard.close();
	}
}
