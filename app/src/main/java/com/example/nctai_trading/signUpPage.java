package com.example.nctai_trading;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import net.sargue.mailgun.Configuration;
import net.sargue.mailgun.Mail;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class signUpPage extends AppCompatActivity {

    Button confirmButton;
    Button backButton;
    EditText usernameText;
    EditText emailText;
    EditText passwordText;
    EditText confirmPasswordText;
    EditText firstNameText;
    EditText lastNameText;

    private String hashedPassword = "";
    private Object invokeObject;


    // TODO: [SIGN UP PAGE] run a thread in the background if they type in a password that isn't valid then it tells them and also if they type in a different password in confirm password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder emailInvalidAlert = new AlertDialog.Builder(this);

        emailInvalidAlert.setTitle("Email invalid");

        emailInvalidAlert.setMessage("Email provided was invalid.");

        AlertDialog.Builder emailLengthAlert = new AlertDialog.Builder(this);

        emailLengthAlert.setTitle("Email invalid");

        emailLengthAlert.setMessage("Provide an email address");

        AlertDialog.Builder emailAlreadyExistsAlert = new AlertDialog.Builder(this);

        emailAlreadyExistsAlert.setTitle("Email invalid");

        emailAlreadyExistsAlert.setMessage("Email already exists");

        AlertDialog.Builder usernameLengthAlert = new AlertDialog.Builder(this);

        usernameLengthAlert.setTitle("Username Invalid");

        usernameLengthAlert.setMessage("Username must contain characters");

        AlertDialog.Builder passwordLengthAlert = new AlertDialog.Builder(this);

        passwordLengthAlert.setTitle("Password Invalid");

        passwordLengthAlert.setMessage("Password must contain characters");

        AlertDialog.Builder firstNameLengthAlert = new AlertDialog.Builder(this);

        firstNameLengthAlert.setTitle("First Name Input Invalid");

        firstNameLengthAlert.setMessage("First Name length must be > 0");

        AlertDialog.Builder lastNameLengthAlert = new AlertDialog.Builder(this);

        lastNameLengthAlert.setTitle("Last Name Input Invalid");

        lastNameLengthAlert.setMessage("Last Name length must be > 0");

        AlertDialog.Builder confirmPasswordAlert = new AlertDialog.Builder(this);

        confirmPasswordAlert.setTitle("Password invalid");

        confirmPasswordAlert.setMessage("Both passwords must be the same");


        setContentView(R.layout.activity_sign_up_page);
        confirmButton = findViewById(R.id.signUpPageConfirmBtn);
        backButton = findViewById(R.id.signUpPageBackBtn);

        usernameText = findViewById(R.id.signUpUsernameEditText);
        emailText = findViewById(R.id.signUpEmailEditText);
        passwordText = findViewById(R.id.signUpPasswordEditText);
        confirmPasswordText = findViewById(R.id.signUpConfirmPasswordEditText);
        firstNameText = findViewById(R.id.signUpFirstNameEditText);
        lastNameText = findViewById(R.id.signUpLastNameEditText);
        Pattern emailValidator = Pattern.compile("^(.+)@(.+)$");

        // TODO: [SIGN UP PAGE] Create confirm button to operate correctly (if operating uncorrectly)
        // TODO: [SIGN UP PAGE] Create back button to operate correctly (if operating uncorrectly)

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                String usernameContent = usernameText.getText().toString().trim();
                String emailContent = emailText.getText().toString().trim();
                String passwordContent = passwordText.getText().toString().trim();
                String confirmPasswordContent = confirmPasswordText.getText().toString().trim();
                String firstNameContent = firstNameText.getText().toString().trim();
                String lastNameContent = lastNameText.getText().toString().trim();

                if(!passwordContent.equals(confirmPasswordContent)){
                    confirmPasswordAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(signUpPage.this,"Passwords must be the same",Toast.LENGTH_SHORT).show();
                        }
                    });
                    confirmPasswordAlert.setCancelable(true);
                    confirmPasswordAlert.create().show();
                    return ;
                }


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

                if(!(emailResult == null)){
                    emailAlreadyExistsAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(signUpPage.this,"The email already exists",Toast.LENGTH_SHORT).show();
                        }
                    });
                    emailAlreadyExistsAlert.setCancelable(true);
                    emailAlreadyExistsAlert.create().show();
                    return ;
                }

                Matcher emailMatcher = emailValidator.matcher(emailContent);

                //if(!emailMatcher.matches() || !Patterns.EMAIL_ADDRESS.matcher(emailContent).matches()){
                //    emailInvalidAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                //        @Override
                //        public void onClick(DialogInterface dialog, int which) {
                //            Toast.makeText(signUpPage.this,"Please edit your email",Toast.LENGTH_SHORT).show();
                //        }
                //    });
                //    emailInvalidAlert.setCancelable(true);
                //    emailInvalidAlert.create().show();
                //    return ;
                //}

                if(emailContent.length() < 1){
                    emailLengthAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(signUpPage.this,"Please enter an email address",Toast.LENGTH_LONG).show();
                        }
                    });
                    emailLengthAlert.setCancelable(true);
                    emailLengthAlert.create().show();
                    return ;
                }

                if(usernameContent.length() < 1){ // || username does not confine to standards
                    usernameLengthAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(signUpPage.this,"The username must contain characters",Toast.LENGTH_SHORT).show();
                        }
                    });
                    usernameLengthAlert.setCancelable(true);
                    usernameLengthAlert.create().show();
                    return ;
                }

                if(passwordContent.length() < 1){ // TODO: [SIGN UP PAGE] || !passwordContent.equals(confirmPasswordContent) || password does not confine to standards
                    passwordLengthAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(signUpPage.this,"Password must contain characters",Toast.LENGTH_SHORT).show();
                        }
                    });
                    passwordLengthAlert.setCancelable(true);
                    passwordLengthAlert.create().show();
                    return ;
                }

                if(firstNameContent.length() < 1){
                    firstNameLengthAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(signUpPage.this,"First name must contain characters",Toast.LENGTH_SHORT).show();
                        }
                    });
                    firstNameLengthAlert.setCancelable(true);
                    firstNameLengthAlert.create().show();
                    return ;
                }

                if(lastNameContent.length() < 1){
                    lastNameLengthAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(signUpPage.this,"Last name length must be > 0",Toast.LENGTH_SHORT).show();
                        }
                    });
                    lastNameLengthAlert.setCancelable(true);
                    lastNameLengthAlert.create().show();
                    return ;
                }

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
                    signUpPage.this.invokeObject = method.invoke(passwordFormulaInstance,passwordContent);
                    signUpPage.this.hashedPassword = signUpPage.this.invokeObject.toString();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                /// TODO: [IMPORTANT : SIGN UP PAGE] initiate putting username and password into database, along with firstname and lastname, then switch back to sign in screen,
                //List<Document> documentList = new ArrayList<>();
                // TODO: [MAILGUN IMPLEMENTATION] Display message saying that an email has been sent to their email address, then add a link and that will verify them, or add an code and then I will create a separate page which will have two credentials to be entered: email and verification code, if they enter the correct verification code then the data in the database is switched to verified

                ObjectId _id = new ObjectId();
                ObjectId userID = new ObjectId();
                ObjectId wallet = new ObjectId();

                Gson gson = new Gson();

                Document createdUser = new Document("_id",_id);
                //createdUser.append("twoFactor",new Object[]{new Document("active",false),new Document("secret","")});
                createdUser.append("email",emailContent);
                createdUser.append("password",hashedPassword);
                createdUser.append("wallet",wallet);
                createdUser.append("userID",userID);

                SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                String _idStr = gson.toJson(_id);
                String userIdStr = gson.toJson(userID);

                editor.putString("MongoUserId",userIdStr);
                editor.putString("Mongo_ID",_idStr);

                editor.apply();
                editor.commit();

                //documentList.add(createdUser);

                //coll.insertMany(documentList);
                coll.insertOne(createdUser);

                //Configuration configuration = new Configuration()
                //        .domain("nextcapitaltech.com")
                //        .apiKey("key-XXXXXX")
                //        .from("Test account", "nextcapital@nextcapitaltech.com");

                //Mail.using(configuration)
                //        .to(emailContent)
                //        .subject("Next Capital Tech Verification Email")
                //        .text("Verification code : ######")
                //        .build()
                //        .send();


                // createdUser.append("emailVerify", false);
                // updated username when credentials are created

                Intent toMainActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(toMainActivity);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMainActivity2 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(toMainActivity2);
            }
        });
    }
}