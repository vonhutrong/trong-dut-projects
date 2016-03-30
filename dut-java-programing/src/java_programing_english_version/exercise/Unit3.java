package java_programing_english_version.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*find intermediate number of three numbers */

/**
 * @author trong
 * Jan 12, 2016
 */
public class Unit3 {
	private double a;
	private double b;
	private double c;
	private double intermediateNumber;
	private Solution solution;
	
	private enum Solution {
		NO_SOLUTION, A_SOLUTION
	}
	
	public Unit3() {
	}
	
	public Unit3(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public void signArguments() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("We will find intermediate number of three numbers a, b and c\n"
				+ "Let sign arguments:");
		System.out.print("a = ");
		a = keyboard.nextDouble();
		System.out.print("b = ");
		b = keyboard.nextDouble();
		System.out.print("c = ");
		c = keyboard.nextDouble();
		keyboard.nextLine();
		
		keyboard.close();
	}
	
	public void  solve() {
		if (a == b || b == c || a == c) {
			solution = Solution.NO_SOLUTION;
			return;
		}
		
		List<Double> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		Collections.sort(list);
		intermediateNumber = list.get(1);
		solution = Solution.A_SOLUTION;
	}
	
	public void displayResult() {
		String result;
		if (solution == Solution.NO_SOLUTION)
			result = "We have no intermediate number";
		else
			result = "The intermediate number is " + intermediateNumber;
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		Unit3 unit3 = new Unit3();
		unit3.signArguments();
		unit3.solve();
		unit3.displayResult();
	}

}
