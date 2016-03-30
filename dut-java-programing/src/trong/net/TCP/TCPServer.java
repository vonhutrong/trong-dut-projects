package trong.net.TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import trong.net.IServer;
import trong.net.IStringProcessing;

public class TCPServer implements IServer{
	private IStringProcessing mStringProcessing;
	private ServerSocket mServerSocket = null;
	
	public TCPServer(int port, IStringProcessing stringProcessing) throws IOException {
		mServerSocket = new ServerSocket(port);
		mStringProcessing = stringProcessing;
	}
	
	public void start() throws IOException {
		while (true) {
			Socket clientSocket = mServerSocket.accept();
			SocketHelper socket = new SocketHelper(clientSocket);
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						try {
							if (socket.isInputShutdown()) {
								socket.close();
								break;
							}
							String recieveStr = socket.receiveString();
							String resultStr = process(recieveStr);
							socket.sendString(resultStr);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}
	
	private String process(String string) {
		return mStringProcessing.process(string);
	}

	@Override
	public void stop() throws IOException {
		if (mServerSocket != null)
			mServerSocket.close();
	}
	
}
