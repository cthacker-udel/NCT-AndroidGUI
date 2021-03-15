package com.example.nctai_trading;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import com.mongodb.BasicDBObject;

import com.mongodb.MongoClient;

import com.mongodb.MongoClientURI;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoDatabase;


import org.bson.Document;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import io.particle.android.sdk.cloud.ParticleCloudSDK;
import io.particle.android.sdk.devicesetup.ParticleDeviceSetupLibrary;

public class MainActivity extends AppCompatActivity {

    Button signInButton;
    EditText email;
    EditText password;
    TextView createAnAccount;
    ListView lstView;
    Button btnAdd, btnEdit, btnDelete;
    EditText edtUser;
    User userSelected=null;
    List<User> users = new ArrayList<User>();
    boolean bothKeysNotCreated;
    boolean bothCoinBaseKeysNotCreated;
    boolean binanceApiKeyError;
    boolean binanceSecretKeyError;
    boolean coinBaseApiKeyError;
    boolean coinBaseSecretKeyError;

    private String hashedPassword = "";
    private Object invokeObject;



    // TODO: [MAIN ACTIVITY] Implement sign in button functionality
    // TODO: [MAIN ACTIVITY] Implement reset password functionality
    // TODO: [MAIN ACTIVITY] Implement create button functionality

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParticleCloudSDK.init(this);
        ParticleDeviceSetupLibrary.initWithSetupOnly(this);


        lstView = (ListView)findViewById(R.id.lstView);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnEdit = (Button)findViewById(R.id.btnEdit);
        edtUser = (EditText)findViewById(R.id.edtUsername);
        bothKeysNotCreated = false;
        bothCoinBaseKeysNotCreated = false;


        if(android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        // Load data whern app opened

        //new GetData().execute(Common.getAddressAPI());

        // Shared Preferences

        SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);

        String apiKey = sharedPreferences.getString("binanceApiKey","defaultBinanceApiKey");

        String secretKey = sharedPreferences.getString("binanceSecretKey","defaultBinanceSecretKey");

        String coinBaseApiKey = sharedPreferences.getString("coinBaseApiKey","defaultCoinBaseApiKey");

        String coinBaseSecretKey = sharedPreferences.getString("coinBaseSecretKey","defaultCoinBaseSecretKey");

        String date = sharedPreferences.getString("currentLogin","defaultCurrentLogin");

