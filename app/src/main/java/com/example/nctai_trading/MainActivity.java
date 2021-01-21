package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
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
import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.*;

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

    private String hashedPassword = "";
    private Object invokeObject;

    // TODO: [MAIN ACTIVITY] Implement sign in button functionality
    // TODO: [MAIN ACTIVITY] Implement reset password functionality
    // TODO: [MAIN ACTIVITY] Implement create button functionality

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        lstView = (ListView)findViewById(R.id.lstView);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnEdit = (Button)findViewById(R.id.btnEdit);
        edtUser = (EditText)findViewById(R.id.edtUsername);


        if(android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        // Load data whern app opened

        //new GetData().execute(Common.getAddressAPI());




        // ALERT BUTTONS

        AlertDialog.Builder passwordAlert = new AlertDialog.Builder(this);

        AlertDialog.Builder emailAlert = new AlertDialog.Builder(this);

        AlertDialog.Builder wrongUsernameAndPassword = new AlertDialog.Builder(this);

        AlertDialog.Builder wrongUsernameAndCorrectPassword = new AlertDialog.Builder(this);

        AlertDialog.Builder correctUsernameAndWrongPassword = new AlertDialog.Builder(this);

        passwordAlert.setTitle("Invalid password");

        emailAlert.setTitle("Invalid email");

        wrongUsernameAndPassword.setTitle("Invalid Username and Password");

        wrongUsernameAndCorrectPassword.setTitle("Invalid username");

        correctUsernameAndWrongPassword.setTitle("Invalid password");

        passwordAlert.setMessage("Password must be between 1-25 Characters, no spaces, no symbols, must contain atleast one number, and one uppercase letter");

        emailAlert.setMessage("Email must be valid");

        wrongUsernameAndPassword.setMessage("Email and Password are incorrect, please enter again");

        wrongUsernameAndCorrectPassword.setMessage("Email was incorrect");

        correctUsernameAndWrongPassword.setMessage("Password was incorrect");

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

                boolean correctUsername = false;
                boolean correctPassword = false;

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
                    MainActivity.this.invokeObject = method.invoke(passwordFormulaInstance,passwordContent);
                    MainActivity.this.hashedPassword = MainActivity.this.invokeObject.toString();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                // MONGO CONNECTION FINALLY

                MongoClientURI uri = new MongoClientURI("mongodb://admin:CompeteToWin*13@cluster0-shard-00-00.jhtaz.mongodb.net:27017,cluster0-shard-00-01.jhtaz.mongodb.net:27017,cluster0-shard-00-02.jhtaz.mongodb.net:27017/test?ssl=true&replicaSet=atlas-79gy36-shard-0&authSource=admin&retryWrites=true&w=majority");

                MongoClient mongoClient = new MongoClient(uri);
                MongoDatabase database = mongoClient.getDatabase("test");

                MongoIterable<String> databaseIterator = database.listCollectionNames();
                //databaseIterator.forEach((Block<? super String>) System.out::println);

                MongoCollection<Document> coll = null;
                for(String name: database.listCollectionNames()){
                    if(name.equals("user")){
                        coll = database.getCollection(name);
                        break;
                    }
                }
                //FindIterable<Document> i = coll.find();
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
                MongoCursor<Document> cursor = i.iterator();
                try{
                    while(cursor.hasNext()) {
                        System.out.println(cursor.next().toJson());
                        ObjectId foundEmail = cursor.next().getObjectId("email");
                        ObjectId foundPass = cursor.next().getObjectId("password");
                        if(foundEmail.toString().equals(emailContent) && foundPass.toString().equals(hashedPassword)){
                            correctUsername = true;
                            correctPassword = true;
                            break;
                        }
                        else if(foundEmail.toString().equals(emailContent) && !foundPass.toString().equals(hashedPassword)){
                            correctUsername = true;
                            correctPassword = false;
                            break;
                        }
                        else if(!foundEmail.toString().equals(emailContent) && foundPass.toString().equals(hashedPassword)){
                            correctUsername = false;
                            correctPassword = true;
                            break;
                        }
                        else{
                            continue;
                        }
                    }
                }
                finally{
                    cursor.close();
                }
                */
                Intent mainPage = new Intent(getApplicationContext(),mainPage.class);
                //boolean emailValidFirst = checkCredentials.quickEmailValidator(emailContent);
                //boolean passwordvalid = checkCredentials.mongoCheckPassword(passwordContent,emailContent);
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
    /*
    // function process data
    class GetData extends AsyncTask<String,Void,String>{
        ProgressDialog pd = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Pre process
            pd.setTitle("Plesae wait...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            // Running process...
            String stream = null;
            String urlString = params[0];

            HTTPDataHandler http = new HTTPDataHandler();
            stream = http.GetHTTPDAta(urlString);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // Done process

            //We will use Gson to parse Json to Class
            Gson gson = new Gson();
            Type listType = new TypeToken<List<User>>(){}.getType();
            users=gson.fromJson(s,listType); // parse to List
            CustomAdapter adapter = new CustomAdapter(getApplicationContext(),users); // Create adapter
            lstView.setAdapter(adapter); // set Adapter to ListView
            // error is happening above
            pd.dismiss();
        }

    }
    */

    public void passwordAlert(View v){

    }
}