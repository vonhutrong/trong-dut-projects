package java_programing_english_version.exercise;

/*Finding perfect numbers smaller than 1000*/

/**
 * @author trong
 * Jan 14, 2016
 */
public class Unit15 {
	public static boolean isPerfectNumber(long number) {
		long sumOfDivisors = 0;
		
		for (long i = 1; i < number; ++i)
			if (number % i == 0)
				sumOfDivisors += i;
		
		return sumOfDivisors == number;
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 1000; ++i)
			if (Unit15.isPerfectNumber(i))
				System.out.println(i);
	}
}
