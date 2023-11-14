package com.example.savethestarve;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class RecieveActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recieve);

        TextView userDetailsTextView = findViewById(R.id.userDetailsTextView);

        // Retrieve the list from the Intent
        Intent intent = getIntent();
        List<String> userDetailsList = intent.getStringArrayListExtra("USER_DETAILS_LIST");

        // Display the list in the TextView
        StringBuilder userDetailsStringBuilder = new StringBuilder();
        for (String userDetails : userDetailsList) {
            userDetailsStringBuilder.append(userDetails).append("\n\n");
        }
        userDetailsTextView.setText(userDetailsStringBuilder.toString());
    }
}






