package java_programing_english_version.exercise;

import java.util.Scanner;

/*solve equation ax^2 + bx + c = 0*/

/**
 * @author trong
 * Jan 12, 2016
 */
public class Unit2 {

	private double a;
	private double b;
	private double c;
	private double x1;
	private double x2;
	private Solution solution;

	private enum Solution {
		NO_SOLUTION, A_SOLUTION, TWO_SOLUTION
	}
	
	public Unit2() { }
	
	public Unit2(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public void signArguments() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Let solve equation ax^2 + bx + c = 0 (a # 0)\n" + "Now, let sign arguments:");
		while (true) {
			System.out.print("a = ");
			a = keyboard.nextDouble();
			if (a == 0)
				System.out.println("Please! a # 0");
			else
				break;
		}
		System.out.print("b = ");
		b = keyboard.nextDouble();
		System.out.print("c = ");
		c = keyboard.nextDouble();
		keyboard.nextLine();
		
		keyboard.close();
	}
	
	public void solve() {
		double delta = b * b - 4 * a * c;
		
		if (delta < 0) {
			solution = Solution.NO_SOLUTION;
		} else if (delta == 0) {
			solution = Solution.A_SOLUTION;
			x1 = -b / (2 * a);
			x2 = x1;
		} else {
			double squareRootOfDelta = Math.sqrt(delta);
			solution = Solution.TWO_SOLUTION;
			x1 = (-b + squareRootOfDelta) / (2 * a);
			x2 = (-b - squareRootOfDelta) / (2 * a);
		}
	}
	
	public void displayResult() {
		String result;
		
		switch (solution) {
		case NO_SOLUTION:
			result = "The equation has no solution";
			break;
		case A_SOLUTION:
			result = "The equation has dual test x1 = x2 = " + x1;
			break;
		case TWO_SOLUTION:
			result = "The equation has two test is x1 = " + x1 + " and x2 = " + x2;
			break;
		default:
			result = "Some thing wrong :)"; 
		}
		
		System.out.println(result);
	}
	
	public static void main(String [] args) {
		Unit2 unit2 = new Unit2();
		unit2.signArguments();
		unit2.solve();
		unit2.displayResult();
	}
}