        if(!date.equals("defaultCurrentLogin")){ // they have logged in before
            // for tokens that need to be refreshed, refresh here if the expiration date is close to near.
            // ameritrade
            Date savedLogin = null;
            Date currentLogin = null;
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            String currentDate = String.format("%d/%d/%d", LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth(),LocalDate.now().getYear());
            try {
                savedLogin = sdf.parse(date);
                currentLogin = sdf.parse(currentDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            long diffInMillies = Math.abs(savedLogin.getTime() - currentLogin.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
            if(diff == 30){
                // refresh tokens
            }


        }
        else{
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("currentLogin",String.format("%d/%d/%d",LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth(),LocalDate.now().getYear()));
        }


        // ALERT BUTTONS

        AlertDialog.Builder passwordAlert = new AlertDialog.Builder(this);

        AlertDialog.Builder emailAlert = new AlertDialog.Builder(this);

        AlertDialog.Builder wrongUsernameAndPassword = new AlertDialog.Builder(this);

        AlertDialog.Builder wrongUsernameAndCorrectPassword = new AlertDialog.Builder(this);

        AlertDialog.Builder correctUsernameAndWrongPassword = new AlertDialog.Builder(this);

        AlertDialog.Builder userContainsApiKey = new AlertDialog.Builder(this);

        AlertDialog.Builder userContainsSecretKey = new AlertDialog.Builder(this);

        AlertDialog.Builder userContainsApiKeyAndSecretKey = new AlertDialog.Builder(this);

        AlertDialog.Builder userContainsCoinBaseApiKey = new AlertDialog.Builder(this);

        AlertDialog.Builder userContainsCoinBaseSecretKey = new AlertDialog.Builder(this);

        AlertDialog.Builder userContainsCoinBaseApiKeyAndSecretKey = new AlertDialog.Builder(this);

        AlertDialog.Builder userContainsBothKeys = new AlertDialog.Builder(this);

        passwordAlert.setTitle("Invalid password");

        emailAlert.setTitle("Invalid email");

        wrongUsernameAndPassword.setTitle("Invalid Username and Password");

        wrongUsernameAndCorrectPassword.setTitle("Invalid username");

        correctUsernameAndWrongPassword.setTitle("Invalid password");

        userContainsApiKey.setTitle("Api Key Error");

        userContainsSecretKey.setTitle("Secret Key Error");

        userContainsApiKeyAndSecretKey.setTitle("Api Key and Secret Key Error");

        userContainsCoinBaseApiKey.setTitle("CoinBase Api Key Error");

        userContainsCoinBaseSecretKey.setTitle("CoinBase Secret Key Error");

        userContainsCoinBaseApiKeyAndSecretKey.setTitle("CoinBase Api Key and Secret Key Error");

        userContainsBothKeys.setTitle("Coinbase and Binance Error");

        passwordAlert.setMessage("Password must be between 1-25 Characters, no spaces, no symbols, must contain atleast one number, and one uppercase letter");

        emailAlert.setMessage("Email must be valid");

        wrongUsernameAndPassword.setMessage("Email and Password are incorrect, please enter again");

        wrongUsernameAndCorrectPassword.setMessage("Email was incorrect");

        correctUsernameAndWrongPassword.setMessage("Password was incorrect");

        userContainsApiKey.setMessage("Please set Api Key : Enter Binance Keys -> Api Key -> Close and Apply");

        userContainsSecretKey.setMessage("Please set Secret Key: Enter Binance Keys -> Secret Key -> Close and Apply");

        userContainsApiKeyAndSecretKey.setMessage("Please set Secret Key and Api Key : Enter Binance Keys -> Api Key & Secret Key -> Close and Apply");

        userContainsCoinBaseApiKey.setMessage("Please set coinbase api key");

        userContainsCoinBaseSecretKey.setMessage("Please set coinbase secret key");

        userContainsCoinBaseApiKeyAndSecretKey.setMessage("Please set coinbase api and secret key");

        userContainsBothKeys.setMessage("Please update both coinbase and binance api keys and secret keys");

        // ALERT BUTTONS

        signInButton = findViewById(R.id.signInButton);
        email = findViewById(R.id.mainPageEmail);
        password = findViewById(R.id.mainPagePassword);
        Pattern emailValidator = Pattern.compile("^(.+)@(.+)$");
        createAnAccount = findViewById(R.id.mainActivityCreateAnAccount);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v){

                boolean correctUsername = false;
                boolean correctPassword = false;

                String emailContent = email.getText().toString().trim();

                String passwordContent = password.getText().toString();


                if(passwordContent.equals("admin") && emailContent.equals("NCT")){
                    Intent mainPage = new Intent(getApplicationContext(), mainPage.class);
                    //mainPage.putExtra("email",emailContent);
                    startActivity(mainPage);
                }
                else{
                    passwordAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Please enter correct credentials",Toast.LENGTH_SHORT).show();
                        }
                    });
                    passwordAlert.setCancelable(true);
                    passwordAlert.create().show();
                    return;
                }

                /*

                @author - Cameron Thacker
                @version - 1.0
                Password validator

                 */

