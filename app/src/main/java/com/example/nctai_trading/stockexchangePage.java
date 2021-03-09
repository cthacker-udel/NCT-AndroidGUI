package com.example.nctai_trading;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nctai_trading.robinhood.robinhood.client.RobinhoodClient;
import com.example.nctai_trading.robinhood.robinhood.exception.RobinhoodException;

import java.util.ArrayList;
import java.util.LinkedList;

public class stockexchangePage extends AppCompatActivity {

    Button stockexchangePageLoginBtn;
    Spinner exchangedropdown;
    ArrayList<String> exchanges = new ArrayList<>();
    LinkedList<String> causes = new LinkedList<>();
    LinkedList<String> amounts = new LinkedList<>();
    String exchangeselected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stockexchange_page);
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
            String countryName = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(),"Selected : " + countryName,Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });


            stockexchangePageLoginBtn = findViewById(R.id.stockexchangePageLoginBtn);

        stockexchangePageLoginBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                EditText stockexchangeUsernameEditText=findViewById(R.id.stockexchangeUsernameEditText);
                EditText stockexchangePasswordEditText=findViewById(R.id.stockexchangePasswordEditText);

                RobinhoodClient client = new RobinhoodClient(stockexchangeUsernameEditText.getText().toString(),stockexchangePasswordEditText.getText().toString());

                try {
                    client.getPortfolio();
                } catch (RobinhoodException e) {
                    e.printStackTrace();
                    Log.e("Robin","Exception",e);
                }
                return;
            }


        });
    }
}