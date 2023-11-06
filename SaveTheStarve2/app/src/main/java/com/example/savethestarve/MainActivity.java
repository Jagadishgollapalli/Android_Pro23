package com.example.savethestarve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuth auth;
        Button button;
        TextView Textview;
        FirebaseUser user;




            setContentView(R.layout.activity_main);
            auth=FirebaseAuth.getInstance();
            button=findViewById(R.id.logoutbutton);
            //Textview=findViewById(R.id.user_details);
            user=auth.getCurrentUser();

            if(user==null)
            {
                Intent intent= new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
            else {

                //Textview.setText(user.getEmail());
            }
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent= new Intent(MainActivity.this,Login.class);
                    startActivity(intent);
                    finish();

                }
            });

        CardView navigationButton = findViewById(R.id.cardDonate);
        navigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Create an Intent to navigate to the destination activity
                    Intent intent = new Intent(MainActivity.this, DonateActivity.class);

                    // Start the destination activity
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace(); // Log the exception
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
        CardView navigationButtonss = findViewById(R.id.ratingButton);
        navigationButtonss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent in = new Intent(
                            MainActivity.this, Rating.class);
                    startActivity(in);
                } catch (Exception e) {
                    e.printStackTrace();

                }

            }
        });
    }


}