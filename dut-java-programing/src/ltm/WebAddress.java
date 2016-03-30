package ltm;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WebAddress {

	public static InetAddress getInetAdress(String webName) {
		InetAddress ia;
		try {
			ia = InetAddress.getByName(webName);
		} catch (UnknownHostException uhe) {
			ia = null;
		}
		return ia;
	}
	
	public static String getHostAddress(String webName) {
		InetAddress ia = getInetAdress(webName);
		return ia == null ? null : ia.getHostAddress();
	}
	
	public static List<String> stringToListString(String str) {
		String[] arrayStrings = str.split(";");
		List<String> listStrings = Arrays.asList(arrayStrings);
		return listStrings.size() == 0 ? null : listStrings;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input: ");
		StringBuffer str = new StringBuffer();
		while (true) {
			String s = sc.nextLine();
			if (s.isEmpty())
				break;
			str.append(";" + s.replace("domain: ", ""));
		}
		
		List<String> listStrings = stringToListString(str.toString());
		
		System.out.println("output: ");
		for (String s : listStrings) {
			System.out.println("127.0.0.1 " + getHostAddress(s));
		}
		
		sc.close();
	}
}
