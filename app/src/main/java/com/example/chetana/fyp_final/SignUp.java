package com.example.chetana.fyp_final;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    Button button;
    Button SignUp, monitor , user ;
    CheckBox TC;
    EditText FullNameEditText,EmailEditText,PasswordEditText,ConfrimPasswordEditText,MobileNumberEditText;
    String FullNameHolder,EmailHolder,PasswordHolder,PhoneNumberHolder, ProfileHolder, LatHolder, LngHolder;
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
                LatHolder="Null";
                LngHolder="Null";
            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SignUp_Model_Monitor UserDetails = new SignUp_Model_Monitor();
                final SignUp_Model_VI UserDetails_VI = new SignUp_Model_VI();
                GetDataFromEditText();
                if (ProfileHolder.equals("Monitor")) {
                    UserDetails.setFullName(FullNameHolder);
                    UserDetails.setMobile_Number(PhoneNumberHolder);
                    UserDetails.setEmail(EmailHolder);
                    UserDetails.setPassword(PasswordHolder);
                    UserDetails.setProfile(ProfileHolder);
                    databaseReference.child("Monitors").orderByChild("email").equalTo(EmailHolder).addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                EmailEditText.setText("");
                                Toast.makeText(getApplicationContext(), "Email Id already exists !", Toast.LENGTH_SHORT).show();
                            }else {
                                databaseReference.child("Monitors").push().setValue(UserDetails);
                                Toast.makeText(SignUp.this, "Signed up successfully", Toast.LENGTH_LONG).show();
                                Intent myIntent = new Intent(SignUp.this,
                                        SignIn.class);
                                startActivity(myIntent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }else {
                        UserDetails_VI.setFullName(FullNameHolder);
                        UserDetails_VI.setMobile_Number(PhoneNumberHolder);
                        UserDetails_VI.setEmail(EmailHolder);
                        UserDetails_VI.setPassword(PasswordHolder);
                        UserDetails_VI.setProfile(ProfileHolder);
                        UserDetails_VI.setLat(LatHolder);
                        UserDetails_VI.setLng(LngHolder);
                        databaseReference.child("Visually Impaired").orderByChild("email").equalTo(EmailHolder).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                EmailEditText.setText("");
                                Toast.makeText(getApplicationContext(), "Email Id already exists !", Toast.LENGTH_SHORT).show();
                            }else {
                                databaseReference.child("Visually Impaired").push().setValue(UserDetails_VI);
                                Toast.makeText(SignUp.this, "Signed up successfully", Toast.LENGTH_LONG).show();
                                Intent myIntent = new Intent(SignUp.this,
                                        SignIn.class);
                                startActivity(myIntent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
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
