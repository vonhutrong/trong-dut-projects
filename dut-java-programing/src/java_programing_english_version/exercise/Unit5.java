package java_programing_english_version.exercise;

import java.util.Scanner;

/*print number of days on month m in year y*/

public class Unit5 {
	private static final int days[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String monthNames[] = { "", "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };

	private static boolean isLeapYear(int year) {
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			return true;
		return false;
	}

	public static int daysOfMonth(int month, int year) {
		if (month == 2) {
			if (isLeapYear(year))
				return 29;
			return 28;
		}
		return days[month];
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please type time below:");
		System.out.print("Month: ");
		int month = keyboard.nextInt();
		System.out.print("Year: ");
		int year = keyboard.nextInt();
		System.out.println(
				"Days of " + Unit5.monthNames[month] + " in " + year + " is " + Unit5.daysOfMonth(month, year));

		keyboard.close();
	}
}
