package ltm;

import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class MyTCPClient implements Runnable {
	private String mName;
	
	public MyTCPClient(String name) {
		mName = name;
	}
	
	@Override
	public void run() {
		try {
			// tạo socket để kết nối địa chỉ (address) của server đúng với cổng (port)
			String address = "localhost"; // vì server đang chạy trên máy tui luôn nên nó như vậy
			int port = 5000; // chính là port mà bên server tạo kết nối
			Socket socket = new Socket(address, port);
			
			// gửi yêu cầu đến server thông qua DataOutputStream
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String name = mName; // dữ liệu ở đây là tên tui
			dos.writeUTF(name);
			
			// chờ nhận kết quả trả về từ server ở trong DataInputStream
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String result = dis.readUTF();
						
			// in kết quả ra màng hình
			System.out.println(result);
			
			// đóng kết nối
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String [] names = {"trong", "hong", "trinh"};
		
		for (int i = 0; i < 3; ++i) {
			new Thread(new MyTCPClient(names[i])).start();
		}
		
	}
}
