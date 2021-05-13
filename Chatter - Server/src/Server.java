import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	private final ServerSocket SERVER_SOCKET;
	private final int PORT;
	
	public Server(int port) throws IOException {
		this.PORT = port;
		this.SERVER_SOCKET = new ServerSocket(port);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Listening on port " + PORT + " ...");
				
				Socket socket = SERVER_SOCKET.accept();
				System.out.println("Connected to " + socket.getRemoteSocketAddress());
				
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				System.out.println("Client: " + dataInputStream.readUTF());
				System.out.println();
				
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				dataOutputStream.writeUTF("Hello from " + socket.getLocalSocketAddress());
				
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
