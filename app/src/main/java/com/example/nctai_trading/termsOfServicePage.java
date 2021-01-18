package com.example.nctai_trading;

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

import java.util.ArrayList;
import java.util.LinkedList;

public class termsOfServicePage extends AppCompatActivity {

    Spinner termsOfServiceProfitFeeSpinner;
    Spinner termsOfServiceNCTPermissionSpinner;
    TextView textView;
    ScrollView termsOfServiceScrollView;


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
                Intent toPaymentOptionPage = new Intent(getApplicationContext(),paymentOptionPage.class);
                startActivity(toPaymentOptionPage);
            }
        });
    }
}