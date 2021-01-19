package com.example.nctai_trading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationOptions;
import org.bson.Document;


import java.util.logging.Logger;
import java.util.regex.*;

public class MainActivity extends AppCompatActivity {

    Button signInButton;
    EditText email;
    EditText password;
    TextView createAnAccount;

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
            public void onClick(View v) {

                //MongoClientSettings settings = MongoClientSettings.builder().applyToSslSettings(builder -> builder.enabled(false)).build();

                ///MongoClient client = (MongoClient) MongoClients.create(settings);
                MongoClient client = new MongoClient("mongodb+srv://admin:testing54@cluster0.jhtaz.mongodb.net/test?retryWrites=true&w=majority");
                MongoDatabase database = client.getDatabase("test");
                MongoCollection<Document>  coll = database.getCollection("user");
                FindIterable<Document> i = coll.find();
                // stops on line 60, might need to edit client host string
                MongoCursor<Document> cursor = i.iterator();
                try{
                    System.out.println(cursor.next().toJson());
                }
                finally{
                    cursor.close();
                }
                String emailContent = email.getText().toString();
                Matcher matcher = emailValidator.matcher(emailContent);
                if(!matcher.matches()) {
                    // TODO: [MAIN LOGIN PAGE] display error message if email is incorrect
                    ;
                }
                String passwordContent = password.getText().toString();
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