package trong.net.UDP;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class DatagramPacketHelper {
	
	//create packet with length
	public static DatagramPacket getDatagramPacket(int len) {
		byte[] buf = new byte[len];
		DatagramPacket packet = new DatagramPacket(buf, len);
		return packet;
	}
	
	//create packet from string to send to client
	public static DatagramPacket getDatagramPacket(String s, InetAddress addr, int port) {
		if (s == null)
			s = "";
		byte[] buf = s.getBytes();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, addr, port);
		return packet;
	}
	
	//get string from data gram packet
	public static String getString(DatagramPacket packet) {
		if (packet == null)
			return null;
		String s = new String(packet.getData()).trim();
		return s;
	}
}
