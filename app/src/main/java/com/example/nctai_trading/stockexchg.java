package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nctai_trading.ameritrade.ameritradeAccountTradingInterface;
import com.example.nctai_trading.ameritrade.ameritradeGetAccountMarginAccount;
import com.example.nctai_trading.robinhood.robinhood.client.RobinhoodClient;
import com.example.nctai_trading.robinhood.robinhood.exception.RobinhoodException;

import java.util.ArrayList;
import java.util.LinkedList;

public class stockexchg extends AppCompatActivity {
    Button stockexchangePageLoginBtn;
    Spinner exchangedropdown;
    ArrayList<String> exchanges = new ArrayList<>();
    LinkedList<String> causes = new LinkedList<>();
    LinkedList<String> amounts = new LinkedList<>();
    String exchangeselected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stockexchg);
        exchangedropdown = findViewById(R.id.exchangedropdown);
        for(String eachexchanges: new String[]{"Ameritrade","Robinhood"}){
            exchanges.add(eachexchanges);
        }
        for(int i = 1; i < 101; i++){
            amounts.add(i + "%");
        }

        ArrayAdapter<String> exchangeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,exchanges);
        exchangeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exchangedropdown.setAdapter(exchangeAdapter);
        exchangedropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String exchangename = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),"Selected : " + exchangename,Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        View stockexchangePageLoginBtn = findViewById(R.id.stockexchangePageLoginBtn);

        stockexchangePageLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             WebView webview=   findViewById(R.id.stockwebview);
                WebSettings webviewsettings = webview.getSettings();
                webviewsettings.setJavaScriptEnabled(true);
                webviewsettings.setDomStorageEnabled(true);
             webview.setWebViewClient(new mywebviewclient());
             webview.setVisibility(View.VISIBLE);
             webview.loadUrl("https://auth.tdameritrade.com/auth?response_type=code&redirect_uri=https%3A%2F%2Flocalhost%3A8443&client_id=A84UCPOEY9BKT4VM3MYASTSUZJATUSSM%40AMER.OAUTHAP");

            }


        });
    }
    private class mywebviewclient extends WebViewClient{
        private ameritradeAccountTradingInterface accountInterface;
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.i("Ameri",url);
            if (url.startsWith("https://localhost:8443/")){
                view.setVisibility(View.INVISIBLE);
                Uri uri=Uri.parse(url);
                String code=uri.getQueryParameter("code");
                Log.i("Ameri",code);

                accountInterface = ameritradeGetAccountMarginAccount.getAccount().create(ameritradeGetAccountMarginAccount.class);

            }

        }
    }
}