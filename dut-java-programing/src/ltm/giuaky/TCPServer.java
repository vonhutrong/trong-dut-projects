package ltm.giuaky;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPServer {
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5000);
			ListSockets listSockets = new ListSockets();
			
			while (true) {
				Socket socket = serverSocket.accept();
				new Thread (new Runnable() {
					@Override
					public void run() {
						try {
							DataInputStream dis = new DataInputStream(socket.getInputStream());
							String inputString = dis.readUTF();
							
							boolean rightSyntax = true;
							try {
								String[] ab = inputString.split(";");
								String id = ab[0];
								String pass = ab[1];
								listSockets.addSocketDetails(new SocketDetails(socket, id, pass));
							} catch (Exception  eab) {
								eab.printStackTrace();
								rightSyntax = false;
							}
							
							String result;
							if (rightSyntax) {
								result = listSockets.getListIDConnecting().toString();
							} else {
								result = "Error Syntax";
							}
							
							DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
							dos.writeUTF(result);
							
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		} catch (IOException e) {
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

	public static class SocketDetails {
		private Socket mSocket;
		private String mID;
		private String mPass;
		public SocketDetails(Socket socket, String id, String pass) {
			mSocket = socket;
			mID = id;
			mPass = pass;
		}
		public String getID() {
			return mID;
		}
		public String getPass() {
			return mPass;
		}
		public boolean isClose() {
			if (mSocket != null)
				return mSocket.isClosed();
			return false;
		}
	}
	
	public static class ListSockets {
		private List<SocketDetails> mListSockets;
		public ListSockets() {
			mListSockets = new ArrayList<TCPServer.SocketDetails>();
		}
		public synchronized void addSocketDetails(SocketDetails socketDetails) {
			mListSockets.add(socketDetails);
		}
		public synchronized  List<String> getListIDConnecting() {
			List<String> listID = new ArrayList<String>();
			for (SocketDetails socketDetails : mListSockets) {
				if (!socketDetails.isClose()) {
					listID.add(socketDetails.getID());
				}
			}
			return listID.size() == 0 ? null : listID;
		}
	}

}
