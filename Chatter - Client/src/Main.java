import java.io.*;
import java.net.Socket;

public class Main {
	private static final String HOST = "localhost";
	private static final int PORT = 5000;
	
	public static void main(String[] args) {
		try {
			System.out.println("Connecting to " + HOST + ":" + PORT);
			Socket socket = new Socket(HOST, PORT);
			System.out.println("Connected to " + socket.getRemoteSocketAddress());
			
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataOutputStream.writeUTF("This is a message from client ...");
			
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			System.out.println("Server: " + dataInputStream.readUTF());
			System.out.println();
			
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
