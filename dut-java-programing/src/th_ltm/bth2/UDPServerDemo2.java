package th_ltm.bth2;

import java.io.IOException;
import java.net.SocketException;

import th_ltm.lib.ExpressionProcessing;
import trong.net.UDP.UDPServer;

public class UDPServerDemo2 {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				UDPServer server;
				try {
					server = new UDPServer(6001, 2048, new ExpressionProcessing());
					server.start();
				} catch (SocketException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		System.out.println("server started");
	}

}
