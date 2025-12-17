package A_02; 

import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedTcpServer {

	static final int MAX_CONN = 999;
	static final int SRV_PORT = 8698;

	public static void main(String[] args) throws Exception {
	   
		int count = 0;                  
			
		
		ServerSocket server = new ServerSocket(SRV_PORT);
	
		while(count<MAX_CONN) {
			count++;
			
			System.out.println("Server: in ascolto sulla porta " + SRV_PORT );
			Socket serverClientSocket = server.accept();  

			System.out.println("Serving Client " + count);
			
			TcpServer sa = new TcpServer(serverClientSocket, count);
			sa.start();
			sa.setName("Questo-e-il-mio-ServerThread-Numero-" +count);  
		}
		
		server.close();
	}
}