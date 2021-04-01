package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nctai_trading.Controller.termsOfServicePage;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.squareup.square.Environment;
import com.squareup.square.SquareClient;
import com.squareup.square.api.CheckoutApi;
import com.squareup.square.models.ChargeRequestAdditionalRecipient;
import com.squareup.square.models.CreateCheckoutRequest;
import com.squareup.square.models.CreateOrderRequest;
import com.squareup.square.models.Money;
import com.squareup.square.models.Order;
import com.squareup.square.models.OrderLineItem;
import com.squareup.square.models.OrderLineItemDiscount;
import com.squareup.square.models.OrderLineItemTax;
import com.squareup.square.models.OrderSource;

import org.brunocvcunha.coinpayments.CoinPayments;
import org.brunocvcunha.coinpayments.model.CreateTransactionResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.requests.CoinPaymentsCreateTransactionRequest;
import org.bson.BSONObject;
import org.bson.Document;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


public class paymentOptionPage extends AppCompatActivity {

    Button termsOfServiceBtn;
    Button backToHomePageBtn;
    Button payByCardBtn;
    Button checkDiscountBtn;
    String passedEmail;
    EditText discountCodeCheckText;
    String discountCode;
    Button payByCryptoBtn;




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
        payByCryptoBtn = findViewById(R.id.payByCryptoButton);

        CoinPayments api = CoinPayments.builder()
                .publicKey("89820a81e29adf82afcc77bc4bcfebc783845195011436dbf57977a0612674f1")
                .privateKey("91Fdd19bd361414edf47E15AB7aa31d5EC02c01e43359072ae13822acdC4aDE0")
                .build();

        //try {
        //    ResponseWrapper<BasicInfoResponse> accountInfo = api.sendRequest(new CoinPaymentsBasicAccountInfoRequest());
        //    Log.println(Log.INFO,"Account", accountInfo.getResult() + "");
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        AlertDialog.Builder discountCodeAlert = new AlertDialog.Builder(paymentOptionPage.this);

        discountCodeAlert.setTitle("Invalid discount code");

        discountCodeAlert.setMessage("Entered discount code is invalid");

        SquareClient client = new SquareClient.Builder()
                .environment(Environment.SANDBOX)
                .accessToken("EAAAEJ2GCY1bPcE29YfE_2IBPWbRplBn4v1MLH2HwCIbUB02hSEqucHTo8uNRXFp")
                .build();

        String locationId = "4H2EQKT97R4PF";

        payByCryptoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ResponseWrapper<CreateTransactionResponse> txResponse = api.sendRequest(CoinPaymentsCreateTransactionRequest.builder().amount(25)
                    .currencyPrice("USD")
                    .currencyTransfer("Crypto currency selected")
                    .callbackUrl("Callback url")
                    .custom("Order XYZ")
                    .build());
                    Log.println(Log.INFO,"Transaction : ",txResponse.getResult().getTransactionId() + " - " + txResponse.getResult().getStatusUrl());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        termsOfServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toTermsOfService = new Intent(getApplicationContext(), termsOfServicePage.class);
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


                // taxes
                //List<OrderLineItemAppliedTax> bodyOrderOrderLineItem0AppliedTaxes = new LinkedList<>();

                //Money bodyOrderOrderLineItems0AppliedTaxes0AppliedMoney = new Money.Builder()
                //        .amount(53L) // money amount
                //        .currency("GBP")
                //        .build();

                //OrderLineItemAppliedTax bodyOrderOrderLineItems0AppliedTaxes0 = new OrderLineItemAppliedTax.Builder(
                //        "38ze1696-z1e3-5628-af6d-f1e04d947fg3")
                //        .uid("uid3")
                //        .appliedMoney(bodyOrderOrderLineItems0AppliedTaxes0AppliedMoney)
                //        .build();

