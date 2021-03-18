package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class addKeys extends AppCompatActivity {

    String email = getIntent().getStringExtra("EMAIL");
    Spinner exchangeChooser;
    EditText apiKeyText;
    EditText secretKeyText;
    EditText passPhraseText;
    ArrayList<String> allExchanges;
    Button addKeysBtn;

    Button testBtn1;
    Button testBtn2;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_keys);
        exchangeChooser = findViewById(R.id.addKeysScroller);
        apiKeyText = findViewById(R.id.addKeysApiKey);
        secretKeyText = findViewById(R.id.addKeysSecretKey);
        addKeysBtn = findViewById(R.id.addKeysButton);

        testBtn1 = findViewById(R.id.testprint);
        testBtn2 = findViewById(R.id.printest2);

        com.example.nctai_trading.adminMethods.exchangesList exchangesList = new com.example.nctai_trading.adminMethods.exchangesList();

        allExchanges.add("Example Exchange");
        allExchanges.addAll(exchangesList.getExchangesList());

        String[] exchangeList = allExchanges.toArray(new String[0]);

        ArrayAdapter<String> exchanges = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line);
        exchanges.addAll(exchangeList);
        exchangeChooser.setAdapter(exchanges);


        addKeysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String apiKey = apiKeyText.getText().toString();
                String secretKey = secretKeyText.getText().toString();
                String passPhrase = passPhraseText.getText().toString();
                String exchange = exchangeChooser.getSelectedItem().toString();
                if(exchange.equals("Example Exchange")){
                    Toast.makeText(addKeys.this,"Choose a exchange",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    editor.putString(String.format("%sApiKey",exchange),apiKey);
                    editor.putString(String.format("%sSecretKey",exchange),secretKey);
                    if(passPhrase.length() > 0){
                        editor.putString("%sPassPhrase",passPhrase);
                    }
                    editor.apply();
                    editor.commit();
                }
            }
        });

        testBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = sharedPreferences.getString("%sApiKey",exchangeChooser.getSelectedItem().toString().trim());
                testBtn1.setText(key);
            }
        });
        testBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String secretKey = sharedPreferences.getString("%sSecretKey",exchangeChooser.getSelectedItem().toString().trim());
                testBtn2.setText(secretKey);
            }
        });
    }
}