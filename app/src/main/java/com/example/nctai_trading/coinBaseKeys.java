package com.example.nctai_trading;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class coinBaseKeys extends AppCompatActivity {

    Button coinBaseBtn;
    EditText coinBaseApiKeyEditText;
    EditText coinBaseSecretKeyEditText;
    String coinBaseApiText;
    String coinBaseSecretKeyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_base_keys);
        coinBaseBtn = findViewById(R.id.coinbaseKeysButton);
        coinBaseApiKeyEditText = findViewById(R.id.coinbaseKeysApiKey);
        coinBaseSecretKeyEditText = findViewById(R.id.coinBaseSecretKeyEditText);

        AlertDialog.Builder coinBaseAlert = new AlertDialog.Builder(this);

        coinBaseAlert.setTitle("Api Keys Applied");

        coinBaseAlert.setMessage("Coinbase Api Key and Secret Key have been applied");

        coinBaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coinBaseApiText = coinBaseApiKeyEditText.getText().toString();
                coinBaseSecretKeyText = coinBaseSecretKeyEditText.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("coinBaseApiKey",coinBaseApiText);
                editor.putString("coinBaseSecretKey",coinBaseSecretKeyText);
                editor.apply();
                editor.commit();

                coinBaseAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent toMainPage = new Intent(getApplicationContext(),mainPage.class);
                        startActivity(toMainPage);
                    }
                });
                coinBaseAlert.create().show();
                return;
            }
        });

    }
}