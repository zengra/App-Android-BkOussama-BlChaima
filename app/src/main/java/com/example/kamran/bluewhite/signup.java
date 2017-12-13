package com.example.kamran.bluewhite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import customfonts.MyTextView;

public class signup extends AppCompatActivity
{

    MyTextView sin;
    ImageView sback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        sin = (MyTextView)findViewById(R.id.loginButton);
        sback = (ImageView)findViewById(R.id.sback);
        sback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(signup.this, main.class);
                startActivity(it);

            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(signup.this,Main2Activity.class);
                startActivity(it);
            }

        });
    }
}
