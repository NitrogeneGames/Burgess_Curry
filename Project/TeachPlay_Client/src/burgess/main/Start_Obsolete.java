package burgess.main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Start_Obsolete {
	private static Socket clientSocket;
	private static DataOutputStream clientOut;
	private static BufferedReader clientIn;
	private static void init() throws UnknownHostException, IOException{
		clientSocket = new Socket("localhost", 9912);
		clientOut = new DataOutputStream(clientSocket.getOutputStream());
		clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	public static void main(String [ ] args) {
		try {
			init();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		try {
			clientOut.writeChars("Send");
			String s = clientIn.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
