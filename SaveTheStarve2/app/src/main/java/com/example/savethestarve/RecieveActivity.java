package com.example.savethestarve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;

public class RecieveActivity extends MainActivity {

    EditText name;
    EditText address;
    EditText selectDonor;
    Button submitBtn;
    TextView userDetailsTextView;
    List<String> userDetailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recieve);
        name = findViewById(R.id.NameET);
        address = findViewById(R.id.AddressET);
        selectDonor = findViewById(R.id.selectDonor);
        submitBtn = findViewById(R.id.submitBtn);
        userDetailsTextView = findViewById(R.id.userDetailsTextView);

        // Retrieve the list from the Intent
        Intent intent = getIntent();
        userDetailsList = intent.getStringArrayListExtra("USER_DETAILS_LIST");


            updateTextView();
            // Rest of your code...


        // Display the list in the TextView


        // Handle selection button click
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedDonor = selectDonor.getText().toString();
                name.setText("");
                address.setText("");
                selectDonor.setText("");
                // Check if the donor exists in the list
                boolean donorFound = false;
                for (String userDetails : userDetailsList) {
                        if (userDetails.contains(selectedDonor)) {
                        userDetailsList.remove(userDetails);
                        donorFound = true;
                        break;
                    }
                }

                if (donorFound) {
                    // Start the DonorActivity
                    Intent donorIntent = new Intent(RecieveActivity.this, DonateActivity.class);
                    startActivity(donorIntent);
                    updateTextView();
                    Toast.makeText(getApplicationContext(), "Donor removed from the list", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Donor not found in the list", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Update the TextView with the modified userDetailsList
    private void updateTextView() {

        if (userDetailsList != null) {
            // Display the list in the TextView
            StringBuilder userDetailsStringBuilder = new StringBuilder();
            for (String userDetails : userDetailsList) {
                userDetailsStringBuilder.append(userDetails).append("\n\n");
            }
            userDetailsTextView.setText(userDetailsStringBuilder.toString());
        } else {
            userDetailsTextView.setText("No Donars found at this moment");
        }
    }
}


