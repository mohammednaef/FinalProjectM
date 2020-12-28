package com.example.finalprojectm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprojectm.LoginTest.LoginValidatorInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements LoginValidatorInterface {
    Button logbtn;
    EditText emailed;
    EditText passworded;
    FirebaseAuth auth;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailed = findViewById(R.id.emailED);
        passworded = findViewById(R.id.passwordED);
        logbtn = findViewById(R.id.loginbttn);
        auth = FirebaseAuth.getInstance();
        signup = findViewById(R.id.signupTV);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = emailed.getText().toString().trim();
                String password = passworded.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    emailed.setError("Please enter email");
                    return;

                }
                if (TextUtils.isEmpty(password)) {
                    passworded.setError("Please enter password");
                    return;

                }

                if (password.length() < 6) {
                    passworded.setError("Password Must be >= 6 Characters");
                    return;

                }


                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(LoginActivity.this, "Logged in Successfuly", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                            throw new RuntimeException("login crach"); // Force a crash

                        } else {
                            Toast.makeText(LoginActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

    }

    @Override
    public boolean isValidEmail(CharSequence email) {
        emailed.addTextChangedListener((TextWatcher) email);
        return true;
    }

    @Override
    public boolean isValidPassword(CharSequence password) {
         passworded.addTextChangedListener((TextWatcher) password);
         return true;
    }
}