                /*
                // applied discounts
                List<OrderLineItemAppliedDiscount> bodyOrderOrderLineItems0AppliedDiscounts = new LinkedList<>();

                // money to apply on discount
                Money bodyOrderOrderLineItems0AppliedDiscounts0AppliedMoney = new Money.Builder()
                        .amount(161L)
                        .currency("LSL")
                        .build();


                // setting up discount
                OrderLineItemAppliedDiscount bodyOrderOrderLineItems0AppliedDiscounts0 = new OrderLineItemAppliedDiscount.Builder(
                        "56ae1696-z1e3-9328-af6d-f1e04d947gd4")
                        .uid("uid7")
                        .appliedMoney(bodyOrderOrderLineItems0AppliedDiscounts0AppliedMoney)
                        .build();
                bodyOrderOrderLineItems0AppliedDiscounts.add(bodyOrderOrderLineItems0AppliedDiscounts0);


                 */

                // amount of money service is
                Money bodyOrderOrderLineItems0BasePriceMoney = new Money.Builder()
                        .amount(25L)
                        .currency("USD")
                        .build();


                // creating item they are ordering
                OrderLineItem bodyOrderOrderLineItems0 = new OrderLineItem.Builder("1")
                        .uid(UUID.randomUUID().toString())
                        .name("Next Capital Tech AI Services")
                        .note("Buying next capital tech AI services!")
                        //.appliedTaxes(bodyOrderOrderLineItem0AppliedTaxes)
                        .basePriceMoney(bodyOrderOrderLineItems0BasePriceMoney)
                        .build();

                bodyOrderOrderLineItems.add(bodyOrderOrderLineItems0);

                // TAXES

                List<OrderLineItemTax> bodyOrderOrderTaxes = new LinkedList<>();


                // item with taxes
                /*
                OrderLineItemTax bodyOrderOrderTaxes0 = new OrderLineItemTax.Builder()
                        .uid("38ze1696-z1e3-5628-af6d-f1e04d947fg3")
                        .catalogObjectId("catalogObjectID7")
                        .name("name9")
                        .type("INCLUSIVE")
                        .percentage("7.75")
                        .scope("LINE_ITEM")
                        .build();

                 */

                //bodyOrderOrderTaxes.add(bodyOrderOrderTaxes0);

                // DISCOUNTS

                List<OrderLineItemDiscount> bodyOrderOrderDiscounts = new LinkedList<>();

                /*
                Money bodyOrderOrderDiscounts0AmountMoney = new Money.Builder()
                        .amount(100L)
                        .currency("USD")
                        .build();

                 */

                // set up discount percentage
                /*
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
                 */

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

                Order bodyOrderList = new Order.Builder(locationId)
                        .lineItems(bodyOrderOrderLineItems)
                        .build();


                // Create order request

                CreateOrderRequest bodyOrder = new CreateOrderRequest.Builder()
                        .order(bodyOrderList)
                        .locationId("F0J53AJW9S8JC")
                        .idempotencyKey(UUID.randomUUID().toString())
                        .build();

                // address

                /*
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
                 */

                // Additional Recipient

                List<ChargeRequestAdditionalRecipient> bodyAdditionalRecipients = new LinkedList<>();

                Money bodyAdditionalRecipients0AmountMoney = new Money.Builder()
                        .amount(60L)
                        .currency("USD")
                        .build();

                //ChargeRequestAdditionalRecipient bodyAdditionalRecipients0 = new ChargeRequestAdditionalRecipient.Builder(
                //"057P5VYJ4A5X1","Application fees",bodyAdditionalRecipients0AmountMoney)
                //        .build();

                //bodyAdditionalRecipients.add(bodyAdditionalRecipients0);

                // Create Checkout Request

                CreateCheckoutRequest body = new CreateCheckoutRequest.Builder(UUID.randomUUID() + "",bodyOrder)
                        //.askForShippingAddress(true)
                        //.merchantSupportEmail("merchant+support@website.com")
                        //.prePopulateBuyerEmail("example@email.com")
                        //.prePopulateShippingAddress(bodyPrePopulateShippingAddress)
                        .redirectUrl("https://merchant.website.com/order-confirm")
                        .additionalRecipients(bodyAdditionalRecipients)
                        .build();

                // create checkout async

                checkoutApi.createCheckoutAsync(locationId,body).thenAccept(result -> {
                    // TODO SUCCESS CALLBACK HANDLER
                    System.out.println("Successfull transaction!");
                }).exceptionally(exception -> {
                    // TODO FAILURE CALLBACK HANDLER
                    System.out.println("EXCEPTION THROWN");
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