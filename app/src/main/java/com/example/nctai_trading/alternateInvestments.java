package com.example.nctai_trading;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Locale;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate_investments);
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


    }
}