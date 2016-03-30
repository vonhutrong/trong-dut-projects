package java_programing_english_version.exercise;

import java.util.Scanner;

//solve equation ax + b = 0

/**
 * @author trong
 * Jan 12, 2016
 */
public class Unit1 {
	private enum Solution {
		NO_SOLUTION, A_SOLUTION, INFINITELY_MANY_SOLUITONS
	}

	private double a;
	private double b;
	private double x;
	private Solution solution;

	public Unit1() {
	}

	public Unit1(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public void signArguments() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("We have a equation ax + b = 0\n" + "Let input arguments: ");
		System.out.print("a = ");
		a = keyboard.nextDouble();
		System.out.print("b = ");
		b = keyboard.nextDouble();
		keyboard.nextLine();
		keyboard.close();
	}

	public void solve() {
		if (a == 0 && b == 0) {
			solution = Solution.INFINITELY_MANY_SOLUITONS;
		} else if (a == 0 && b != 0) {
			solution = Solution.NO_SOLUTION;
		} else {
			solution = Solution.A_SOLUTION;
			x = -b / a;
		}
	}

	public void displayResult() {
		String result;
		switch (solution) {
		case INFINITELY_MANY_SOLUITONS:
			result = "The equation has infinitely many solutions";
			break;
		case NO_SOLUTION:
			result = "The equation has no solution";
			break;
		case A_SOLUTION:
			result = "The equation has a solution is " + x;
			break;
		default:
			result = "Some thing wrong :)";
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		Unit1 unit1 = new Unit1();
		unit1.signArguments();
		unit1.solve();
		unit1.displayResult();
	}
}
