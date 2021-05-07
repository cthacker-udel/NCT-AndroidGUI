![NCT-LOGO](app/src/main/res/drawable/nct_new.png) 
# NCT-AndroidGUI
> CAMERON THACKER - NCT ANDROID GUI


![dependencies](https://img.shields.io/badge/dependencies-up%20to%20date-green)


![guava](https://img.shields.io/badge/guava-24.1--jre-brightgreen)
![alibaba](https://img.shields.io/badge/alibaba-1.2.47-brightgreen)
![lombok](https://img.shields.io/badge/lombok-1.18.8-brightgreen)
![coinpayments](https://img.shields.io/badge/coinpayments-1.3-brightgreen)
![launchdarkly](https://img.shields.io/badge/launchdarkly-2.3.1-brightgreen)
![particle](https://img.shields.io/badge/particle-1.0.1-brightgreen)
![jackson](https://img.shields.io/badge/jackson-2.5.0-brightgreen)
![retrofit](https://img.shields.io/badge/retrofit-2.9.0-brightgreen)
![oksse](https://img.shields.io/badge/oksse-0.9.0-brightgreen)
![gson](https://img.shields.io/badge/gson-2.8.6-brightgreen)
![org.apache](https://img.shields.io/badge/org.apache-3.11-brightgreen)
![mailgun](https://img.shields.io/badge/mailgun-1.9.2-brightgreen)
![square](https://img.shields.io/badge/square-8.1.20210121-brightgreen)
![supercsv](https://img.shields.io/badge/supercsv-2.4.0-brightgreen)
![javax-websocket](https://img.shields.io/badge/javaxwebsocket-1.1-brightgreen)
![android-layout](https://img.shields.io/badge/androidlayout-2.0.4-brightgreen)
![signalr4j](https://img.shields.io/badge/signalr4j-2.0.4-brightgreen)
![javax](https://img.shields.io/badge/javax-1.0-brightgreen)
![com.google](https://img.shields.io/badge/com.google-1.2.1-brightgreen)
![mongoDB](https://img.shields.io/badge/mongoDB-3.4.0-brightgreen)

## Functions supported:

- [x] MongoDB Server Implementation
- [x] Shared Preferences Implementation
- [x] Binance.us API implementation
- [x] Binance.com API Implementation
- [x] CoinbasePro API implementation
- [x] Bithumb API implementation
- [x] BitMEX API Implementation
- [x] Alpaca API implementation
- [x] baseFEX API implementation
- [x] Mailgun API implementation
- [x] Square Checkout API implementation
- [x] Particle Cloud API Implementation
- [x] Bitforex Implementation
- [x] Bilaxy Implementation 
- [x] Huobi Implementation
- [x] Kiteconnect Implementation
- [x] Kraken Implementation
- [x] Wbf Implementation
- [x] Bitrue Implementation
- [x] Bibox Implementation

### MongoDB Implementation

- [x] added MongoDB Database authentification upon sign in
- [x] added sign up page functionality to add user credentials to database

### Coinbase Implementation

- [x] Withdraw requests
- [x] Deposit requests
- [x] Buy requests
- [x] Sell requests
- [x] Fill requests
- [x] Order information requests
- [x] Exchange limit requests
- [x] Account information requests

### Binance/BinanceUS Implementation

- [x] Buy requests
- [x] Sell requests
- [x] Account information requests
- [x] Order information requests
- [x] Market Requests
- [x] Trade requests
- [x] Cancel requests

### Shared Preferences Implementation

- [x] Store binance and coinbase credentials safely
- [x] Check if user has coinbase or binance keys stored in system upon sign in, and prompted to enter them in upon sign in

### Mailgun Implementation

- [x] Send messages to domains
- [x] Domain credential requests
- [x] Email validation requests
- [x] IP requests
- [x] IP Pool requests
- [x] Events requests
- [x] Stats requests
- [x] Bouncer requests

### Square Implementation

- [x] Added Checkout functionality when pay by card button is pressed in mainPage.java
- [x] Added Tax functionality

### Particle Implementation

- [x] Added access token implementation
- [x] Added O-Auth implementation
- [x] added device implementation
- [x] added user implementation
- [x] added event implementation
- [x] added webhook implementation
- [x] added firmware implementation
- [x] added device group implementation
- [x] added customer implementation

### Bithumb Implementation

- [x] Place orders / withdraw orders implementation
- [x] Order History implementation
- [x] Ticker price implementation
- [x] Kline implementation

### Alpaca Implementation

- [x] Account Info implementation
- [x] Order implementation
- [x] Order Position implementation
- [x] Asset implementation

### BaseFEX Implementation

- [x] Account Info implementation
- [x] Order implementation
- [x] Trade implementation

### BitMEX Implementation

- [x] Announcement Requests
- [x] Api Key Requests
- [x] Execution Requests
- [x] Funding Requests
- [x] Global Notification Requests
- [x] Instrument Requests

### WBF Implementation

- [x] Transaction History Requests

### KiteConnect Implementation

- [x] Order Requests
- [x] Order History Requests

### Kraken Implementation

- [x] Order Requests
- [x] Order History Requests

### Bilaxy Implementation

- [x] Order Requests
- [x] Order History Requests

### Bitrue Implementation

- [x] Order Requests
- [x] Order History Requests 

### Bibox Implementation

- [x] Order Requests
- [x] Order History Requests 

## TODOS
-------

TRANSACTION HISTORY:

  > bybit
  > digifinex
  > exante
  > idcm
  > 

1. Square
  1. Add square implementation within app
2. Particle
  1. Add particle implementation within app
3. Exchanges
  1. Add any remaining exchanges required
4. Binance
  1. Test binance functionality
5. Coinbase
  1. Test coinbase functionality
6. MongoDB
  1. Test MongoDB functionality
  
  
#### Resources

### [Binance Methods](https://github.com/cthacker-udel/NCT-AndroidGUI/tree/master/app/src/main/java/com/example/nctai_trading/binanceUS)

### [Coinbase Methods](https://github.com/cthacker-udel/NCT-AndroidGUI/tree/master/app/src/main/java/com/example/nctai_trading/coinbasePro)

### [Mailgun Methods](https://github.com/cthacker-udel/NCT-AndroidGUI/blob/master/app/src/main/java/com/example/nctai_trading/mailgun/mailGunMethods.java)

### [Particle Methods](https://github.com/cthacker-udel/NCT-AndroidGUI/blob/master/app/src/main/java/com/example/nctai_trading/particle/particleMethods.java)

### [Alpaca Methods](https://github.com/cthacker-udel/NCT-AndroidGUI/blob/master/app/src/main/java/com/example/nctai_trading/alpaca/alpacaMethods.java)

### [Bithumb Methods](https://github.com/cthacker-udel/NCT-AndroidGUI/blob/master/app/src/main/java/com/example/nctai_trading/bithumb/bithumbMethods.java)

### [App Pages](https://github.com/cthacker-udel/NCT-AndroidGUI/tree/master/app/src/main/res/layout)

### [Gradle Build : app](https://github.com/cthacker-udel/NCT-AndroidGUI/blob/master/app/build.gradle)

### [Gradle Build : project](https://github.com/cthacker-udel/NCT-AndroidGUI/blob/master/build.gradle)
