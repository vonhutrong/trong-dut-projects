package java_programing_english_version.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Coding a program do something below:
 * 1. Inputting 1 array has N elements type Integer
 * 2. Calculating sum, multiple of all even positive number
 * 3. Deleting first odd number
 * 4. Sorting ascending
 * 5. Insert an element p so the array is ascending and display array
 * */

/**
 * @author trong
 * Jan 15, 2016
 */
public class Exercise1 {
	private List<Integer> array = new ArrayList<>();
	
	public void inputArray(Scanner keyboard) {
		System.out.println("WARNING! YOU WILL DELETE EXIST ARRAY AND INSERT NEW ELEMENTS");
		System.out.println("Press 0 to cancel, other number to continue");
		if (keyboard.nextInt() == 0) {
			keyboard.nextLine();
			return;
		}
		System.out.print("Please enter num of elements: ");
		int numOfElements = keyboard.nextInt();
		keyboard.nextLine();
		System.out.print("Please enter list of elements: ");
		while (numOfElements-- > 0) {
			array.add(new Integer(keyboard.nextInt()));
		}
		keyboard.nextLine();
		Collections.sort(array);
	}
	
	public long sumOfEvenPositiveNumbers() {
		long sum = 0;
		for (Integer i : array)
			if (i.intValue() > 0 && i.intValue() % 2 == 0)
				sum += i.intValue();
		return sum;
	}
	
	public double multipleOfAllEvenPositiveNumbers() {
		double multiple = 1;
		for (Integer i : array)
			if (i.intValue() > 0 && i.intValue() % 2 == 0)
				multiple *= i.intValue();
		return multiple % 2 == 0 ? multiple : 0;
	}
	
	public void deleteFirstOddNumber() {
		for (Integer i : array)
			if (i.intValue() % 2 != 0) {
				array.remove(array.indexOf(i));
				return;
			}
//			
//			for (int i = 0; i < array.size(); ++i)
//				if (array.get(i) % 2 != 0) {
//					array.remove(i);
//					return;
//				}
	}
	
	public void insert(Integer newIntegerElement) {
		array.add(newIntegerElement);
		Collections.sort(array);
	}
	
	public void insert(int newElement) {
		this.insert(new Integer(newElement));
	}
	
	@Override
	public String toString() {
			StringBuffer buff = new StringBuffer();
			for (Integer i : array)
				buff.append(i.intValue() + "; ");
			return buff.toString();
		}
	
	public static void main(String[] args) {
		Exercise1 array = new Exercise1();
		Scanner keyboard = new Scanner(System.in);
		int jobIndex = -1;
		while (jobIndex != 0) {
			System.out.print(
					"==================================================================\n" +
					"1. Inputting 1 array has N elements type Integer\n" +
					"2. Calculating sum, multiple of all even positive number\n" +
					"3. Deleting first odd number\n" +
					"4. Insert an element p so the array is ascending and display array\n" +
					"0. Exit\n" +
					"Chose a job:");
			jobIndex = keyboard.nextInt();
			keyboard.nextLine();
			switch (jobIndex) {
			case 1:
				array.inputArray(keyboard);
				System.out.println("Array:\n" + array.toString());
				break;
			case 2:
				System.out.println("Sum of even positive numbers: " + array.sumOfEvenPositiveNumbers() + "\n" +
						"Multiple of even positive numbers: " + array.multipleOfAllEvenPositiveNumbers());
				break;
			case 3:
				System.out.println("Before:\n" + array.toString());
				array.deleteFirstOddNumber();
				System.out.println("After delete:\n" + array.toString());
				break;
			case 4:
				System.out.print("Please enter new Element: ");
				array.insert(keyboard.nextInt());
				System.out.println("After insert:\n" + array.toString());
				break;
			case 0:
				jobIndex = 0;
				break;
			default:
				System.out.println("Please chose a number on list!");
			}
		}
		keyboard.close();
	}
}
