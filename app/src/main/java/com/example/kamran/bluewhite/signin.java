package com.example.kamran.bluewhite;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {


private EditText mEmailField;
private  EditText mPasswordField;
private Button mLoginButton;
private FirebaseAuth mAuth;
private FirebaseAuth.AuthStateListener mAuthListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mAuth = FirebaseAuth.getInstance();



        mEmailField = (EditText) findViewById(R.id.emailField);
        mPasswordField = (EditText) findViewById(R.id.passwordfield);

        mLoginButton = (Button) findViewById(R.id.loginButton);
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                   if (firebaseAuth.getCurrentUser() !=null){
                       startActivity(new Intent(signin.this , Main2Activity.class));
                   }
            }
        };


        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startSignIn();

            }
        });



    }
    protected void onStart(){
        super.onStart();
      mAuth.addAuthStateListener(mAuthListener);
    }

    private void startSignIn (){
        String email = mEmailField.getText().toString();
        String password =mPasswordField.getText().toString();

        if (TextUtils.isEmpty(email)||TextUtils.isEmpty(password)){
            Toast.makeText(signin.this,"fiels are empty",Toast.LENGTH_LONG).show();
        }


        else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()) {
                        Toast.makeText(signin.this, "sign prob", Toast.LENGTH_LONG).show();
                    }

                }


            });

        }
    }
}