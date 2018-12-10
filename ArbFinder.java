import java.util.ArrayList;
/** Class that finds arbitrage opportunities given an ArrayList of Cryptocurrencies 
 * 
 * 
 * @author AustinKRahmin
 *
 */
public class ArbFinder {
	
	ArrayList<Coin> market;
	
	
	/** Constructor of the class 
	 * 
	 * @param market arrayList of coins that contains all the cryptocurrencies on the every exchange
	 */
	public ArbFinder(ArrayList<Coin> market) {
		
		this.market = market; 
		
	}
	/** Arbitrage occurs when the Ask Price is less than the Bid Price. This method takes for a given cryptocurrency 
	 * and finds the highest Bid Price. 
	 * 
	 * @param asset the cryptocurrency user wants to buy / sell or search for 
	 * @return the highest bid price for that currency 
	 */
	public Coin findMaxBidPrice(String asset) {
		double max = 0;
		double current;
		int index = 0;
		
		for(int i = 0; i <market.size(); i++) {
			if(market.get(i).getAsset().equals(asset)) {
					current = market.get(i).getBidPrice();
					if(current > max) {
						max = current;
						index = i;
					}
				}
			}
		
			return market.get(index);
		}
	/** Arbitrage occurs when the Ask Price is less than the Bid Price. This method takes for a given cryptocurrency 
	 * and finds the highest Ask Price. 
	 * 
	 * @param asset the cryptocurrency user wants to buy / sell or search for 
	 * @return the highest ask price for that currency 
	 */
	public Coin findMaxAskPrice(String asset) {
		double max = 0;
		double current;
		int index = 0;
		
		for(int i = 0; i <market.size(); i++) {
			if(market.get(i).getAsset().equals(asset)) {
					current = market.get(i).getAskPrice();
					if(current > max) {
						max = current;
						index = i;
					}
				}
			}
		
			return market.get(index);
		}
/** 
 * 
 * 
 * @param max the bid price you want to compare it to 
 * @param asset the cryptocurrency you want to search for 
 * @return the lowest ask price 
 */
	public Coin findMinAskPrice(double max, String asset) {
		double min = 0;
		double current;
		int index = 0;
		
		for(int i = 0; i <market.size(); i++) {
			if(market.get(i).getAsset().equals(asset)) {
					current = market.get(i).getAskPrice();
					if(current < max) {
						min = current;
						index = i;
					}
				}
			}
		
			return market.get(index);
		}
	
	/** Method that checks whether arbitrage opportunity exists. If exists, will print out the profit that can be made as well as 
	 * tell user where to go to exchange to find it and make the trade.  
	 * 
	 * 
	 * @param bid Coin with the highest bid price 
	 * @param ask Coin with the lowest ask price 
	 */
	public String profitCalculator(Coin bid, Coin ask) {
		
		if(bid.getBidPrice() <= ask.getAskPrice() || bid.getBidPrice() == 0 || ask.getAskPrice() == 0) {
			String noArb = "Arbitrage opportunity not detected. However, prices are volatile. Please try again in a few minutes";
			return noArb;
		}
		else {
			double profit = Math.round((bid.getBidPrice() - ask.getAskPrice()) * 100) / 100;
			return ("Arbitrage opportunity detected. Your profit would be: $" + profit + " Buy the coin on " + ask.getExchange()
			+ ". Sell the coin on " +bid.getExchange());
			
		}
		
		
	}

}

