package ltm.giuaky;

import java.util.*;
import java.net.*;
import java.io.*;

public class SumABTCPClient {

	public static void main(String [] args) {
		Scanner keyboard = new Scanner(System.in);
		
		try {
			Socket socket = new Socket("localhost", 5000);
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			System.out.print("a, b=");
			Float a = keyboard.nextFloat();
			Float b = keyboard.nextFloat();
			String str = a + ";" + b;
			dos.writeUTF(str);
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String result = dis.readUTF().trim();
			System.out.println(result);
			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		keyboard.close();
	}
	
}
