package java_programing_english_version.exercise;

import java.util.Scanner;

/*greatest common divisor and least common multiple*/

/**
 * @author trong
 * Jan 14, 2016
 */
public class Unit18 {
	public static long greatestCommonDivisor(long a, long b) {
		long absA = Math.abs(a);
		long absB = Math.abs(b);
		
		if (absA == 0 || absB == 0)
			return absA + absB;
		
		while (absA != absB) {
			if (absA > absB)
				absA -= absB;
			else
				absB -= absA;
		}
		return absA;
	}
	
	public static long leastCommonMultiple(long a, long b) {
		return a * (b / greatestCommonDivisor(a, b));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter two numbers: ");
		System.out.print("a = ");
		long a = scanner.nextLong();
		System.out.print("b = ");
		long b = scanner.nextLong();
		
		System.out.println("Greatest common divisor = " + Unit18.greatestCommonDivisor(a, b));
		System.out.println("Least common multiple = " + Unit18.leastCommonMultiple(a, b));
		
		scanner.close();
	}
}
