package ltm.giuaky;

import java.net.*;
import java.io.*;

public class SumABTCPServer {

	public static void main(String [] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(5000);
			while (true) {
				Socket  socket = serverSocket.accept();
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							DataInputStream dis = new DataInputStream(socket.getInputStream());
							String inputString = dis.readUTF();
							
							String [] ab = inputString.split(";");
							String s;
							try {
								float a = Float.parseFloat(ab[0]);
								float b = Float.parseFloat(ab[1]);
								s = a + b + "";
							} catch (Exception ex) {
								s = "error";
							}
							
							DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
							dos.writeUTF(s);
							
							socket.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
