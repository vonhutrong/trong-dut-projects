package th_ltm.bth2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import trong.console.KeyboardHelper;
import trong.net.UDP.UDPClient;

public class UDPClientDemo2 {
	public static void main(String[] args) {
		try {
			UDPClient client = new UDPClient(InetAddress.getByName("localhost"), 6001, 2048);
			System.out.println("client started");
			while (true) {
				System.out.print("type expression: ");
				String inputString = KeyboardHelper.nextLine();
				if (inputString.length() <= 0)
					break;
				
				String resultString;
				try {
					resultString = client.request(inputString);
					System.out.println(resultString);
				} catch (IOException e) {
					System.out.println("request fail");
				}
			}
			System.out.println("Client stoped");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
