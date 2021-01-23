package com.example.nctai_trading;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Locale;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.BSONObject;
import org.bson.Document;

public class alternateInvestments extends AppCompatActivity {

    // TODO: DONE[AWAITING VERIFICATION] [ALTERNATE INVESTMENT PAGE] Implement select country scroller
    // TODO: DONE[AWAITING VERIFICATION] [ALTERNATE INVESTMENT PAGE] Implement select investment
    // TODO: DONE[AWAITING VERIFICATION] [ALTERNATE INVESTMENT PAGE] Implement select amount
    // TODO: [ALTERNATE INVESTMENT PAGE] Implement invest button feature

    String[] countryCodes;
    ArrayList<String> countries = new ArrayList<>();
    LinkedList<String> investments = new LinkedList<>();
    LinkedList<String> investmentAmounts = new LinkedList<>();
    Spinner countrySpinner;
    Spinner investmentSpinner;
    Spinner investmentAmountSpinner;
    String countryText;
    String investmentText;
    String amountText;
    Button investBtn;
    String passedEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate_investments);
        investBtn = findViewById(R.id.alternativeInvestBtn);
        passedEmail = "";

        AlertDialog.Builder investmentAlert = new AlertDialog.Builder(alternateInvestments.this);

        investmentAlert.setTitle("Investment Alert");

        investmentAlert.setMessage("Your investment was successful");

        countryCodes = Locale.getISOCountries();
        for(String countryCode: countryCodes){
            Locale obj = new Locale("",countryCode);
            countries.add(obj.getDisplayCountry());
        }
        for(String eachInvestment: new String[]{"Biomed Therapeutics", "AI Edge Applications","Green Business","E-Learning","Quantum Hardware and Software"}){
            investments.add(eachInvestment);
        }
        for(int i = 1; i < 101; i++){
            investmentAmounts.add(String.valueOf(i) + "%");
        }
        Collections.sort(countries);
        countrySpinner = findViewById(R.id.countrySpinner);
        investmentSpinner = findViewById(R.id.investmentSpinner);
        investmentAmountSpinner = findViewById(R.id.investmentAmountSpinner);

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,countries);
        ArrayAdapter<String> investmentAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,investments);
        ArrayAdapter<String> investmentAmountAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,investmentAmounts);

        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        investmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        investmentAmountAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        countrySpinner.setAdapter(countryAdapter);
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String countryName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),"Selected: " + countryName, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        investmentSpinner.setAdapter(investmentAdapter);
        investmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String investmentName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),"Selected: " + investmentName, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        investmentAmountSpinner.setAdapter(investmentAmountAdapter);
        investmentAmountSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String investmentAmount = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),"Selected: " + investmentAmount, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        investBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countryText = countrySpinner.getSelectedItem().toString();
                investmentText = investmentSpinner.getSelectedItem().toString();
                amountText = investmentSpinner.getSelectedItem().toString().replaceAll("%","");

                MongoClientURI uri = new MongoClientURI("mongodb://admin:CompeteToWin*13@cluster0-shard-00-00.jhtaz.mongodb.net:27017,cluster0-shard-00-01.jhtaz.mongodb.net:27017,cluster0-shard-00-02.jhtaz.mongodb.net:27017/test?ssl=true&replicaSet=atlas-79gy36-shard-0&authSource=admin&retryWrites=true&w=majority");

                MongoClient mongoClient = new MongoClient(uri);
                MongoDatabase database = mongoClient.getDatabase("test");

                MongoCollection<Document> coll = database.getCollection("user");

                BasicDBObject emailQuery = new BasicDBObject();
                emailQuery.put("email",passedEmail);
                FindIterable<Document> emailID = coll.find(emailQuery);
                BasicDBObject document = new BasicDBObject();
                document.putAll((BSONObject)emailQuery);

                document.put("investment_details",new Object[]{new Document("investment",investmentText),new Document("country",countryText), new Document("percentage",amountText)});

                investmentAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(alternateInvestments.this,"Your investment was posted",Toast.LENGTH_SHORT).show();
                    }
                });
                investmentAlert.create();
                investmentAlert.show();

                Intent toMainPage = new Intent(getApplicationContext(),mainPage.class);
                startActivity(toMainPage);
            }
        });


    }
}