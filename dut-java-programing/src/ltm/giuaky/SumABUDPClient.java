package ltm.giuaky;

import java.util.*;
import java.net.*;
import java.io.*;

public class SumABUDPClient {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		try {
			DatagramSocket socket = new DatagramSocket();
			InetAddress address = InetAddress.getByName("localhost");
			byte [] receiveData = new byte[1024];
			byte [] sendData;
			
			String s = keyboard.nextLine();
			sendData = s.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
					address, 8876);
			socket.send(sendPacket);
			
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			socket.receive(receivePacket);
			String receiveString = new String(receivePacket.getData()).trim();
			
			System.out.println(receiveString);
			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		keyboard.close();
	}

}
