package ltm.giuaky;

import java.util.*;
import java.net.*;
import java.io.*;

public class SumABUDPServer {

	public static void main(String [] args) {
		try {
			DatagramSocket socket = new DatagramSocket(8876);
			byte [] receiveData = new byte[1024];
			byte [] sendData;
			
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);
				
				String receiveString = new String(receivePacket.getData()).trim();
				String result;
				try {
					String [] ab = receiveString.split(";");
					float a = Float.parseFloat(ab[0]);
					float b = Float.parseFloat(ab[1]);
					result = a + b + "";
				} catch (Exception ex) {
					result = "Error";
				}
				
				sendData = result.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
						receivePacket.getAddress(), receivePacket.getPort());
				socket.send(sendPacket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
