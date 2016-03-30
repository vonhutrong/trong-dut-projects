package th_ltm.bth1;

import java.io.IOException;

import trong.console.KeyboardHelper;
import trong.net.TCP.TCPClient;

public class TCPClientDemo1 {

	public static void main(String[] args) {
		String inputString = null;
		try {
			TCPClient client = new TCPClient("localhost", 5000);
			System.out.println("client started");

			do {
				System.out.print("type string: ");
				inputString = KeyboardHelper.nextLine();
				
				//do something
				String resultString = client.request(inputString);
				System.out.println(resultString);
			} while (inputString != null && inputString.length() > 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
