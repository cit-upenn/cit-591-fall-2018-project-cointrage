import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

/** Class that performs JUnit testing on CoinAPI class. CoinAPI class is the class that accesses and reads the API. 
 * 
 * 
 * @author AustinKRahmin
 *
 */
class CoinAPITest {
	
	JSONArray jArray;
	
	
/** Method that sets up the CoinAPITest class object for a test. 
 * 
 * 
 * @throws IOException signals that an input / output exception can occur
 * @throws JSONException signals that a JSON exception can occur 
 */
	void setUp() throws IOException, JSONException {
		CoinAPI coins = new CoinAPI();
		String jsonresponse = coins.makeAPICall("https://rest.coinapi.io/v1/quotes/latest?limit=200");
		jArray = new JSONArray(jsonresponse);
		
	}
	
	/** Method that tests the ability to get information on 200 coins from the API. Once API is accessed, creates 200 coins and saves in 
	 * an ArrayList. This method tests the ability to get information by checking if the ArrayList the coins are saved on is of length 200. 
	 * 
	 * @throws IOException signals that an input / output exception can occur
	 * @throws JSONException signals that a JSON exception can occur 
	 */
	@Test
	void testQuoteCoins() throws JSONException {
		ArrayList<Coin> market = new ArrayList<>();
		
		for(int i=0;i<jArray.length();i++) {
			String title=jArray.getJSONObject(i).getString("symbol_id");
			String exchange = title.split("_")[0];
			String asset = title.split("_")[2] + "_" + title.split("_")[3];
			double bid =jArray.getJSONObject(i).getDouble("bid_price");
			double ask =jArray.getJSONObject(i).getDouble("ask_price");
			Coin coin = new Coin(exchange, asset, bid, ask);
			market.add(coin);
		}
		
		int test = market.size();
		assertEquals(200,test);
		
		
	}

}
