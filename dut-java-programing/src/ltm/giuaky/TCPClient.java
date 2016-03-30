package ltm.giuaky;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(InetAddress.getByName("localhost"), 5000);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		Scanner kb = new Scanner(System.in);
		String inputString = null;
		String id;
		String pass;

		do {
			System.out.println("Enter ID and Password: ");
			id = kb.nextLine();
			pass = kb.nextLine();

			dos.writeUTF(id + ";" + pass);

			inputString = dis.readUTF();

			System.out.println(inputString);
		} while (!"Don't do it again".equals(inputString));

		socket.close();
		kb.close();
	}

}
