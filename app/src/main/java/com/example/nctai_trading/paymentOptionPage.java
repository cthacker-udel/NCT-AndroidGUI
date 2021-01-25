package com.example.nctai_trading;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.BSONObject;
import org.bson.Document;

import sqip.Card;
import sqip.CardDetails;
import sqip.CardEntry;
import sqip.InAppPaymentsSdk;
import sqip.GooglePay;


public class paymentOptionPage extends AppCompatActivity {

    Button termsOfServiceBtn;
    Button backToHomePageBtn;
    Button payByCardBtn;
    Button checkDiscountBtn;
    String passedEmail;
    EditText discountCodeCheckText;
    String discountCode;

    private static final int LOAD_PAYMENT_DATA_REQUEST_CODE = 1;

    private final Handler handler = new Handler(Looper.getMainLooper());

    //private GooglePayChargeClient googlePayChargeClient;

    // TODO: [PAYMENT OPTION PAGE] Implement check discount code button feature
    // TODO: [PAYMENT OPTION PAGE] Implement pay by crypto button feature
    // TODO: [PAYMENT OPTION PAGE] Implement pay by card feature
    // TODO: [PAYMENT OPTION PAGE] Implement refresh payment status

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option_page);
        termsOfServiceBtn = findViewById(R.id.paymentOptionTermsOfServiceBtn);
        backToHomePageBtn = findViewById(R.id.backToHomePageButton);
        payByCardBtn = findViewById(R.id.payByCardBtn);
        checkDiscountBtn = findViewById(R.id.checkDiscountCodeButton);
        passedEmail = "";
        discountCodeCheckText = findViewById(R.id.enterDiscountCodeText);
        discountCode = discountCodeCheckText.getText().toString();

        AlertDialog.Builder discountCodeAlert = new AlertDialog.Builder(paymentOptionPage.this);

        discountCodeAlert.setTitle("Invalid discount code");

        discountCodeAlert.setMessage("Entered discount code is invalid");

        termsOfServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toTermsOfService = new Intent(getApplicationContext(),termsOfServicePage.class);
                startActivity(toTermsOfService);
            }
        });

        payByCardBtn.setOnClickListener((view) ->
        {
            if(InAppPaymentsSdk.INSTANCE.getSquareApplicationId().equals("REPLACE_ME")){
                return;
            }
            else{
                return;
            }
        });

        backToHomePageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHomePage = new Intent(getApplicationContext(),mainPage.class);
                startActivity(toHomePage);
            }
        });
        checkDiscountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MongoClientURI uri = new MongoClientURI("mongodb://admin:CompeteToWin*13@cluster0-shard-00-00.jhtaz.mongodb.net:27017,cluster0-shard-00-01.jhtaz.mongodb.net:27017,cluster0-shard-00-02.jhtaz.mongodb.net:27017/test?ssl=true&replicaSet=atlas-79gy36-shard-0&authSource=admin&retryWrites=true&w=majority");

                MongoClient mongoClient = new MongoClient(uri);
                MongoDatabase database = mongoClient.getDatabase("test");

                MongoCollection<Document> coll = database.getCollection("user");

                BasicDBObject emailQuery = new BasicDBObject();
                emailQuery.put("email",passedEmail);
                FindIterable<Document> emailID = coll.find(emailQuery);
                BasicDBObject document = new BasicDBObject();
                document.putAll((BSONObject)emailQuery);

                Object result = document.get("discountCode");
                if(result == null){
                    discountCodeAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(paymentOptionPage.this,"Donation code invalid",Toast.LENGTH_SHORT).show();
                        }
                    });
                    discountCodeAlert.create().show();
                    return ;
                }
                else{
                    // valid discount code;
                    String discountCodeOnFile = result.toString();
                    if(discountCode.equals(discountCodeOnFile)){
                        // edit amount
                    }
                    else{
                        discountCodeAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(paymentOptionPage.this,"Donation code invalid",Toast.LENGTH_SHORT).show();
                            }
                        });
                        discountCodeAlert.create().show();
                        return ;
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CardEntry.handleActivityResult(data,result -> {
            if(result.isSuccess()){
                CardDetails cardResult = result.getSuccessValue();
                Card card = cardResult.getCard();
                String nonce = cardResult.getNonce();
            }
            else if(result.isCanceled()){
                Toast.makeText(paymentOptionPage.this,"Canceled",Toast.LENGTH_SHORT).show();
            }
        });

    }
}