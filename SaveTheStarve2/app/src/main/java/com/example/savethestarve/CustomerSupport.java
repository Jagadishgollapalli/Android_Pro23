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

    }

}
