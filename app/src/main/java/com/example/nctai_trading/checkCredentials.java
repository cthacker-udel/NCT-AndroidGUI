package com.example.nctai_trading;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoCredential;
import com.mongodb.MongoSecurityException;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.MongoTimeoutException;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class checkCredentials {

    public static void main(String[] args){
        //String passwordContent = getIntent(mainPage).getStringExtra("passwordContent");
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        MongoClient client = null;
        String database = "test";


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean checkForSymbols(String password){
        String symbols = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ ";
        return IntStream.range(0,password.length()).mapToObj(e -> password.charAt(e)).filter(e -> symbols.contains(Character.toString(e))).count() == 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean checkForUpperCase(String password){
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return IntStream.range(0,password.length()).mapToObj(e -> password.charAt(e)).filter(e -> upperCase.contains(Character.toString(e))).count() >= 1;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean checkForNumbers(String password){
        String digits = "0123456789";
        return IntStream.range(0,password.length()).mapToObj(e -> password.charAt(e)).filter(e -> digits.contains(Character.toString(e))).count() >= 1;
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
