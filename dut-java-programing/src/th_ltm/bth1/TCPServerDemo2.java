package th_ltm.bth1;

import java.io.IOException;

import th_ltm.lib.ExpressionProcessing;
import trong.net.TCP.TCPServer;

public class TCPServerDemo2 {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TCPServer server = new TCPServer(5001, new ExpressionProcessing());
					server.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		System.out.println("server started");
	}

}
