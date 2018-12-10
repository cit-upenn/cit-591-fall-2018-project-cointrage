import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JFrame {
	
	JLabel label;
	JTextField textField;
	JButton button;
	
	public static void main(String args[]) {

        
 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        JPanel panel = new JPanel(); 
        JLabel label = new JLabel("Enter Coin");
        JTextField tf = new JTextField(10);
        JButton send = new JButton("Find Arbitrage");
        JButton reset = new JButton("Reset");
        panel.add(label);
        panel.add(label); 
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        
        JTextArea ta = new JTextArea();

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }
}