                if(passwordContent.trim().length() < 1 ){//|| !checkCredentials.checkForNumbers(passwordContent) || !checkCredentials.checkForSymbols(passwordContent) || !checkCredentials.checkForUpperCase(passwordContent)){ // TODO: [IMPORTANT : MAIN LOGIN PAGE] || password is not password on file
                    passwordAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Please edit your password",Toast.LENGTH_SHORT).show();
                        }
                    });
                    passwordAlert.setCancelable(true);
                    passwordAlert.create().show();
                    return;
                }

                /*

                @author - Cameron Thacker
                @version 1.0
                Email validation

                 */



                Matcher matcher = emailValidator.matcher(emailContent);
                if(!matcher.matches() || !checkCredentials.quickEmailValidator(emailContent)) {
                    emailAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Please edit your email",Toast.LENGTH_SHORT).show();
                        }
                    });
                    emailAlert.setCancelable(true);
                    emailAlert.create().show();
                    return;
                }

                /*

                @author - Cameron Thacker

                Invocation of password hashing algorithm in Android through private method means


                 */


                Class c = null;
                Method method = null;
                //com.example.nctai_trading.passwordFormula passwordFormulaInstance = new passwordFormula();

                try {
                    c = Class.forName("com.example.nctai_trading.passwordFormula");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                try {
                    Object obj = c.newInstance();
                } catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }

                try {
                    method = c.getDeclaredMethod("passwordHasher",new Class[]{String.class});
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                method.setAccessible(true);

                // make sure

                //try {
                    //MainActivity.this.invokeObject = method.invoke(passwordFormulaInstance,passwordContent);
                //    MainActivity.this.hashedPassword = MainActivity.this.invokeObject.toString();
                //} catch (IllegalAccessException | InvocationTargetException e) {
                //    e.printStackTrace();
                //}

                /*

                @author - Cameron Thacker

                Mongo Connection to Database and email and password verification

                 */

                // MONGO CONNECTION FINALLY

                MongoClientURI uri = new MongoClientURI("mongodb://admin:CompeteToWin*13@cluster0-shard-00-00.jhtaz.mongodb.net:27017,cluster0-shard-00-01.jhtaz.mongodb.net:27017,cluster0-shard-00-02.jhtaz.mongodb.net:27017/test?ssl=true&replicaSet=atlas-79gy36-shard-0&authSource=admin&retryWrites=true&w=majority");

                MongoClient mongoClient = new MongoClient(uri);
                MongoDatabase database = mongoClient.getDatabase("test");

                MongoCollection<Document> coll = null;
                for(String name: database.listCollectionNames()){
                    if(name.equals("user")){
                        coll = database.getCollection(name);
                        break;
                    }
                }
                BasicDBObject emailQuery = new BasicDBObject();
                emailQuery.put("email",emailContent);
                FindIterable<Document> emailID = coll.find(emailQuery);
                Document emailResult = emailID.first();
                if(emailResult == null){ // no email found
                    correctUsername = false;
                }
                if(emailResult != null){
                    correctUsername = true;
                }
                BasicDBObject passQuery = new BasicDBObject();
                passQuery.put("password",MainActivity.this.hashedPassword);
                FindIterable<Document> passID = coll.find(passQuery);
                Document passResult = passID.first();
                if(passResult == null){
                    correctPassword = false;
                }
                if(passResult != null){
                    correctPassword = true;
                }

                if(!correctUsername && !correctPassword){
                    wrongUsernameAndPassword.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Please edit your password and email",Toast.LENGTH_SHORT).show();
                        }
                    });
                    wrongUsernameAndPassword.setCancelable(true);
                    wrongUsernameAndPassword.create().show();
                    return;
                }
                if(!correctUsername && correctPassword){
                    wrongUsernameAndCorrectPassword.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Please edit your email",Toast.LENGTH_SHORT).show();
                        }
                    });
                    wrongUsernameAndCorrectPassword.setCancelable(true);
                    wrongUsernameAndCorrectPassword.create().show();
                    return;
                }
                if(correctUsername && !correctPassword){
                    correctUsernameAndWrongPassword.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Please edit your password",Toast.LENGTH_SHORT).show();
                        }
                    });
                    correctUsernameAndWrongPassword.setCancelable(true);
                    correctUsernameAndWrongPassword.create().show();
                    return;
                }

                /*

                @author Cameron Thacker

                Shared Preferences validator for api key and secret key

                 */

                if(apiKey.equals("defaultBinanceApiKey") && secretKey.equals("defaultBinanceSecretKey") && !bothKeysNotCreated){
                    bothKeysNotCreated = true;
                }
                if(bothKeysNotCreated){
                    userContainsApiKeyAndSecretKey.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageBothBinanceKeys = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageBothBinanceKeys);
                        }
                    });
                    userContainsApiKeyAndSecretKey.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    });
                    userContainsApiKeyAndSecretKey.create().show();
                }
                if(apiKey.equals("defaultBinanceApiKey") && !bothKeysNotCreated) {
                    binanceApiKeyError = true;
                }
                if(binanceApiKeyError){
                    userContainsApiKey.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageBinanceApiKeyError = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageBinanceApiKeyError);
                        }
                    });
                    userContainsApiKey.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageBinanceApiKeyError = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageBinanceApiKeyError);
                        }
                    });
                    userContainsApiKey.create().show();
                }
                if(secretKey.equals("defaultBinanceSecretKey") && !bothKeysNotCreated){
                    binanceSecretKeyError = true;
                }
                if(binanceSecretKeyError){
                    userContainsSecretKey.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageBinanceSecretKey = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageBinanceSecretKey);
                        }
                    });
                    userContainsSecretKey.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageBinanceSecretKey = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageBinanceSecretKey);
                        }
                    });
                    userContainsSecretKey.create().show();
                }

                if(coinBaseApiKey.equals("defaultCoinBaseApiKey") && coinBaseSecretKey.equals("defaultCoinBaseSecretKey") && !bothCoinBaseKeysNotCreated){
                    bothCoinBaseKeysNotCreated = true;
                }
                if(bothKeysNotCreated && bothCoinBaseKeysNotCreated){
                    userContainsBothKeys.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageBothKeys = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageBothKeys);
                        }
                    });
                    userContainsBothKeys.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageBothKeys = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageBothKeys);
                        }
                    });
                    userContainsBothKeys.create().show();
                }
                if(bothCoinBaseKeysNotCreated){
                    userContainsCoinBaseApiKeyAndSecretKey.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageCoinbaseBothKeys = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageCoinbaseBothKeys);
                        }
                    });
                    userContainsCoinBaseApiKeyAndSecretKey.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageCoinbaseBothKeys = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageCoinbaseBothKeys);
                        }
                    });
                    userContainsCoinBaseApiKeyAndSecretKey.create().show();
                }
                if(coinBaseApiKey.equals("defaultCoinBaseApiKey") && !bothCoinBaseKeysNotCreated){
                    coinBaseApiKeyError = true;
                }
                if(coinBaseApiKeyError){
                    userContainsCoinBaseApiKey.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageCoinBaseApiKeyError = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageCoinBaseApiKeyError);
                        }
                    });
                    userContainsCoinBaseApiKey.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageCoinBaseApiKeyError = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageCoinBaseApiKeyError);
                        }
                    });
                    userContainsCoinBaseApiKey.create().show();
                }
                if(coinBaseSecretKey.equals("defaultCoinBaseSecretKey") && !bothCoinBaseKeysNotCreated){
                    userContainsCoinBaseSecretKey.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edtUser.setVisibility(View.VISIBLE);
                        }
                    });
                    userContainsCoinBaseSecretKey.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    userContainsCoinBaseSecretKey.create().show();
                    coinBaseSecretKeyError = true;
                }
                if(coinBaseSecretKeyError){
                    userContainsCoinBaseSecretKey.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageCoinBaseSecretKeyError = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageCoinBaseSecretKeyError);
                        }
                    });
                    userContainsCoinBaseSecretKey.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent toMainPageCoinBaseSecretKeyError = new Intent(getApplicationContext(),mainPage.class);
                            startActivity(toMainPageCoinBaseSecretKeyError);
                        }
                    });
                    userContainsCoinBaseSecretKey.create().show();
                }
                if(!coinBaseSecretKeyError && !coinBaseApiKeyError && !binanceSecretKeyError && !binanceApiKeyError && !bothCoinBaseKeysNotCreated && !bothKeysNotCreated) {
                    Intent mainPage = new Intent(getApplicationContext(), mainPage.class);
                    //mainPage.putExtra("email",emailContent);
                    startActivity(mainPage);
                }
            }
        });
        createAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSignUpPage = new Intent(getApplicationContext(),signUpPage.class);
                startActivity(toSignUpPage);
            }
        });
    }

}