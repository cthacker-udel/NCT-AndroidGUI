package com.example.nctai_trading;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
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
import com.squareup.square.Environment;
import com.squareup.square.SquareClient;
import com.squareup.square.api.CheckoutApi;
import com.squareup.square.api.LocationsApi;
import com.squareup.square.models.Address;
import com.squareup.square.models.ChargeRequestAdditionalRecipient;
import com.squareup.square.models.CreateCheckoutRequest;
import com.squareup.square.models.CreateOrderRequest;
import com.squareup.square.models.Money;
import com.squareup.square.models.Order;
import com.squareup.square.models.OrderLineItem;
import com.squareup.square.models.OrderLineItemAppliedDiscount;
import com.squareup.square.models.OrderLineItemAppliedTax;
import com.squareup.square.models.OrderLineItemDiscount;
import com.squareup.square.models.OrderLineItemTax;
import com.squareup.square.models.OrderQuantityUnit;
import com.squareup.square.models.OrderSource;

import org.bson.BSONObject;
import org.bson.Document;

import java.util.LinkedList;
import java.util.List;


public class paymentOptionPage extends AppCompatActivity {

    Button termsOfServiceBtn;
    Button backToHomePageBtn;
    Button payByCardBtn;
    Button checkDiscountBtn;
    String passedEmail;
    EditText discountCodeCheckText;
    String discountCode;




