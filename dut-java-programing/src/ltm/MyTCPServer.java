package ltm;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Thread;

public class MyTCPServer {
	
	static class ThreadedHandler extends Thread {
		Socket mSocket;
		int mCounter;
		
		public ThreadedHandler(Socket socket, int counter) {
			mSocket = socket;
			mCounter = counter;
		}
		
		@Override
		public void run() {
			try {
				// nhận thông tin từ DataInputStream
				DataInputStream dis = new DataInputStream(mSocket.getInputStream());
				String name = dis.readUTF();
				
				// xử lý thông tin
				String result = mCounter + "hello " + name;
											
				// gửi về client thông qua DataOutputStream
				DataOutputStream dos = new DataOutputStream(mSocket.getOutputStream());
				dos.writeUTF(result);
				
				// đóng kết nối
				mSocket.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		try {
			// tạo server socket để lắng nghe
			serverSocket = new ServerSocket(5000);
			System.out.println("server started");
			
			// vòng lặp mãi mãi chờ yêu cầu từ client
			int counter = 0;
			while (true) {
				
				// khi có yêu cầu thì chấp nhận kết nối
				Socket socket = serverSocket.accept();
				
				new ThreadedHandler(socket, counter).start();
				
				 counter ++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
