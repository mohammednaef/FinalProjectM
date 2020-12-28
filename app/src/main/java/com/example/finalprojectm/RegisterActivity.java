package com.example.finalprojectm;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText mFullName,mEmail,mPassword,mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseFirestore fStore;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegisterBtn = findViewById(R.id.registerBtn);
        mLoginBtn = findViewById(R.id.createText);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            finish();
        }

        mRegisterBtn.setOnClickListener(v -> {
            final String email = mEmail.getText().toString().trim();
            final String password = mPassword.getText().toString().trim();
            final String fullName = mFullName.getText().toString();
            final String phone    = mPhone.getText().toString();

            if(TextUtils.isEmpty(fullName)){
                mFullName.setError("Full Name is Required.");
                return;
            }

            if(TextUtils.isEmpty(email)){
                mEmail.setError("Email is Required.");
                return;
            }


            if(TextUtils.isEmpty(password)){
                mPassword.setError("Password is Required.");
                return;
            }

            if(password.length() < 6){
                mPassword.setError("Password Must be Greater or equal to 6 Characters");
                return;
            }

            if(TextUtils.isEmpty(phone)){
                mPhone.setError("Phone is Required.");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        FirebaseUser fuser = fAuth.getCurrentUser();
                        fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(RegisterActivity.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d(TAG, "onFailure: Email not sent " + e.getMessage());
                            }
                        });

                        Toast.makeText(RegisterActivity.this, "User Created.", Toast.LENGTH_SHORT).show();
                        FirebaseUser user = fAuth.getCurrentUser();
                        String userid = user.getUid();
                        reference = FirebaseDatabase.getInstance()
                                .getReference("User").child(userid);
                        User userc = new User(userid, fullName,email,phone);

                        reference.setValue(userc)
                                .addOnCompleteListener(
                                        new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete
                                                    (final @NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Intent intent = new Intent(
                                                            RegisterActivity.this,
                                                            HomeActivity.class);
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    startActivity(intent);
                                                    finish();
                                                }}});

                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));

                    }else {
                        Toast.makeText(RegisterActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }
            });
        });

        mLoginBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),LoginActivity.class)));


    }

    public boolean isValidEmail (String email ) {
        if (email.contains("hashem@gmail.com")) {
            System.out.println(" valid Email address");
            return true;
        }
        System.out.println(" Invalid Email address");
        return false;
    }

    public boolean isInValidEmail (String email ) {
        if (email.contains("hashemgmail.com") || email.contains("hashem@.com") || email.contains("hashem@gmail.") || email.contains("hashem@gmailcom")) {
            System.out.println(" in valid Email address");
            return false;
        }
        System.out.println(" valid Email address");
        return true;
    }

    public boolean isEmptyEmail(String email){
        if (email.contains("")){
            System.out.println(" is Empty Email");
            return false;
        }
        return true;
    }

    public boolean isValidPassword(String password){
        if (password.contains("123456")) {
            System.out.println(" valid Password");
            return true;
        }
        System.out.println(" Invalid Password");
        return false;
    }
    public boolean isInValidPassword(String password){
        if (password.contains("1") || password.contains("12") || password.contains("123") ||  password.contains("1234") ||  password.contains("12345")) {
            System.out.println(" Invalid Password");
            return false;
        }
        System.out.println(" valid Password");
          return true;
    }

    public boolean isValidFullName(String fullName){
        if (fullName.contains("Hashem Karam") || fullName.contains("Hashem Khader Karam")) {
            System.out.println(" valid Full Name");
            return true;
        }
        System.out.println(" Invalid Full Name");
        return false;
     }

     public boolean isInValidFullName(String fullName){

     }

    }