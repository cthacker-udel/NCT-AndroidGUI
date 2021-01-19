package com.example.nctai_trading;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoCredential;
import com.mongodb.MongoSecurityException;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.MongoTimeoutException;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class checkCredentials {

    public static void main(String[] args){
        //String passwordContent = getIntent(mainPage).getStringExtra("passwordContent");
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        MongoClient client = null;
        String database = "test";


    }

    public static boolean mongoCheckPassword(String password,String username){
        try {
            String database = "test";
            String url = "test";
            String port = "1222";
            MongoClient client = null;
            if (StringUtils.isNotBlank(password) && StringUtils.isNotBlank(username)) {
                // looking user <--- dictionary in python stores user data
                // comment2
               client = (MongoClient) new com.mongodb.MongoClient(new MongoClientURI("mongodb://" + username + ":" + password + "@localhost/data"));
               return true;
            }
            return false;
        }
        catch(MongoCommandException mongo_command_exception){
            // when no credentials are provided
            return false;
        }
        catch(MongoSecurityException mongo_security_exception){
            // when no credentials are provided
            return false;
        }
        catch(MongoSocketOpenException mongoSocketException){
            // only get here if db.listCollectionNames().first() caused a timeout
            return false;
        }
        catch(MongoTimeoutException mongoTimeException){
            // only get here if db.listCollectionNames().first() caused a timeout
            return false;
        }
    }
    public static boolean quickEmailValidator(String email){
        boolean allowLocal = true;
        boolean isValid = EmailValidator.getInstance(allowLocal).isValid(email);
        return isValid;
    }
}
