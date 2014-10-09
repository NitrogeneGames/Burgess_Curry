package burgess.main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Start {
	private static ServerSocket welcomeSocket;
	private static DataOutputStream serverOut;
	private static BufferedReader serverIn;
	@SuppressWarnings("resource")
	public static void main(String [ ] args) {
		try {
			welcomeSocket = new ServerSocket(9912);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			Socket sSocket;
			try {
				sSocket = welcomeSocket.accept();
				serverOut = new DataOutputStream(sSocket.getOutputStream());
				serverIn = new BufferedReader(new InputStreamReader(sSocket.getInputStream()));
				String s = serverIn.readLine();
				serverOut.writeChars("You sent: " + s + " to the server.");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
