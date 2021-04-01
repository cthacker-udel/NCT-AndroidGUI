package com.example.nctai_trading.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nctai_trading.R;
import com.example.nctai_trading.paymentOptionPage;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.BSONObject;
import org.bson.Document;

import java.util.ArrayList;
import java.util.LinkedList;

public class termsOfServicePage extends AppCompatActivity {

    Spinner termsOfServiceProfitFeeSpinner;
    Spinner termsOfServiceNCTPermissionSpinner;
    TextView textView;
    ScrollView termsOfServiceScrollView;
    String passedEmail;
    String termSelected;
    String permissionSelected;



    LinkedList<String> profitFeeTermList = new LinkedList<>();
    LinkedList<String> permissionNCTList = new LinkedList<>();

    Button agreeToTermsOfServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_of_service_page);
        //scrollView = findViewById(R.id.termsOfServiceScrollView);
        //scrollView.addView(findViewById(R.id.termsOfServiceTextView));
        agreeToTermsOfServiceButton = findViewById(R.id.termsOfServiceAgreeBtn);

        this.passedEmail = "";

        // make sure that all options have been selected, there are values present, besides the default, then continue
        /*
        // TODO: [TERMS OF SERVICE PAGE] Implement check methods for terms of service

        if Profit fee term has not been selected then display error message( or raise exception which takes the user to a new page)

        if you have not given NCT permission to automatically deduct or charge my accounts then display error message (or raise exception which takes the user to a new page)

         */

        textView = findViewById(R.id.termsOfServiceScrollViewTextView);
        textView.setText("This is text that will go inside of scroll view");
        termsOfServiceScrollView = findViewById(R.id.termsOfServiceScrollView);

        termsOfServiceProfitFeeSpinner = findViewById(R.id.termsOfServiceProfitFeeSpinner);
        termsOfServiceNCTPermissionSpinner = findViewById(R.id.termsOfServiceNCTPermissionSpinner);


        for(String eachTerm: new String[]{"Daily","Weekly","2 Weeks","3 Weeks","Monthly","> 1 month Contact Us"}){
            profitFeeTermList.add(eachTerm);
        }

        for(String eachPermission: new String[]{"Yes","No, Email Me Invoices"}){
            permissionNCTList.add(eachPermission);
        }

        ArrayAdapter<String> profitFeeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,profitFeeTermList);

        ArrayAdapter<String> permissionNCTAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,permissionNCTList);

        profitFeeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        permissionNCTAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        termsOfServiceProfitFeeSpinner.setAdapter(profitFeeAdapter);

        termsOfServiceNCTPermissionSpinner.setAdapter(permissionNCTAdapter);


        termsOfServiceNCTPermissionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String permissionNCT = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),"Selected : " + permissionNCT,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        termsOfServiceProfitFeeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String profitFee = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),"Selected : " + profitFee,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        // TODO: [TERMS OF SERVICE PAGE] Implement scroll values for terms of service page, such as profit fee term, give NCT permission

        agreeToTermsOfServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // return to payment option page

                MongoClientURI uri = new MongoClientURI("mongodb://admin:CompeteToWin*13@cluster0-shard-00-00.jhtaz.mongodb.net:27017,cluster0-shard-00-01.jhtaz.mongodb.net:27017,cluster0-shard-00-02.jhtaz.mongodb.net:27017/test?ssl=true&replicaSet=atlas-79gy36-shard-0&authSource=admin&retryWrites=true&w=majority");

                MongoClient mongoClient = new MongoClient(uri);
                MongoDatabase database = mongoClient.getDatabase("test");

                MongoCollection<Document> coll = database.getCollection("user");

                BasicDBObject emailQuery = new BasicDBObject();
                emailQuery.put("email",passedEmail);
                FindIterable<Document> emailID = coll.find(emailQuery);
                BasicDBObject document = new BasicDBObject();
                document.putAll((BSONObject)emailQuery);

                termSelected = termsOfServiceProfitFeeSpinner.getSelectedItem().toString();
                permissionSelected = termsOfServiceNCTPermissionSpinner.getSelectedItem().toString();

                document.put("Permission",permissionSelected);
                document.put("Term",termSelected);
                document.put("terms_agreed",true);

                Intent toPaymentOptionPage = new Intent(getApplicationContext(), paymentOptionPage.class);
                startActivity(toPaymentOptionPage);
            }
        });
    }
}