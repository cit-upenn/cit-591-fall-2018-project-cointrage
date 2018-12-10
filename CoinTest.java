import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/** Class that does JUnit testing for the Coin class 
 * 
 * 
 * @author AustinKRahmin
 *
 */
class CoinTest {
	
	Coin crytocurrency;

	/** Method that sets up the CoinTest class for JUnit testing. Creates a cryptocurrency on the exchange Binance with a bid price of 
	 * 3560 and a ask price of 3700.12
	 * 
	 * 
	 */
	@BeforeEach
	public void setUp() {
		crytocurrency = new Coin("Binance", "Bitcoin", 3560.00, 3700.12);
	}
	
	/** Test Purpose: Tests the basic functionality in order to retrieve the exchange. This method is significant because traders need to know 
	 * where to buy and sell the currency if an arbitrage opportunity exists.  
	 * 
	 * 
	 */
	
	@Test
	void testGetExchange() {
		assertEquals("Binance", crytocurrency.getExchange());
	}

	
	/** Test Purpose: Tests the basic functionality in order to retrieve the get the asset name. 
	 * This method is important to traders because they need to know 
	 * which currency to buy and sell the currency if an arbitrage opportunity exists.  
	 * 
	 * 
	 */
	
	@Test
	void testGetAsset() {
		String test = crytocurrency.getAsset();
		assertEquals("Bitcoin", test);
	}
	
	/** Test Purpose: Tests the basic functionality in order to retrieve the bid price. 
	 * This method is important to traders because they need to know how much to sell the currency for. The bid price on an exchange
	 * is the price that traders will eventually sell the currency for. Therefore, this method is significant to traders because it allows them to 
	 * calculate profit  
	 * 
	 * 
	 */
	
	@Test
	void testGetBidPrice() {
		double test = crytocurrency.getBidPrice();
		assertEquals(3560.00,test);
	}
	
	/** Test Purpose: Tests the basic functionality in order to retrieve the ask price. 
	 * This method is important to traders because they need to know how much to sell the currency for. The bid price on an exchange
	 * is the price that traders will buy the currency for from an exchange. 
	 * Therefore, this method is significant to traders because it allows them to 
	 * calculate profit  
	 * 
	 * 
	 */
	@Test
	void testGetAskPrice() {
		double test = crytocurrency.getAskPrice();
		assertEquals(3700.12,test);
	}
	
	/** Test Purpose: Tests the basic functionality to set a currency's name.  
	 * This method is important in accessing the API. Program must be able to read the API and construct the coin object in order to 
	 * eventually conduct financial analysis on it. 
	 * 
	 * 
	 */
	@Test
	void testSetAsset() {
		crytocurrency.setAsset("Ether");
		assertEquals("Ether",crytocurrency.getAsset());
	}
	
	/** Test Purpose: Tests the basic functionality to set an exchange name.  
	 * This method is important in accessing the API. Program must be able to read the API and construct the coin object in order to 
	 * eventually conduct financial analysis on it. 
	 * 
	 * 
	 */
	@Test
	void testSetExchange() {
		crytocurrency.setExchange("CoinBase");
		assertEquals("CoinBase",crytocurrency.getExchange());
	}
	
	/** Test Purpose: Tests the basic functionality to set an ask price.  
	 * This method is important in accessing the API. Program must be able to read the API and construct the coin object in order to 
	 * eventually conduct financial analysis on it. Uses setter in order to do this.
	 * 
	 * 
	 */ 
	@Test
	void testSetAskPrice() {
		crytocurrency.setAsk(1245.2);
		assertEquals(1245.2,crytocurrency.getAskPrice());
	}
	
	/** Test Purpose: Tests the basic functionality to set a bid price.  
	 * This method is important in accessing the API. Program must be able to read the API and construct the coin object in order to 
	 * eventually conduct financial analysis on it. Uses setter in order to read API.
	 * 
	 */ 
	@Test
	void testSetBidPrice() {
		crytocurrency.setBid(1800.3);
		assertEquals(1800.3,crytocurrency.getBidPrice());
	}
	
	
	
	

}
