# cointrage

This summary summarizes our project as well as provides the user with a manual about how to use our GUI. 

The aim of this project was to provide an "arbitrage calculator" that detected arbitrage opportunities for a specified cryptocurrency and tell the user through a graphical user interface. 

Arbitrage is defined as taking advantage of the price difference between two markets. An arbitrage opportunity exists if the price of the same asset is different on two exchanges. For example, assume a user can buy Bitcoin for $4000 on exchange A. Furthermore, assume exchange B wants to buy Bitcoin for $4025. A user can serve as a "market maker" and capture a profit of $25 by buying the coin on exchange A and selling it on exchange B. For financial assets, these arbitrage opportunities are hard to come by because only a few major exchanges exist and heavy regulation. Nevertheless, cryptocurrency arbitrage opportunities exist given that many exchanges, or markets, exist without regulation. Our aim was to build a program that alerted users to these arbitrage opportunities such that anyone could use it and make a profit off of these opportunities. 

Despite cryptocurrencies having more opportunities to profit from arbitrage, the risk is that profits are very volatile. Therefore, an arbitrage opportunity can be available one minute and be unavailable the next. 

Our program searches arbitrage opportunities across five of the more well known cryptocurrencies: Bitcoin, Litcoin, BitCoinCash, DogeCoin, and Etherium. To search for the opportunity, click the button on the GUI. If an opportunity exists, the GUI will return the amount the user can profit, the exchange to buy the currency, and the exchange to sell the currency. The next step would be for the user to go to the given exchanges, create an account and execute the transaction. 

Furthermore, one or more arbitrage opportunities may exist for a given coin. Our arbitrage finder calculates the maximum profit for a given coin. Exchanges list both a bid price for a coin as well as an ask price for the coin. The bid price is the price at which a given exchange would buy the coin. The ask price is the price at which a given exchange will sell the coin for. Therefore, arbitrage opportunities exist if on one exchange the ask price is lower than the bid price on a different exchange. This situation is an opportunity to profit because a user can buy the coin at a lower price and sell it at the higher price. Our program searches the exchanges and compares the ask and bid prices of a given coin. If the prices differ, the program will pull the highest bid price and the lowest ask price. Using the highest bid price and the lowest ask price maximizes profit because the user is buying at the lowest price possible and selling at the highest price. 

Our program does have its limitations given the free version of the API we use. We access the API from CoinAPI.io. The free version has a limitation on how many times you can access the API in a given day. Therefore, an error will occur if you try to use the program alot or call it too many times. If this happens, please just use the API the next day. If a trader chooses to use the program, we recommend paying for a version of the API. 


