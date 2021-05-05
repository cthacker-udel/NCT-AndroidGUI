package com.example.nctai_trading;

import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.alpaca.alpacaMethods;
import com.example.nctai_trading.basefex.basefexMethods;
import com.example.nctai_trading.bibox.BiBoxHttpClient;
import com.example.nctai_trading.bibox.BiBoxHttpClientConfig;
import com.example.nctai_trading.bidesk.BrokerApiClientFactory;
import com.example.nctai_trading.bidesk.BrokerApiRestClient;
import com.example.nctai_trading.bilaxy.bilaxyMethods;
import com.example.nctai_trading.binance.binanceMethods;
import com.example.nctai_trading.bitMEX.bitmexMethods;
import com.example.nctai_trading.bitcoincom.bitcoincomMethods;
import com.example.nctai_trading.bitforex.bitforexMethods;
import com.example.nctai_trading.bithumb.bithumbMethods;
import com.example.nctai_trading.bitrue.bitrueMethods;
import com.example.nctai_trading.bittrex.BittrexExchange;
import com.example.nctai_trading.bkex.bkexMethods;
import com.example.nctai_trading.btse.btseMethods;
import com.example.nctai_trading.bybit.bybitMethods;
import com.example.nctai_trading.coinbasePro.coinbaseProMethods;
import com.example.nctai_trading.digifinex.digifinexMethods;
import com.example.nctai_trading.exante.exanteMethods;
import com.example.nctai_trading.huobiApi2.api.HbdmswapRestApiV1;
import com.example.nctai_trading.idcm.idcmMethods;
import com.example.nctai_trading.interactiveBrokers.interactiveBrokersMethods;
import com.example.nctai_trading.kiteConnect.KiteConnect;
import com.example.nctai_trading.kraken.KrakenApi;
import com.example.nctai_trading.wbf.wbfMethods;

import org.spongycastle.asn1.cms.KeyAgreeRecipientIdentifier;

@RequiresApi(api = Build.VERSION_CODES.O)
public class exchangeInterface {

    /*

    Getting shared preferences

     */

    com.example.nctai_trading.mainPage mainPage = new mainPage();

    SharedPreferences sharedPreferences = mainPage.getThePreferences();

    /*

    List of all clients

     */

    com.example.nctai_trading.alpaca.alpacaMethods alpacaMethods = new alpacaMethods(sharedPreferences.getString("alpacaApiKey",""),sharedPreferences.getString("alpacaSecretKey",""));

    com.example.nctai_trading.basefex.basefexMethods basefexMethods = new basefexMethods(sharedPreferences.getString("basefexApiKey",""),sharedPreferences.getString("basefexSecretKey",""));

    BiBoxHttpClient biBoxHttpClient = new BiBoxHttpClient(new BiBoxHttpClientConfig.Builder().apiKey(sharedPreferences.getString("biboxApikey","")).secret(sharedPreferences.getString("biboxSecretKey","")).build());

    BrokerApiRestClient bideskClient = new BrokerApiClientFactory("https://api.bidesk.com/",sharedPreferences.getString("bideskApiKey",""),sharedPreferences.getString("bideskApiKey","")).newRestClient();

    com.example.nctai_trading.bilaxy.bilaxyMethods bilaxyMethods = new bilaxyMethods(sharedPreferences.getString("bilaxyApiKey",""),sharedPreferences.getString("bilaxyApiKey",""));

    com.example.nctai_trading.binance.binanceMethods binanceMethods = new binanceMethods(sharedPreferences.getString("binanceApiKey",""),sharedPreferences.getString("binanceApiKey",""));

    com.example.nctai_trading.binanceUS.binanceMethods binanceMethodsUS = new com.example.nctai_trading.binanceUS.binanceMethods(sharedPreferences.getString("binanceUSApiKey",""),sharedPreferences.getString("binanceUSApiKey",""));

    com.example.nctai_trading.bitcoincom.bitcoincomMethods bitcoincomMethods = new bitcoincomMethods(sharedPreferences.getString("bitcoincomApiKey",""),sharedPreferences.getString("bitcoincomApiKey",""));

