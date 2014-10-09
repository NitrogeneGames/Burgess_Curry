package burgess.main;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class BasicFrame extends JFrame{
	private JPanel myPanel;
	
	public BasicFrame(){

		myPanel = new JPanel();
		myPanel.setBounds(0, 0, 300, 300);
		//myPanel.setLayout(null);
		this.add(myPanel);
	}
	public void addComponentToPanel(JComponent c) {
		myPanel.add(c);
	}
	public JPanel getPanel() {
		return myPanel;
	}
	public void addBasicLabel(String text, int x, int y) {
		JLabel outputLabel;
		outputLabel = new JLabel();
		outputLabel.setText(text);
		myPanel.add(outputLabel);
		outputLabel.setLocation(x, y);
	}
	public void addBasicLabel(String text, int x, int y, Font f) {
		JLabel outputLabel;
		outputLabel = new JLabel();
		outputLabel.setFont(f);
		outputLabel.setText(text);
		outputLabel.setLocation(x, y);
		myPanel.add(outputLabel);
	}

}