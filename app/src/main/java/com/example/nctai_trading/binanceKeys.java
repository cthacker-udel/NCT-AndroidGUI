package com.example.nctai_trading;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.Map;

public class binanceKeys extends AppCompatActivity {

    Button closeAndApplyBtn;
    EditText secretKey;
    EditText apiKey;
    String secretKeyText;
    String apiKeyText;
    boolean hasApiKey;
    boolean hasSecretKey;
    String foundApiKey;
    String foundSecretKey;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binance_keys);
        closeAndApplyBtn = findViewById(R.id.binanceKeysBtn);
        secretKey = findViewById(R.id.binanceKeysSecretApiKey);
        apiKey = findViewById(R.id.binanceKeysApiKey);


        AlertDialog.Builder binanceKeysAlert = new AlertDialog.Builder(this);
        binanceKeysAlert.setTitle("Binance Keys Alert");
        binanceKeysAlert.setMessage("The binance api key and secret key have been applied");


        closeAndApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secretKeyText = secretKey.getText().toString();
                apiKeyText = apiKey.getText().toString();
                //SharedPreferences.Editor sharedPreferences = getEditor();
                SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // setters
                editor.putString("binanceApiKey",apiKeyText);
                editor.putString("binanceSecretKey",secretKeyText);
                editor.apply();
                editor.commit();

                // getters
                getSharedPreferences("apiKey",MODE_PRIVATE);
                getSharedPreferences("secretKey",MODE_PRIVATE);

                // examples ^^
                SharedPreferences theApiKeyText = getSharedPreferences("test",MODE_PRIVATE);
                System.out.println(theApiKeyText.getString("binanceApiKey","default value api key"));
                SharedPreferences theSecretKeyText = getSharedPreferences("test",MODE_PRIVATE);
                System.out.println(theSecretKeyText.getString("binanceSecretKey","default value secret key"));

                binanceKeysAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(binanceKeys.this,"The entered keys have been applied",Toast.LENGTH_SHORT).show();
                    }
                });
                binanceKeysAlert.setCancelable(true);
                binanceKeysAlert.create().show();
                Intent toMainPage = new Intent(getApplicationContext(),mainPage.class);
                startActivity(toMainPage);
            }
        });

    }
    public SharedPreferences.Editor getEditor(){
        SharedPreferences object = null;
        SharedPreferences.Editor editor = object.edit();
        return editor;
    }
}