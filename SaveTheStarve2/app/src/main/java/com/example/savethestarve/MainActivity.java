package com.example.savethestarve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView navigationButton = findViewById(R.id.cardDonate);
        navigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Create an Intent to navigate to the destination activity
                    Intent intent = new Intent(
                            MainActivity.this, DonateActivity.class);

                    // Start the destination activity
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        });
        CardView navigationButto = findViewById(R.id.cardReceive);
        navigationButto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Create an Intent to navigate to the destination activity
                    Intent intent = new Intent(
                            MainActivity.this, RecieveActivity.class);

                    // Start the destination activity
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();

                }

            }
        });


        CardView navigationButton1 = findViewById(R.id.aboutusButton);
        navigationButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(
                            MainActivity.this, AboutUs.class);
                    startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        });
        CardView navigationButtons = findViewById(R.id.customerButton);
        navigationButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(
                            MainActivity.this, CustomerSupport.class);
                    startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();

                }

            }
        });
    }
}