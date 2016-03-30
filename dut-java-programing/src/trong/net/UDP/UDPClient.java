package trong.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import trong.net.IClient;

public class UDPClient implements IClient {
	
	private DatagramSocket mSocket = null;
	private InetAddress mHost;
	private int mPort;
	private int mBuffLength;
	
	public UDPClient(InetAddress host, int port, int buffLength) {
		mHost = host;
		mPort = port;
		mBuffLength = buffLength;
		initialize();
	}
	
	private void initialize() {
		try {
			mSocket = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String request(String s) throws IOException {
		DatagramPacket sendPacket = DatagramPacketHelper.getDatagramPacket(s, mHost, mPort);
		mSocket.send(sendPacket);
		
		DatagramPacket receivePacket = DatagramPacketHelper.getDatagramPacket(mBuffLength);
		mSocket.receive(receivePacket);

		return DatagramPacketHelper.getString(receivePacket);
	}

	@Override
	public void stop() {
		if (mSocket != null)
			mSocket.close();
	}

}
