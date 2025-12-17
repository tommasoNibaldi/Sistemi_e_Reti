package A_02; 

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
	public static void main(String[] args) throws Exception {
		try {

			String severAddress="127.0.0.1";  
			int severPort=8698;
			String clientMessage = "";
			String serverMessage = "";
			
			
			System.out.print("Client: Tentativo di connessione server=" + severAddress + ":" + severPort + " ... ");
			Socket socket = new Socket(severAddress, severPort); 
			System.out.println("Connected");

			
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			
			Scanner scanner = new Scanner(System.in);			
			
			while (!clientMessage.equals("end")) {

				
				System.out.print("Client: inserisci il messaggio da inviare> ");
				clientMessage = scanner.nextLine();

				
				System.out.println("Client: invio il messaggio: " + clientMessage);
				outStream.writeUTF(clientMessage);
				outStream.flush();

				
				serverMessage = inStream.readUTF();
				System.out.println("Client: ricevuto il messaggio: " + serverMessage);
			}

			
			inStream.close();
			outStream.close();
			socket.close();
			scanner.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
