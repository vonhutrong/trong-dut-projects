package trong.console;

import java.util.Scanner;

public class KeyboardHelper {
	private static Scanner sc = new Scanner(System.in);
	
	private KeyboardHelper() {}
	
	public static String nextLine() {
		return sc.nextLine();
	}
	
	public static void close() {
		sc.close();
	}
}
