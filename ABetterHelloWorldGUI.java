import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Demo of class that extends JFrame and include Listener as an anonymous inner class
 * @author kathl
 *
 */

public class ABetterHelloWorldGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	//make the window's components instance variables
	JLabel label;
	JTextField textField;
	JButton button;
	
	ABetterHelloWorldGUI() {
		createButtonAndListener();
		createComponents();
	}
	
	/**
	 * Create the components used in the frame
	 */
	private void createComponents() {
		 label = new JLabel("Hello World");
		 textField = new JTextField(10);
		 JPanel panel = new JPanel();
		 panel.add(textField);
		 panel.add(label);
		 panel.add(button);
		 add(panel);
		 add(panel);
		 setVisible(true);
		 setSize(400,500);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		 
	 }
	/**
	 * create the anonymous inner class button listener
	 */
	private void createButtonAndListener() {
		
		button = new JButton("Click Me");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//we have access to all of the Frames components now
				label.setText("Clicked!");
				label.setText(textField.getText());
				
			}
		});
	}
	
	/**
	 * Use SwingUtilities to start up the application on its own thread
	 * @param args
	 */
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
		      public void run() {
		    	  ABetterHelloWorldGUI frame = new ABetterHelloWorldGUI();
		    	 
		      }
		    });
	}

}