    // TODO: [PAYMENT OPTION PAGE] Implement check discount code button feature
    // TODO: [PAYMENT OPTION PAGE] Implement pay by crypto button feature
    // TODO: [PAYMENT OPTION PAGE] Implement pay by card feature
    // TODO: [PAYMENT OPTION PAGE] Implement refresh payment status

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option_page);

        //CardEntry.setCardNonceBackgroundHandler(cardEntryBackgroundHandler);

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

        SquareClient client = new SquareClient.Builder()
                .environment(Environment.SANDBOX)
                .accessToken("EAAAEJ2GCY1bPcE29YfE_2IBPWbRplBn4v1MLH2HwCIbUB02hSEqucHTo8uNRXFp")
                .build();

        String locationId = "4H2EQKT97R4PF";


        termsOfServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toTermsOfService = new Intent(getApplicationContext(),termsOfServicePage.class);
                startActivity(toTermsOfService);
            }
        });

        payByCardBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                CheckoutApi checkoutApi = client.getCheckoutApi();

                OrderSource bodyOrderOrderSource = new OrderSource.Builder()
                        .name("Customer1")
                        .build();
                List<OrderLineItem> bodyOrderOrderLineItems = new LinkedList<>();

                List<OrderLineItemAppliedTax> bodyOrderOrderLineItem0AppliedTaxes = new LinkedList<>();

                Money bodyOrderOrderLineItems0AppliedTaxes0AppliedMoney = new Money.Builder()
                        .amount(53L) // money amount
                        .currency("GBP")
                        .build();
                OrderLineItemAppliedTax bodyOrderOrderLineItems0AppliedTaxes0 = new OrderLineItemAppliedTax.Builder(
                        "38ze1696-z1e3-5628-af6d-f1e04d947fg3")
                        .uid("uid3")
                        .appliedMoney(bodyOrderOrderLineItems0AppliedTaxes0AppliedMoney)
                        .build();
                List<OrderLineItemAppliedDiscount> bodyOrderOrderLineItems0AppliedDiscounts = new LinkedList<>();

                Money bodyOrderOrderLineItems0AppliedDiscounts0AppliedMoney = new Money.Builder()
                        .amount(161L)
                        .currency("LSL")
                        .build();

                OrderLineItemAppliedDiscount bodyOrderOrderLineItems0AppliedDiscounts0 = new OrderLineItemAppliedDiscount.Builder(
                        "56ae1696-z1e3-9328-af6d-f1e04d947gd4")
                        .uid("uid7")
                        .appliedMoney(bodyOrderOrderLineItems0AppliedDiscounts0AppliedMoney)
                        .build();
                bodyOrderOrderLineItems0AppliedDiscounts.add(bodyOrderOrderLineItems0AppliedDiscounts0);

                Money bodyOrderOrderLineItems0BasePriceMoney = new Money.Builder()
                        .amount(1500L)
                        .currency("USD")
                        .build();

                OrderLineItem bodyOrderOrderLineItems0 = new OrderLineItem.Builder("1")
                        .uid("uid3")
                        .name("Next Capital Tech AI Services")
                        .note("Buying next capital tech AI services!")
                        .appliedTaxes(bodyOrderOrderLineItem0AppliedTaxes)
                        .appliedDiscounts(bodyOrderOrderLineItems0AppliedDiscounts)
                        .basePriceMoney(bodyOrderOrderLineItems0BasePriceMoney)
                        .build();

                bodyOrderOrderLineItems.add(bodyOrderOrderLineItems0);

                // TAXES

                List<OrderLineItemTax> bodyOrderOrderTaxes = new LinkedList<>();

                OrderLineItemTax bodyOrderOrderTaxes0 = new OrderLineItemTax.Builder()
                        .uid("38ze1696-z1e3-5628-af6d-f1e04d947fg3")
                        .catalogObjectId("catalogObjectID7")
                        .name("name9")
                        .type("INCLUSIVE")
                        .percentage("7.75")
                        .scope("LINE_ITEM")
                        .build();

                bodyOrderOrderTaxes.add(bodyOrderOrderTaxes0);

                // DISCOUNTS

                List<OrderLineItemDiscount> bodyOrderOrderDiscounts = new LinkedList<>();

                Money bodyOrderOrderDiscounts0AmountMoney = new Money.Builder()
                        .amount(100L)
                        .currency("USD")
                        .build();

                OrderLineItemDiscount bodyOrderOrderDiscounts0 = new OrderLineItemDiscount.Builder()
                        .uid("56ae1696-z1e3-9328-af6d-f1e04d947gd4")
                        .catalogObjectId("catalogObjectId1")
                        .name("name7")
                        .type("FIXED_AMOUNT")
                        .percentage("percentage5")
                        .amountMoney(bodyOrderOrderDiscounts0AmountMoney)
                        .scope("LINE_ITEM")
                        .build();
                bodyOrderOrderDiscounts.add(bodyOrderOrderDiscounts0);

                // Order

                Order bodyOrderOrder = new Order.Builder("4H2EQKT97R4PF")
                        .id("id6")
                        .referenceId("referenceId")
                        .source(bodyOrderOrderSource)
                        .customerId("customerID")
                        .lineItems(bodyOrderOrderLineItems)
                        .taxes(bodyOrderOrderTaxes)
                        .discounts(bodyOrderOrderDiscounts)
                        .build();

                // Create order request

                CreateOrderRequest bodyOrder = new CreateOrderRequest.Builder()
                        .order(bodyOrderOrder)
                        .locationId("locationId4")
                        .idempotencyKey("12ae1696-z1e3-4328-af6d-f1e04d947gd4")
                        .build();

                // address

                Address bodyPrePopulateShippingAddress = new Address.Builder()
                        .addressLine1("1455 Market St.")
                        .addressLine2("Suite 600")
                        .addressLine3("Address Line 36")
                        .locality("San Francisco")
                        .sublocality("sublocality0")
                        .administrativeDistrictLevel1("CA")
                        .postalCode("94103")
                        .country("US")
                        .firstName("Jane")
                        .lastName("Doe")
                        .build();

                // Additional Recipient

                List<ChargeRequestAdditionalRecipient> bodyAdditionalRecipients = new LinkedList<>();

                Money bodyAdditionalRecipients0AmountMoney = new Money.Builder()
                        .amount(60L)
                        .currency("USD")
                        .build();

                ChargeRequestAdditionalRecipient bodyAdditionalRecipients0 = new ChargeRequestAdditionalRecipient.Builder(
                "057P5VYJ4A5X1","Application fees",bodyAdditionalRecipients0AmountMoney)
                        .build();

                bodyAdditionalRecipients.add(bodyAdditionalRecipients0);

                // Create Checkout Request

                CreateCheckoutRequest body = new CreateCheckoutRequest.Builder("86ae1696-b1e3-4328-af6d-f1e04d947ad6",bodyOrder)
                        .askForShippingAddress(true)
                        .merchantSupportEmail("merchant+support@website.com")
                        .prePopulateBuyerEmail("example@email.com")
                        .prePopulateShippingAddress(bodyPrePopulateShippingAddress)
                        .redirectUrl("https://merchant.website.com/order-confirm")
                        .additionalRecipients(bodyAdditionalRecipients)
                        .build();

                // create checkout async

                checkoutApi.createCheckoutAsync(locationId,body).thenAccept(result -> {
                    // TODO SUCCESS CALLBACK HANDLER
                }).exceptionally(exception -> {
                    // TODO FAILURE CALLBACK HANDLER
                    return null;
                });


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


}