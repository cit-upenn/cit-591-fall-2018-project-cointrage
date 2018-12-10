import javax.swing.SwingUtilities;

/** Class that runs the arbitrage finder GUI, titled "Cointrage" 
 * 
 * @author clintormsby
 *
 */

public class CointrageGui {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			new CointrageMainFrame();	
			}
		});
				
		
	}
	
}
