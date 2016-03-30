package trong.net.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SocketHelper extends Socket{
	private Socket mSocket = null;
	private DataOutputStream mOutputStream = null;
	private DataInputStream mInputStream = null;
	
	public SocketHelper(Socket socket) throws IOException {
		mSocket = socket;
		initStreams();
	}
	
	public SocketHelper(String host, int port) throws IOException {
		try {
			mSocket = new Socket(host, port);
			initStreams();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	private void initStreams() throws IOException {
		mOutputStream = new DataOutputStream(mSocket.getOutputStream());
		mInputStream = new DataInputStream(mSocket.getInputStream());
	}
	
	private void closeStreams() throws IOException {
		mOutputStream.close();
		mInputStream.close();
	}
	
	public void close() throws IOException {
		super.close();
		closeStreams();
		if (mSocket != null)
			mSocket.close();
	}
	
	public boolean sendString(String string) throws IOException {
		try {
			mOutputStream.writeUTF(string);
			return true;
		} catch (NullPointerException nulle) {
		}
		return false;
	}
	
	public String receiveString() throws IOException {
		try {
			return mInputStream.readUTF();
		} catch (SocketException se) {
		}
		return null;
	}
}
