package java_programing_english_version.exercise;

import java.util.Scanner;

/*karaoke bill
<18h 45k/1h
>18h 60k/1h*/

public class Unit4 {
	public static long cash(int startTime, int endTime) {
		long cash;
		if (endTime <= 18) {
			cash = (endTime - startTime) * 45;
		} else if (startTime >= 18) {
			cash = (endTime - startTime) * 60;
		} else {
			cash = (18 - startTime) * 45 + (endTime - 18) * 60;
		}
		return cash * 1000;
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Input values:");
		System.out.print("start time: ");
		int startTime = keyboard.nextInt();
		System.out.print("end time: ");
		int endTime = keyboard.nextInt();
		System.out.println("cash:" + Unit4.cash(startTime, endTime));
		
		keyboard.close();
	}
}
