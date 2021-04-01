package com.example.nctai_trading.Controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nctai_trading.R;
import com.example.nctai_trading.mainPage;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.BSONObject;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;

public class donationPage extends AppCompatActivity {

    // TODO: [DONATION PAGE][Completed] Implement select country scroller functionality
    // TODO: [DONATION PAGE][Completed] Implement select cause scroller functionality
    // TODO: [DONATION PAGE][Completed] Implement select donation amount
    // TODO: [DONATION PAGE] Implement donate button functionality

    String passedEmail = "";//getIntent().getStringExtra("email");

    Spinner donateCountrySpinner;
    Spinner donateCauseSpinner;
    Spinner donateAmountSpinner;
    String[] countryCodes;
    ArrayList<String> countries = new ArrayList<>();
    LinkedList<String> causes = new LinkedList<>();
    LinkedList<String> amounts = new LinkedList<>();
    Button donateButton;
    String countrySelected;
    String causeSelected;
    String amountSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_page);

        donateCountrySpinner = findViewById(R.id.donationCountryScroller);
        donateCauseSpinner = findViewById(R.id.donationCauseScroller);
        donateAmountSpinner = findViewById(R.id.donationAmountScroller);

        AlertDialog.Builder donateAlert = new AlertDialog.Builder(donationPage.this);

        donateAlert.setTitle("Donation complete");

        donateAlert.setMessage("Your donation has been completed");

        donateButton = findViewById(R.id.donateButton);

        countryCodes = Locale.getISOCountries();
        for(String countryCode: countryCodes){
            Locale obj = new Locale("",countryCode);
            countries.add(obj.getDisplayCountry());
        }
        for(String eachCause: new String[]{"Youth STEM","Girls who Code","Entrepreneurship","Veterans","Under Privleged Youth","Homeless","Environmental Conservation","Animal Rescue"}){
            causes.add(eachCause);
        }
        for(int i = 1; i < 101; i++){
            amounts.add(i + "%");
        }
        Collections.sort(countries);

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,countries);
        ArrayAdapter<String> causesAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,causes);
        ArrayAdapter<String> amountsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,amounts);

        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        causesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        amountsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        donateCountrySpinner.setAdapter(countryAdapter);
        donateCauseSpinner.setAdapter(causesAdapter);
        donateAmountSpinner.setAdapter(amountsAdapter);

        donateCountrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String countryName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),"Selected : " + countryName,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        donateCauseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String causeName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),"Selected : " + causeName, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        donateAmountSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String theAmount = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),"Selected : " + theAmount,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                causeSelected = donateCauseSpinner.getSelectedItem().toString();
                countrySelected = donateCountrySpinner.getSelectedItem().toString();
                amountSelected = donateAmountSpinner.getSelectedItem().toString().replaceAll("%","");

                MongoClientURI uri = new MongoClientURI("mongodb://admin:CompeteToWin*13@cluster0-shard-00-00.jhtaz.mongodb.net:27017,cluster0-shard-00-01.jhtaz.mongodb.net:27017,cluster0-shard-00-02.jhtaz.mongodb.net:27017/test?ssl=true&replicaSet=atlas-79gy36-shard-0&authSource=admin&retryWrites=true&w=majority");

                MongoClient mongoClient = new MongoClient(uri);
                MongoDatabase database = mongoClient.getDatabase("test");

                MongoCollection<Document> coll = database.getCollection("user");

                BasicDBObject emailQuery = new BasicDBObject();
                emailQuery.put("email",passedEmail);
                FindIterable<Document> emailID = coll.find(emailQuery);
                BasicDBObject document = new BasicDBObject();
                document.putAll((BSONObject)emailQuery);

                document.append("donation_details", new Object[]{new Document("country",countrySelected),new Document("cause",causeSelected), new Document("percentage",amountSelected)});
                donateAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(donationPage.this,"Donation completed, returning to main page..", Toast.LENGTH_SHORT).show();
                    }
                });
                donateAlert.setCancelable(true);
                donateAlert.create().show();
                Intent toMainPage = new Intent(getApplicationContext(), mainPage.class);
                startActivity(toMainPage);
            }
        });

    }
}