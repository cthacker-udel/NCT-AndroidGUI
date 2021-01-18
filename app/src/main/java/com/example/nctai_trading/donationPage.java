package com.example.nctai_trading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;

public class donationPage extends AppCompatActivity {

    // TODO: [DONATION PAGE] Implement select country scroller functionality
    // TODO: [DONATION PAGE] Implement select cause scroller functionality
    // TODO: [DONATION PAGE] Implement select donation amount
    // TODO: [DONATION PAGE] Implement donate button functionality

    Spinner donateCountrySpinner;
    Spinner donateCauseSpinner;
    Spinner donateAmountSpinner;
    String[] countryCodes;
    ArrayList<String> countries = new ArrayList<>();
    LinkedList<String> causes = new LinkedList<>();
    LinkedList<String> amounts = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_page);

        donateCountrySpinner = findViewById(R.id.donationCountryScroller);
        donateCauseSpinner = findViewById(R.id.donationCauseScroller);
        donateAmountSpinner = findViewById(R.id.donationAmountScroller);

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

    }
}