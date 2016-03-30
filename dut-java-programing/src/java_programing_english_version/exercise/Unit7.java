package java_programing_english_version.exercise;

import java.util.Scanner;

/*S=15-1+1/2-1/3!+ … +(-1)^n.1/n!*/

public class Unit7 {
	
	public static Fraction calulateExpression(int n) throws IllegalArgumentException {
		if (n <= 0)
			throw new IllegalArgumentException("Please enter n > 0");
		
		Fraction sum = new Fraction(0, 1);
		Fraction delta = new Fraction(1, 1);
		
		for (int i = 1; i <= n; ++i)
			sum.add(delta.mul(new Fraction(-1, i)));

		return new Fraction(15).add(sum);
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("S=15-1+1/2-1/3!+ … +(-1)^n.1/n!\n" + "(n > 0) n = ");
		int n = keyboard.nextInt();
		try {
			Fraction sum = Unit7.calulateExpression(n);
			System.out.println("S = " + sum.toString() + " = " + sum.toRealNumber());
			sum = null;
		} catch (IllegalArgumentException argEx) {
			System.out.println(argEx.getMessage());
		}
		
		keyboard.close();
	}
}

