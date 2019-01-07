package com.example.chetana.fyp_final;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    Button button;
    Button SignUp, monitor , user ;
    CheckBox TC;
    EditText FullNameEditText,EmailEditText,PasswordEditText,ConfrimPasswordEditText,MobileNumberEditText;
    String FullNameHolder,EmailHolder,PasswordHolder,PhoneNumberHolder, ProfileHolder;
    Firebase firebase;
    DatabaseReference databaseReference;
    public static final String Firebase_Server_URL = "https://finalyp-c34d9.firebaseio.com/";
    public static final String Database_Path = "https://console.firebase.google.com/project/finalyp-c34d9/database/finalyp-c34d9/data/";

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Firebase.setAndroidContext(SignUp.this);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        SignUp = (Button) findViewById(R.id.SignUp);
        monitor = (Button) findViewById(R.id.Monitor);
        user = (Button) findViewById(R.id.User);
        TC = (CheckBox) findViewById(R.id.TC);
        FullNameEditText = (EditText) findViewById(R.id.FullName);
        EmailEditText = (EditText) findViewById(R.id.Email);
        PasswordEditText = (EditText) findViewById(R.id.Password);
        ConfrimPasswordEditText = (EditText) findViewById(R.id.ConfrimPassword);
        MobileNumberEditText = (EditText) findViewById(R.id.Mobile_Number);


        monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileHolder= "Monitor";
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileHolder="User";
            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp_Model UserDetails = new SignUp_Model();
                GetDataFromEditText();

                UserDetails.setFullName(FullNameHolder);
                UserDetails.setMobile_Number(PhoneNumberHolder);
                UserDetails.setEmail(EmailHolder);
                UserDetails.setPassword(PasswordHolder);
                UserDetails.setProfile(ProfileHolder);

                //String key = databaseReference.child("New Users").push().getKey();
                databaseReference.child("New Users").push().setValue(UserDetails);
                // Showing Toast message after successfully data submit.
                Toast.makeText(SignUp.this, "Signed up successfully", Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(SignUp.this,
                        SignIn.class);
                startActivity(myIntent);
            }
        });
    }

    private void GetDataFromEditText() {
        FullNameHolder = FullNameEditText.getText().toString().trim();
        EmailHolder = EmailEditText.getText().toString().trim();
        PasswordHolder = PasswordEditText.getText().toString().trim();
        PhoneNumberHolder = MobileNumberEditText.getText().toString().trim();
    }

}
