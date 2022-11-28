package com.assignment.remeberlocation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.Inflater;

public class HomeActivity extends AppCompatActivity {

    ArrayList<LocationModel> locationsList= new ArrayList<>();
    RecyclerView locationRecyclerView;
    LocationRecyclerAdapter locationRCVAdapter;
    int locationCount= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Objects.requireNonNull(getSupportActionBar()).hide();

        locationRecyclerView= findViewById(R.id.locationRecyclerView);

        locationRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button addBtn= findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText locationNameField= findViewById(R.id.locationNameField);
                EditText locationDescField= findViewById(R.id.locationDescField);

                if(locationNameField.getText().toString().isEmpty() || locationDescField.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter all fields!", Toast.LENGTH_LONG).show();
                }
                else {
                        String name= locationNameField.getText().toString();
                        String desc= locationDescField.getText().toString();

                        locationsList.add(new LocationModel(name, desc));

                        locationRCVAdapter.notifyItemInserted(locationsList.size() - 1);
                        locationRecyclerView.scrollToPosition(locationsList.size() - 1);

                }
            }
        });

        locationRCVAdapter= new LocationRecyclerAdapter(this, locationsList);
        locationRecyclerView.setAdapter(locationRCVAdapter);

    }
}