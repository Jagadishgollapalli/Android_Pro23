package com.example.savethestarve;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Set;

public class DonateActivity extends AppCompatActivity {

    EditText name;
    EditText address;
    EditText description;
    EditText phoneNumber;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate);

        name = findViewById(R.id.editTextName);
        address = findViewById(R.id.editTextAddress);
        description = findViewById(R.id.editTextDescription);
        phoneNumber = findViewById(R.id.editTextPhone);
        submit = findViewById(R.id.buttonSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                String userAddress = address.getText().toString();
                String userDescription = description.getText().toString();
                String userMobile = phoneNumber.getText().toString();

                if (userName.isEmpty() || userAddress.isEmpty() || userDescription.isEmpty() || userMobile.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter all inputs", Toast.LENGTH_LONG).show();
                } else {
                    String userDetails = "Name: " + userName +
                            "\nAddress: " + userAddress +
                            "\nDescription: " + userDescription +
                            "\nPhone Number: " + userMobile;

                    saveDonorDetails(userDetails);

                    Toast.makeText(getApplicationContext(), "Details submitted successfully", Toast.LENGTH_LONG).show();

                    name.setText("");
                    address.setText("");
                    description.setText("");
                    phoneNumber.setText("");
                }
            }
        });
    }

    private void saveDonorDetails(String userDetails) {
        SharedPreferences sharedPreferences = getSharedPreferences("DonorDetails", MODE_PRIVATE);
        Set<String> donorSet = sharedPreferences.getStringSet("donorSet", new HashSet<>());
        donorSet.add(userDetails);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("donorSet", donorSet);
        editor.apply();
    }
}
