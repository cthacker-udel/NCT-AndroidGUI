package com.example.nctai_trading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInButton = findViewById(R.id.signInButton);
        email = findViewById(R.id.mainPageEmail);
        password = findViewById(R.id.mainPageEmail);
        Pattern emailValidator = Pattern.compile("^(.+)@(.+)$");
        createAnAccount = findViewById(R.id.mainActivityCreateAnAccount);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                String emailContent = email.getText().toString().trim();

                String passwordContent = password.getText().toString().trim();

                //MongoClientSettings settings = MongoClientSettings.builder().applyToSslSettings(builder -> builder.enabled(false)).build();

                ///MongoClient client = (MongoClient) MongoClients.create(settings);
                Class c = null;
                Method method = null;

                try {
                    c = Class.forName("passwordFormula");
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
                    method = c.getDeclaredMethod("passwordHasher",null);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                method.setAccessible(true);

                try {
                    String hashedPassword = (String) method.invoke(passwordContent,null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                MongoCredential credential = MongoCredential.createCredential(emailContent,"test",passwordContent.toCharArray());

                MongoClient client = new MongoClient("mongodb+srv://admin:competetowin1313@cluster0.bikbt.mongodb.net/test?retryWrites=true&w=majority");

                MongoDatabase database = client.getDatabase("test");

                //database.runCommand((Command<BsonDocument>)"{ping:1}").wait();
                for(String name: database.listCollectionNames()){
                    System.out.println(name);
                }
                //MongoCollection<Document>  coll = database.getCollection("user");
                //FindIterable<Document> i = coll.find();
                // stops on line MongoCursor<Document> cursor = i.iterator(), might need to edit client host string
                //MongoCursor<Document> cursor = i.iterator();
                //try{
                //    System.out.println(cursor.next().toJson());
                //}
                //finally{
                //    cursor.close();
                //}
                Matcher matcher = emailValidator.matcher(emailContent);
                if(!matcher.matches()) {
                    // TODO: [MAIN LOGIN PAGE] display error message if email is incorrect
                    ;
                }

                if(passwordContent.length() < 1){ // TODO: [IMPORTANT : MAIN LOGIN PAGE] || password is not password on file
                    // TODO: [MAIN LOGIN PAGE] display error message if password is incorrect
                    ;
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
}