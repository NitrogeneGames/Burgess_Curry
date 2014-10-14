package burgess.main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Start {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	private static Socket clientSocket;
	private static DataOutputStream clientOut;
	private static BufferedReader clientIn;
	private Text text;
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
			Start window = new Start();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(104, 92, 173, 30);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("Clicked");
			}
		});
		btnNewButton.setBounds(160, 153, 75, 25);
		btnNewButton.setText("New Button");

	}
}