    com.example.nctai_trading.bitforex.bitforexMethods bitforexMethods = new bitforexMethods(sharedPreferences.getString("bitforexApiKey",""),sharedPreferences.getString("bitforexApiKey",""));

    com.example.nctai_trading.bithumb.bithumbMethods bithumbMethods = new bithumbMethods(sharedPreferences.getString("bithumbApiKey",""),sharedPreferences.getString("bithumbApiKey",""));

    com.example.nctai_trading.bitMEX.bitmexMethods bitmexMethods = new bitmexMethods(sharedPreferences.getString("bitMEXApiKey",""),sharedPreferences.getString("bitMEXApiKey",""));

    com.example.nctai_trading.bitrue.bitrueMethods bitrueMethods = new bitrueMethods(sharedPreferences.getString("bitrueApiKey",""),sharedPreferences.getString("bitrueSecretKey",""));

    com.example.nctai_trading.bittrex.BittrexExchange bittrexExchange = new BittrexExchange(sharedPreferences.getString("bittrexApiKey",""),sharedPreferences.getString("bittrexSecretKey",""));

    com.example.nctai_trading.bkex.bkexMethods bkexMethods = new bkexMethods(sharedPreferences.getString("bkexApiKey",""),sharedPreferences.getString("bkexSecretKey",""));

    com.example.nctai_trading.btse.btseMethods btseMethods = new btseMethods(sharedPreferences.getString("btseApiKey",""),sharedPreferences.getString("btseSecretKey",""));

    com.example.nctai_trading.bybit.bybitMethods bybitMethods = new bybitMethods(sharedPreferences.getString("bybitApiKey",""),sharedPreferences.getString("bybitApiKey",""));

    com.example.nctai_trading.coinbasePro.coinbaseProMethods coinbaseProMethods = new coinbaseProMethods(sharedPreferences.getString("coinbaseApiKey",""),sharedPreferences.getString("coinbaseSecretKey",""),sharedPreferences.getString("coinbasePassphrase",""));

    com.example.nctai_trading.digifinex.digifinexMethods digifinexMethods = new digifinexMethods(sharedPreferences.getString("digifinexApiKey",""),sharedPreferences.getString("digifinexSecretKey",""));

    //com.example.nctai_trading.exante.exanteMethods exanteMethods = new exanteMethods(sharedPreferences.getString("exanteApiKey",""),sharedPreferences.getString("exanteSecretKey",""));

    com.example.nctai_trading.huobiApi2.api.HbdmswapRestApiV1 hbdmswapRestApiV1 = new HbdmswapRestApiV1("https://api.huobi.us/v1",sharedPreferences.getString("huobiApiKey",""),sharedPreferences.getString("huobiSecretKey",""));

    com.example.nctai_trading.idcm.idcmMethods idcmMethods = new idcmMethods(sharedPreferences.getString("idcmApiKey",""),sharedPreferences.getString("idcmSecretKey",""));

    //com.example.nctai_trading.interactiveBrokers.interactiveBrokersMethods interactiveBrokersMethods = new interactiveBrokersMethods()

    /*

    user needs to login to gain access to tokens to make trades

     */

    com.example.nctai_trading.kiteConnect.KiteConnect kiteConnect = new KiteConnect(sharedPreferences.getString("kiteApiKey",""));

    com.example.nctai_trading.kraken.KrakenApi krakenApi = new KrakenApi();

    public void setKrakenApi(){
        krakenApi.setKey(sharedPreferences.getString("krakenApiKey",""));
        krakenApi.setSecret(sharedPreferences.getString("krakenSecretKey",""));
    }

    com.example.nctai_trading.wbf.wbfMethods wbfMethods = new wbfMethods(sharedPreferences.getString("wbfApiKey",""),sharedPreferences.getString("wbfSecretKey",""));

    String dataReceived = "";

    public String getDataReceived() {
        return dataReceived;
    }

    public void setDataReceived(String dataReceived) {
        this.dataReceived = dataReceived;
    }

    public void followParticleCommand(){

        //{"data":"TTTTTTEEEESSSTTTTT","ttl":60,"published_at":"2021-05-05T08:26:19.211Z","coreid":"api"}

    }
}
