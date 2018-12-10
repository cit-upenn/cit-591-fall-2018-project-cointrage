import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.Test;
/** Class that performs JUnit testing for our ArbFinder class. 
 * 
 * 
 * 
 * @author AustinKRahmin
 *
 */
class ArbFinderTest {

	ArbFinder arbMarket;
	
	/** Method that sets up the arbMarket JUnit testing. This method creates an ArrayList with 5 coins on 2 exchanges. Thus, 
	 * the size of the arrayList is 10. This arrayList was constructed manually so we could know the expected values and test our methods 
	 * were actually calculating minimum, maximum, and profit correctly. 
	 * 
	 * 
	 * @throws IOException signals that an input / output exception can occur
	 * @throws JSONException signals that a JSON exception can occur
	 */
	@BeforeEach
	public void setUp() throws IOException, JSONException{
		Coin bitcoin = new Coin("Binance", "Bitcoin", 3560.00, 3700.12);
		Coin ripple = new Coin("Binance", "Ripple", 83.17, 85.46);
		Coin ether = new Coin("Binance", "Ether", 0, 104.73);
		Coin lithium = new Coin("Binance", "Lithium", 4014.24, 4321.90);
		Coin bitcoinCash = new Coin("Binance", "BitCoinCash", 4250.13, 4176.57);
		Coin bitcoinEx = new Coin("CoinEx", "Bitcoin", 3752.00, 3600.67);
		Coin rippleEx = new Coin("CoinEx", "Ripple", 93.17, 95.46);
		Coin etherEx = new Coin("CoinEx", "Ether", 104.21, 107.73);
		Coin bitcoinCashEx = new Coin("CoinEx", "BitCoinCash", 4096.13, 3943.57);
		Coin lithiumEx = new Coin("CoinEx", "Lithium", 4096.13, 0);
		ArrayList<Coin> market = new ArrayList<Coin>();
		market.add(bitcoin);
		market.add(ripple);
		market.add(ether);
		market.add(bitcoinCash);
		market.add(bitcoinEx);
		market.add(rippleEx);
		market.add(etherEx);
		market.add(bitcoinCashEx);
		arbMarket = new ArbFinder(market);
		
		
	}
	
	/** Method that tests the ability to find the highest bid price from an arrayList of coin objects. Traders want the highest 
	 * bid price for a currency because a bid price is the price that an exchange is willing to buy the currency for. Traders want to 
	 * sell at the highest price 
	 * 
	 * 
	 */
	@Test
	void testFindMaxBidPrice() {
		Coin maxBidPrice = arbMarket.findMaxBidPrice("Bitcoin");
		assertEquals(maxBidPrice.getBidPrice(),3752.00);
	}
	
	/** Method that tests the ability to find the highest ask price from an arrayList of coin objects. Traders want to know the range that a coin is selling 
	 * to conduct financial analysis. Therefore, while traders won't buy from an exchange at the highest ask price, it is important for traders to know to find
	 * the range a coin is trading at. 
	 * 
	 * 
	 */ 
	@Test
	void testFindMaxAskPrice() {
		Coin maxAskPrice = arbMarket.findMaxAskPrice("Bitcoin");
		assertEquals(3700.12,maxAskPrice.getAskPrice());
	}
	/** Method that tests the program's ability to find the lowest ask price. The ask price is the price at which an exchange will sell the currency. 
	 * This is the price that a trader buys the currency for. Therefore, the trader wants to find the lowest ask price to maximize the spread
	 * 
	 *  
	 */
	@Test
	void testFindMinAskPrice() {
		Coin minAskPrice = arbMarket.findMinAskPrice(10000,"Bitcoin");
		assertEquals(3600.67,minAskPrice.getAskPrice());
	}
	
	/** Tests the ability to find profit between two coins.
	 * 
	 *  
	 *  
	 */
	
	@Test
	void testProfitCalculator() {
		Coin bid = arbMarket.findMaxBidPrice("Bitcoin");
		Coin ask = arbMarket.findMinAskPrice(10000, "Bitcoin");
		String test = arbMarket.profitCalculator(bid, ask);
		
		assertEquals(Double.toString(151.32999999999993),test);

	}
	
	
	/** Test Purpose: test ability of profit calculator to give an answer conditionally if the exchange doesn't have a price listed.
	 * When an exchange is missing ask price, information the API lists the price as "0." So, need to check to make sure that the ask price isn't zero. 
	 * This test checks to see whether the condition for ask price is zero works. 
	 * 
	 * 
	 */
	@Test
	void testProfitCheckerAskPrice() {
		Coin bid = arbMarket.findMaxBidPrice("Lithium");
		Coin ask = arbMarket.findMinAskPrice(10000, "Lithium");
		String test = arbMarket.profitCalculator(bid, ask);
		String noArb = "Arbitrage opportunity not detected. However, prices are volatile. Please try again in a few minutes";
		assertEquals(noArb,test);

	}

	/**	Test Purpose: test ability of profit calculator to give an answer conditionally if the exchange doesn't have a price listed.
	 * When an exchange is missing ask price, information the API lists the price as "0." So, need to check to make sure that the bid price isn't zero. 
	 * This test checks to see whether the condition for bid price is zero works. 
	 * 
	 * 
	 */
	@Test
	void testProfitCheckerBidPrice() {
		Coin bid = arbMarket.findMaxBidPrice("Ether");
		Coin ask = arbMarket.findMinAskPrice(1000, "Ether");
		String test = arbMarket.profitCalculator(bid, ask);
		String noArb = "Arbitrage opportunity not detected. However, prices are volatile. Please try again in a few minutes";
		assertEquals(noArb,test);

	}
	

}
