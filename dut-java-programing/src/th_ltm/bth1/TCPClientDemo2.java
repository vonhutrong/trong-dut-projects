package th_ltm.bth1;

import java.io.IOException;

import trong.console.KeyboardHelper;
import trong.net.TCP.TCPClient;

public class TCPClientDemo2 {

	public static void main(String[] args) {
		String inputString = null;
		try {
			TCPClient client = new TCPClient("localhost", 5001);
			System.out.println("client started");

			while (true) {
				System.out.print("type expression: ");
				inputString = KeyboardHelper.nextLine();
				if (inputString.length() <= 0)
					break;
				
				//do something
				String resultString = client.request(inputString);
				System.out.println(resultString);
			}
			
			System.out.println("client stoped");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
