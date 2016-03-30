package trong.net.TCP;

import java.io.IOException;

import trong.net.IClient;

public class TCPClient implements IClient{
	private SocketHelper mSocket = null;
	
	public TCPClient(String host, int port) throws IOException {
		mSocket = new SocketHelper(host, port);
	}
	
	public String request(String string) throws IOException {
		return (mSocket.sendString(string)) ? mSocket.receiveString() : null; 
	}
	
	public void stop() throws IOException {
		mSocket.close();
	}
}
