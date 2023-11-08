package com.example.savethestarve;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerSupport extends AppCompatActivity {

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText messageEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer);

        nameEditText = findViewById(R.id.name);
        emailEditText = findViewById(R.id.email);
        messageEditText = findViewById(R.id.message);
        submitButton = findViewById(R.id.submit);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customerName = nameEditText.getText().toString();
                String customerEmail = emailEditText.getText().toString();
                String customerMessage = messageEditText.getText().toString();

                boolean dataSentToServer = sendDataToServer(customerName, customerEmail, customerMessage);

                if (dataSentToServer) {

                    Toast.makeText(CustomerSupport.this, "Data submitted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle errors or show an error message
                    Toast.makeText(CustomerSupport.this, "Failed to submit data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean sendDataToServer(String name, String email, String message) {

        return true;
    }
}




