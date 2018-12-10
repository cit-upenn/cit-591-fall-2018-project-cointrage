import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

/** Class that represents a button on our CoinTrage GUI. 
 * 
 * 
 * @author AustinKRahmin
 *
 */
public class Button {
	
	String cryptocurrency;
	
	/** Constructor for the button
	 * 
	 * 
	 * @param cryptocurrency the cryptocurrency that the button represents, or when pushed will give you output for that 
	 */
	public Button(String crytocurrency) {
		
		this.cryptocurrency = cryptocurrency;
	}

/** Method that simulates pushing a button. When the button is pushed, 
 * the designated cryptocurrency is searched to find arbitrage opportunities. 
 * @return 
 * 
 * @throws IOException
 * @throws JSONException
 */
	public String pushButton(String asset) throws IOException, JSONException {
		CoinAPI coins = new CoinAPI();
		String jsonresponse = coins.makeAPICall("https://rest.coinapi.io/v1/quotes/latest?limit=200");
		JSONArray jArray = new JSONArray(jsonresponse);
		ArrayList<Coin> market =  coins.quoteCoins(jArray);
		
		ArbFinder arbMarket = new ArbFinder(market);
		
		Coin bid = arbMarket.findMaxBidPrice(asset);
		Coin ask = arbMarket.findMinAskPrice(10000, asset);
		return arbMarket.profitCalculator(bid, ask);
		
		
		

		
	}
	

}