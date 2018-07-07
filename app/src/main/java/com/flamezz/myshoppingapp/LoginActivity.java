package com.flamezz.myshoppingapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton,startButton,cancelButton;
    private EditText loginEmail,loginPassword;
    private AlertDialog.Builder alertdialogbuilder;
    private FirebaseAuth firebaseAuth;
    private String loginname,loginpassword,credentialemail,credentialpassword,registrationemail,registrationpass;
    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_login);
        alertdialogbuilder = new AlertDialog.Builder(this);
        Initialize();
        createAccount();
        setUpLoginMethod();
    }

    public void Initialize()
    {
        loginEmail = findViewById(R.id.loginEmail);
        loginPassword =findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);
        startButton = findViewById(R.id.startButton);
        firebaseAuth = FirebaseAuth.getInstance();
    }


    //Account Creation
    public void createAccount()
    {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View mview = getLayoutInflater().inflate(R.layout.custom_alert_dialog,null);
                final EditText  accountEmail = mview.findViewById(R.id.accountEmail);
                final EditText   accountPassword = mview.findViewById(R.id.accountPassword);
                Button registerButton = mview.findViewById(R.id.registerButton);
                registerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this,"Creating Account","Please Wait",true);
                        firebaseAuth.createUserWithEmailAndPassword(registrationemail=accountEmail.getText().toString(),registrationpass=accountPassword.getText().toString())
                                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        progressDialog.dismiss();
                                        if(task.isSuccessful())
                                        {

                                            Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                            startActivity(intent);
                                        }
                                        else
                                        {

                                            Toast.makeText(getApplicationContext(),"Error,Please Try Again Later",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                    }
                });
                alertdialogbuilder.setView(mview);
                alertdialogbuilder.create();
                alertdialogbuilder.show();


            }
        });

    }




    //Login
    public void setUpLoginMethod() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLoginValidation();

            }
        });

    }

    public void checkLoginValidation()
    {
        InitializeLogin();
        if(!validate())
        {
            Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
        }
        else
        {
            onLoginSuccess();
        }

    }


    public boolean validate() {
        boolean valid = true;
        if (loginname.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(loginname).matches()) {
            loginEmail.setError("Please Enter Valid Email");
            valid = false;
        }
        if (loginpassword.isEmpty())
        {
            loginPassword.setError("Please Enter Valid Password");
            valid = false;
        }
        return valid;
    }


    public void onLoginSuccess()
    {
        final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this,"Checking Credentials","Please Wait",true);
        firebaseAuth.signInWithEmailAndPassword(credentialemail = loginname, credentialpassword = loginpassword)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {

                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,ShoppingCartActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void InitializeLogin()
    {
        loginname = loginEmail.getText().toString();
        loginpassword = loginPassword.getText().toString();
    }


    }

