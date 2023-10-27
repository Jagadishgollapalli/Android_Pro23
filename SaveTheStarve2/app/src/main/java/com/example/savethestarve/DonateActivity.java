package com.example.savethestarve;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DonateActivity extends MainActivity {

    EditText name;
    EditText address;
    EditText description;
    EditText phoneNumber;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate);
        try{
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

                    if(userName.isEmpty() || userAddress.isEmpty() || userDescription.isEmpty() || userMobile.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Enter all inputs", Toast.LENGTH_LONG).show();
                    }else{
                        name.setText("");
                        address.setText("");
                        description.setText("");
                        phoneNumber.setText("");
                        Toast.makeText(getApplicationContext(),"Details submitted successfully", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }catch(Exception e){

        }
    }
}