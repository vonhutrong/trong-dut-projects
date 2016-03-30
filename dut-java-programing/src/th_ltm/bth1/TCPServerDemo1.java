package th_ltm.bth1;

import java.io.IOException;

import th_ltm.lib.SmartString;
import trong.net.IStringProcessing;
import trong.net.TCP.TCPServer;

public class TCPServerDemo1 extends TCPServer{

	public TCPServerDemo1(int port, IStringProcessing stringProcessing) throws IOException {
		super(port, stringProcessing);
	}

	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TCPServerDemo1 server = new TCPServerDemo1(5000, new SmartString());
					server.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		System.out.println("Server started");
	}
}
