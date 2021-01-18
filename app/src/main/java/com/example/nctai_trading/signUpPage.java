package com.example.nctai_trading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    // TODO: [SIGN UP PAGE] run a thread in the background if they type in a password that isn't valid then it tells them and also if they type in a different password in confirm password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                String usernameContent = usernameText.getText().toString();
                String emailContent = usernameText.getText().toString();
                String passwordContent = passwordText.getText().toString();
                String confirmPasswordContent = confirmPasswordText.getText().toString();
                String firstNameContent = firstNameText.getText().toString();
                String lastNameContent = lastNameText.getText().toString();

                Matcher emailMatcher = emailValidator.matcher(emailContent);

                if(!emailMatcher.matches()){
                    // TODO: [SIGN UP PAGE] then email is invalid (implement error message)
                    ;
                }

                if(usernameContent.length() < 1){ // || username does not confine to standards
                    // TODO: [SIGN UP PAGE] then username is invalid (implement error message)
                    ;
                }

                if(passwordContent.length() < 1){ // TODO: [SIGN UP PAGE] || !passwordContent.equals(confirmPasswordContent) || password does not confine to standards
                    // TODO: [SIGN UP PAGE] then password is invalid (implement error message)
                    ;
                }

                if(firstNameContent.length() < 1){
                    // TODO: [SIGN UP PAGE] then firstname is invalid (implement error message)
                    ;
                }

                if(lastNameContent.length() < 1){
                    // TODO: [SIGN UP PAGE] then lastname is invalid (implement error message)
                    ;
                }
                /// TODO: [IMPORTANT : SIGN UP PAGE] initiate putting username and password into database, along with firstname and lastname, then switch back to sign in screen,
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