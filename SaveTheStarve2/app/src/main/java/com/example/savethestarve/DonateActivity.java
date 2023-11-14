package com.example.savethestarve;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

        public class DonateActivity extends AppCompatActivity {

                private EditText nameEditText;
                private EditText addressEditText;
                private Button submitButton;
                private List<String> donationList = new ArrayList<>();

                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.donate);

                    nameEditText = findViewById(R.id.editTextText);
                    addressEditText = findViewById(R.id.editTextText3);
                    submitButton = findViewById(R.id.button3);

                    submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name = nameEditText.getText().toString();
                            String address = addressEditText.getText().toString();
                            donationList.add(name + " - " + address);

                            Intent intent = new Intent(DonateActivity.this, RecieveActivity.class);
                            intent.putStringArrayListExtra("donationList", new ArrayList<>(donationList));
                            startActivity(intent);
                        }
                    });
                }
            }
