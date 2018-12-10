import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONException;

/** Class that constructs the main frame for arbitrage finder GUI, with buttons and event handlers
 * 
 * @author clintormsby
 *
 */

public class CointrageMainFrame extends JFrame {

	private JButton button1 = new JButton("Bitcoin");
	private JButton button2 = new JButton("Litecoin");
	private JButton button3 = new JButton("BitcoinCash");
	private JButton button4 = new JButton("Dogecoin");
	private JButton button5 = new JButton("Ethereum");
	private JTextField textField = new JTextField(70);
	
	
	/** Constructs an instance of the class, creating the main JFrame with a text field and buttons for each coin
	 * 
	 */
	public CointrageMainFrame() {
		super("Cointrage");
		createComponents();
		createBitcoinButtonAndListener();
		createLitecoinButtonAndListener();
		createBitcoincashButtonAndListener();
		createDogecoinButtonAndListener();
		createEthereumButtonAndListener();
	}
	
	/** Creates a main frame of border layout which consists of a panel with a text field and another panel with a
	 *  flow layout for the row of buttons
	 * 
	 */
	public void createComponents() {
		
		setLayout(new BorderLayout());
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	
		JPanel centerPanel = new JPanel();
		
		centerPanel.add(textField);
		
		southPanel.add(button1);
		southPanel.add(button2);
		southPanel.add(button3);
		southPanel.add(button4);
		southPanel.add(button5);
		
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		
		setSize(950, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/** Creates a bitcoin button with an anonymous inner class for the action listener that when pressed calls the push
	 *  button method that returns a string stating whether there is an arbitrage opportunity or not. This string is then
	 *  displayed in the text field
	 * 
	 */
	public void createBitcoinButtonAndListener() {

		Button bitcoinButton = new Button("BTC_USD");
		
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(bitcoinButton.pushButton("BTC_USD"));
				} catch (IOException | JSONException e1) {
					e1.printStackTrace();
				}
			}	
		});
	}
	
	/** Creates a litecoin button with an anonymous inner class for the action listener that when pressed calls the push
	 *  button method that returns a string stating whether there is an arbitrage opportunity or not. This string is then
	 *  displayed in the text field
	 * 
	 */
	public void createLitecoinButtonAndListener() {
		
		Button litecoinButton = new Button("LTC_USD");
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(litecoinButton.pushButton("LTC_USD"));
				} catch (IOException | JSONException e1) {
					e1.printStackTrace();
				}
			}	
		});
		
		
	}
	/** Creates a bitcoincash button with an anonymous inner class for the action listener that when pressed calls the push
	 *  button method that returns a string stating whether there is an arbitrage opportunity or not. This string is then
	 *  displayed in the text field
	 * 
	 */
	public void createBitcoincashButtonAndListener() {
		
		Button bitcoincashButton = new Button("BCH_USD");
		
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(bitcoincashButton.pushButton("BCH_USD"));
				} catch (IOException | JSONException e1) {
					e1.printStackTrace();
				}
			}	
		});
		
		
	}

	
	/** Creates a dogecoin button with an anonymous inner class for the action listener that when pressed calls the push
	 *  button method that returns a string stating whether there is an arbitrage opportunity or not. This string is then
	 *  displayed in the text field
	 * 
	 */
	public void createDogecoinButtonAndListener() {
		
		Button dogecoinButton = new Button("DOGE_USD");
		
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(dogecoinButton.pushButton("DOGE_USD"));
				} catch (IOException | JSONException e1) {
					e1.printStackTrace();
				}
			}	
		});
		
	
	}
	/** Creates an ethereum button with an anonymous inner class for the action listener that when pressed calls the push
	 *  button method that returns a string stating whether there is an arbitrage opportunity or not. This string is then
	 *  displayed in the text field
	 * 
	 */
	public void createEthereumButtonAndListener() {
		
		Button ethereumButton = new Button("ETH_USD");
		
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(ethereumButton.pushButton("ETH_USD"));
				} catch (IOException | JSONException e1) {
					e1.printStackTrace();
				}
			}	
		});
		
	
	}

}

