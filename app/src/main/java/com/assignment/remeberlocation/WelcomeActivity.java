package com.assignment.remeberlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button toHomeBtn= findViewById(R.id.toHomeBtn);
        toHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome= new Intent(WelcomeActivity.this, HomeActivity.class);
                startActivity(toHome);
            }
        });

    }
}