package com.example.nctai_trading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class binanceKeys extends AppCompatActivity {

    Button closeAndApplyBtn;
    EditText secretKey;
    EditText apiKey;
    String secretKeyText;
    String apiKeyText;
    boolean hasApiKey;
    boolean hasSecretKey;
    String foundApiKey;
    String foundSecretKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binance_keys);
        closeAndApplyBtn = findViewById(R.id.binanceKeysBtn);
        secretKey = findViewById(R.id.binanceKeysSecretApiKey);
        apiKey = findViewById(R.id.binanceKeysApiKey);

        closeAndApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secretKeyText = secretKey.getText().toString();
                apiKeyText = apiKey.getText().toString();
                MongoClientURI uri = new MongoClientURI("mongodb://admin:CompeteToWin*13@cluster0-shard-00-00.jhtaz.mongodb.net:27017,cluster0-shard-00-01.jhtaz.mongodb.net:27017,cluster0-shard-00-02.jhtaz.mongodb.net:27017/test?ssl=true&replicaSet=atlas-79gy36-shard-0&authSource=admin&retryWrites=true&w=majority");

                MongoClient mongoClient = new MongoClient(uri);
                MongoDatabase database = mongoClient.getDatabase("test");
                MongoCollection<Document> collection = database.getCollection("user");

                BasicDBObject emailQuery = new BasicDBObject();
                emailQuery.put("email","passedEmail");
                FindIterable<Document> document = collection.find(emailQuery);
                MongoCursor<Document> cursor = document.iterator();
                while(cursor.hasNext()){
                    // figure out how to 1) Check if apiKey and secretKey exist in document and 2) assign foundApiKey and foundSecretKey
                    // are equal to entered apiKey and secretKey
                    // add apikey and secret key to database
                    // and pull it out
                    System.out.println(((Document)cursor.next()).get("apiKey"));
                    System.out.println(((Document)cursor.next()).get("secretKey"));
                }

            }
        });

    }
}