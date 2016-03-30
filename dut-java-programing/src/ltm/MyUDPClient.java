package ltm;

import java.util.Scanner;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;

public class MyUDPClient {

	public static void main(String [] args) {
		
		Scanner input = new Scanner(System.in);
		try {
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress IPAdress = InetAddress.getByName("localhost");
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];
			
			String sentence = input.nextLine();
			sendData = sentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
					IPAdress, 8876);
			
			clientSocket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveData, sentence.length());
			
			clientSocket.receive(receivePacket);
			String modifiedsentence = new String(receivePacket.getData()).trim();
			System.out.println("From server: " + modifiedsentence);
			clientSocket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		input.close();
	}
}
