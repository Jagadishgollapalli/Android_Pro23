package com.example.savethestarve;

import android.os.Bundle;

public class RecieveActivity extends MainActivity {

    private EditText NameET;
   private EditText AddressET;
   private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recieve);



        NameET = findViewById(R.id.NameET);
        AddressET = findViewById(R.id.AddressET);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = NameET.getText().toString();
                String Address = AddressET.getText().toString();

                String message = "Name: " + Name + "\n Address: " + Address;
                Toast.makeText(RecieveActivity.this, message, Toast.LENGTH_SHORT).show();
            }

        });
    }

    
}