package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationOptions;
import java.lang.reflect.*;

import org.bson.BsonDocument;
import org.bson.Document;


import java.util.logging.Logger;
import java.util.regex.*;

public class MainActivity extends AppCompatActivity {

    Button signInButton;
    EditText email;
    EditText password;
    TextView createAnAccount;


    private String hashedPassword;

    // TODO: [MAIN ACTIVITY] Implement sign in button functionality
    // TODO: [MAIN ACTIVITY] Implement reset password functionality
    // TODO: [MAIN ACTIVITY] Implement create button functionality

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // ALERT BUTTONS

        AlertDialog.Builder passwordAlert = new AlertDialog.Builder(this);

        AlertDialog.Builder emailAlert = new AlertDialog.Builder(this);

        passwordAlert.setTitle("Invalid password");

        emailAlert.setTitle("Invalid email");

        passwordAlert.setMessage("Password must be between 1-25 Characters, no spaces, no symbols, must contain atleast one number, and one uppercase letter");

        emailAlert.setMessage("Email must be valid");

        // ALERT BUTTONS

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInButton = findViewById(R.id.signInButton);
        email = findViewById(R.id.mainPageEmail);
        password = findViewById(R.id.mainPagePassword);
        Pattern emailValidator = Pattern.compile("^(.+)@(.+)$");
        createAnAccount = findViewById(R.id.mainActivityCreateAnAccount);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v){

                String emailContent = email.getText().toString().trim();

                String passwordContent = password.getText().toString();

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



                //MongoClientSettings settings = MongoClientSettings.builder().applyToSslSettings(builder -> builder.enabled(false)).build();

                ///MongoClient client = (MongoClient) MongoClients.create(settings);
                Class c = null;
                Method method = null;
                com.example.nctai_trading.passwordFormula passwordFormulaInstance = new passwordFormula();

                try {
                    c = Class.forName("com.example.nctai_trading.passwordFormula");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                try {
                    Object obj = c.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

                try {
                    method = c.getDeclaredMethod("passwordHasher",new Class[]{String.class});
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                method.setAccessible(true);

                // make sure

                try {
                    Object invokeResult = method.invoke(passwordFormulaInstance,passwordContent);
                    String hashedPassword = invokeResult.toString();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                MongoCredential credential = MongoCredential.createCredential(emailContent,"test",passwordContent.toCharArray());

                //MongoClient client = new MongoClient("mongodb://admin:CompeteToWin*13@cluster0-shard-00-00.jhtaz.mongodb.net:27017,cluster0-shard-00-01.jhtaz.mongodb.net:27017,cluster0-shard-00-02.jhtaz.mongodb.net:27017/test?ssl=true&replicaSet=atlas-79gy36-shard-0&authSource=admin&retryWrites=true&w=majority");

                MongoClient client = new MongoClient("mongodb+srv://admin:CompeteToWin*13@cluster0.bikbt.mongodb.net/test?retryWrites=true&w=majority");

                MongoDatabase database = client.getDatabase("test");

                // declare internet permission in android manifest

                //database.runCommand((Command<BsonDocument>)"{ping:1}").wait();
                // line 177 fails
                //MongoIterable<String> databaseIterator = database.listCollectionNames();
                //for(String name: database.listCollectionNames()){
                //    System.out.println(name);
                //}
                MongoCollection<Document>  coll = database.getCollection("user");
                FindIterable<Document> i = coll.find();
                MongoCursor<Document> cursor = i.iterator();
                //MongoCursor<Document> cursor = i.iterator();
                try{
                    System.out.println(cursor.next().toJson());
                }
                finally{
                    cursor.close();
                }
                Intent mainPage = new Intent(getApplicationContext(),mainPage.class);
                mainPage.putExtra("PasswordContent",passwordContent);
                mainPage.putExtra("EmailContent",emailContent);
                boolean emailValidFirst = checkCredentials.quickEmailValidator(emailContent);
                boolean passwordvalid = checkCredentials.mongoCheckPassword(passwordContent,emailContent);
                startActivity(mainPage);
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

    public void passwordAlert(View v){

    }
}