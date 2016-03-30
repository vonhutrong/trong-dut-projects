package trong.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import trong.net.IServer;
import trong.net.IStringProcessing;

public class UDPServer implements IServer {

	protected DatagramSocket mServerSocket = null;
	protected IStringProcessing mStringProcessing = null;
	protected int mPort;
	protected int mBuffLength = 0;
	
	public UDPServer(int port, int buffLength, IStringProcessing stringProcessing) throws SocketException {
		mPort = port;
		mServerSocket = new DatagramSocket(port);
		mStringProcessing = stringProcessing;
		mBuffLength = buffLength;
	}
	
	@Override
	public void start() throws IOException {
		while (true) {
			//receive data and get address, port of client
			DatagramPacket receivePacket = DatagramPacketHelper.getDatagramPacket(mBuffLength);
			mServerSocket.receive(receivePacket);
			String receiveStr = DatagramPacketHelper.getString(receivePacket);
			InetAddress addr = receivePacket.getAddress();
			int port = receivePacket.getPort();
			
			//process string
			String resultStr = mStringProcessing.process(receiveStr);
			
			//send result to client
			DatagramPacket sendPacket = DatagramPacketHelper.getDatagramPacket(resultStr, addr, port);
			mServerSocket.send(sendPacket);
		}
	}
	
	@Override
	public void stop() {
		if (mServerSocket != null)
			mServerSocket.close();
	}

}
