package com.example.savethestarve;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Rating extends MainActivity {

    private EditText editTextName;
    private EditText editTextRating;
    private EditText editTextDescription;
    private Button submitRatingButton;
    private ListView listViewRatings;
    private List<String> ratingsList;
    private ArrayAdapter<String> ratingsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating);

        editTextName = findViewById(R.id.editTextName);
        editTextRating = findViewById(R.id.editTextRating);
        editTextDescription = findViewById(R.id.editTextDescription);
        submitRatingButton = findViewById(R.id.submitRatingButton);
        listViewRatings = findViewById(R.id.listViewRatings);

        // Initialize the ratings list
        ratingsList = new ArrayList<>();

        // Initialize the ratings adapter
        ratingsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ratingsList);

        // Set the adapter to the ListView
        listViewRatings.setAdapter(ratingsAdapter);

        // Set click listener for the Submit button
        submitRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRatingToList();
            }
        });
    }

    private void addRatingToList() {
        String name = editTextName.getText().toString();
        String rating = editTextRating.getText().toString();
        String description = editTextDescription.getText().toString();

        // Check if all fields are not empty
        if (!name.isEmpty() && !rating.isEmpty() && !description.isEmpty()) {
            // Append the name, rating, and description to the list
            ratingsList.add("Name: " + name + ", Rating: " + rating + ", Description: " + description);

            // Notify the adapter that the data set has changed
            ratingsAdapter.notifyDataSetChanged();

            // Optionally, clear the EditTexts after adding the data
            editTextName.setText("");
            editTextRating.setText("");
            editTextDescription.setText("");
        } else {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
    }
}
