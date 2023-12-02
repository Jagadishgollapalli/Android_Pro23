package com.example.savethestarve;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Set;

public class RecieveActivity extends AppCompatActivity {

    TextView userDetailsTextView;
    EditText selectDonor;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recieve);

        userDetailsTextView = findViewById(R.id.userDetailsTextView);
        selectDonor = findViewById(R.id.selectDonor);
        submitBtn = findViewById(R.id.submitBtn);

        updateTextView();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedDonor = selectDonor.getText().toString().trim();

                if (!selectedDonor.isEmpty()) {
                    removeSelectedDonor(selectedDonor);
                } else {
                    Toast.makeText(RecieveActivity.this, "Please enter a donor name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateTextView() {
        SharedPreferences sharedPreferences = getSharedPreferences("DonorDetails", MODE_PRIVATE);
        Set<String> donorSet = sharedPreferences.getStringSet("donorSet", new HashSet<>());

        if (!donorSet.isEmpty()) {
            StringBuilder userDetailsStringBuilder = new StringBuilder();
            for (String userDetails : donorSet) {
                userDetailsStringBuilder.append(userDetails).append("\n\n");
            }
            userDetailsTextView.setText(userDetailsStringBuilder.toString());
        } else {
            userDetailsTextView.setText("No Donors found at this moment");
        }
    }

    private void removeSelectedDonor(String selectedDonor) {
        SharedPreferences sharedPreferences = getSharedPreferences("DonorDetails", MODE_PRIVATE);
        Set<String> donorSet = sharedPreferences.getStringSet("donorSet", new HashSet<>());

        boolean donorFound = false;
        Set<String> updatedDonorSet = new HashSet<>();

        for (String donorDetails : donorSet) {
            String[] userDetailsArray = donorDetails.split("\n");
            if (userDetailsArray.length > 0) {
                String donorNameLine = userDetailsArray[0];
                if (donorNameLine.startsWith("Name: ")) {
                    String donorName = donorNameLine.substring(6); // Extract the donor name
                    if (donorName.equals(selectedDonor)) {
                        donorFound = true;
                    } else {
                        updatedDonorSet.add(donorDetails);
                    }
                }
            }
        }

        if (donorFound) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putStringSet("donorSet", updatedDonorSet);
            editor.apply();

            updateTextView();
            selectDonor.setText("");
            Toast.makeText(this, "Donor removed successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Donor not found in the list", Toast.LENGTH_SHORT).show();
        }
        }
}
