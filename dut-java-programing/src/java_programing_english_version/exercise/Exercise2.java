package java_programing_english_version.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Coding a program do something below:
 * 1. Inputing a matrix (m rows, n columns) about int elements
 * 2. Calculating sum of multiples of three elements on first row
 * 3. Create array X[i] include the greatest value on row
 * 4. Inputing K and search it on array X[i]
 * 		and show the first index if exist
 * 5. Sorting array X[i] by descending
 */

/**
 * @author trong
 * Jan 16, 2016
 */
public class Exercise2 {
	private int[][] matrix;
	private int[] greatestValuesArray;
	private int rows;
	private int columns;
	
	public Exercise2() { }
	
	public void setSize(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		initialization();
	}
	
	private void initialization() {
		matrix = new int[rows][columns];
		greatestValuesArray = new int[rows];
	}

	public void inputMatrix(Scanner keyboard) {
		for (int i = 0; i < rows; ++i)
			for (int j = 0; j < columns; ++j) {
				System.out.print("element[" + i + "][" + j + "] = ");
				matrix[i][j] = keyboard.nextInt();
			}
		keyboard.nextLine();
	}
	
	public long sumOfMultiplesOfThreeOnFirstRow() {
		long sum = 0;
		for (int j = 0; j < columns; ++j)
			if (matrix[0][j] % 3 == 0)
				sum +=matrix[0][j]; 
		return sum;
	}
	
	public int[] createGreatestValuesOnRowArray() {
		for (int i = 0; i < rows; ++i)
			for (int j = 0; j < columns; ++j)
				if (matrix[i][j] > greatestValuesArray[i])
					greatestValuesArray[i] = matrix[i][j];
		return greatestValuesArray;
	}
	
	public int indexOfFirstRowThatKContainedIn(int value) {
		for (int i = 0; i < rows; ++i)
			if (greatestValuesArray[i] == value)
				return i;
		return -1;
	}
	
	public int[] sortGreatestValuesOnRowArray() {
		List<Integer> list = new ArrayList<>();
		Arrays.sort(greatestValuesArray);
		for (int i = 0; i < rows; ++i)
			list.add(new Integer(greatestValuesArray[i]));
		Collections.sort(list, Collections.reverseOrder());
		for (int i = 0; i < rows; ++i)
			greatestValuesArray[i] = list.get(i).intValue();
		return greatestValuesArray;
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < columns; ++j)
				buff.append(matrix[i][j] + ";\t");
			buff.append('\n');
		}
		return buff.toString();
	}
	
	public static String toString(int[] intArray) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < intArray.length; ++i)
			sb.append(intArray[i] + ", ");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int jobIndex = -1;
		Exercise2 matrix = new Exercise2();
		while (jobIndex != 0) {
			System.out.print(
					"===========================================================================" + "\n" +
					"1. Inputing a matrix (m rows, n columns) about int elements" + "\n" +
					"2. Calculating sum of multiples of three elements on first row" + "\n" +
					"3. Create array X[i] include the greatest value on row" + "\n" +
					"4. Inputing K and search it on array X[i] and show the first index if exist" + "\n" +
					"5. Sorting array X[i] by descending" + "\n" +
					"0. Exit" + "\n" +
					"Chose index: ");
			jobIndex = keyboard.nextInt();
			switch (jobIndex) {
			case 1:
				System.out.print("Please enter rows and columns of matrix: ");
				matrix.setSize(keyboard.nextInt(), keyboard.nextInt());
				keyboard.nextLine();
				matrix.inputMatrix(keyboard);
				System.out.println("Matrix: \n" + matrix.toString());
				break;
			case 2:
				System.out.println("Sum of multiples of three elemets on first row = " + matrix.sumOfMultiplesOfThreeOnFirstRow());
				break;
			case 3:
				System.out.println("Array X: " + Exercise2.toString(matrix.createGreatestValuesOnRowArray()));
				break;
			case 4:
				System.out.print("Please enter number K: ");
				int index = matrix.indexOfFirstRowThatKContainedIn(keyboard.nextInt());
				if (index != -1)
					System.out.println("Index = " + index);
				else
					System.out.println("Not found K in array X");
				break;
			case 5:
				System.out.println("After sorted: " + Exercise2.toString(matrix.sortGreatestValuesOnRowArray()));
				break;
			case 0:
				jobIndex = 0;
				break;
			default:
				System.out.println("Please enter a index in list");
				break;
			}
		}
		
		keyboard.close();
	}
}
