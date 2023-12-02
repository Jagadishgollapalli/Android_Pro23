package com.example.savethestarve;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;

import java.util.ArrayList;

public class RatingActivity extends AppCompatActivity {

    private EditText editTextRating;
    private Button submitRatingButton;
    private ListView listViewRatings;
    private ArrayList<UserRating> userRatingsList;
    private ArrayAdapter<UserRating> ratingsAdapter;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference ratingsRef;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating);

        editTextRating = findViewById(R.id.editTextRating);
        submitRatingButton = findViewById(R.id.submitRatingButton);
        listViewRatings = findViewById(R.id.listViewRatings);
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        userRatingsList = new ArrayList<>();
        ratingsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userRatingsList);
        listViewRatings.setAdapter(ratingsAdapter);

        if (currentUser == null) {
            // User not logged in, handle appropriately
            Toast.makeText(RatingActivity.this, "User not logged in", Toast.LENGTH_SHORT).show();
            // Redirect or prompt to log in
        } else {
            String userId = currentUser.getUid();
            ratingsRef = FirebaseDatabase.getInstance().getReference("user_ratings").child(userId);
            ratingsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                    userRatingsList.clear(); // Clear existing ratings
                    for (com.google.firebase.database.DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        UserRating userRating = snapshot.getValue(UserRating.class);
                        userRatingsList.add(userRating);
                    }
                    ratingsAdapter.notifyDataSetChanged(); // Notify adapter after updating the list
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle errors if any
                }
            });
        }

        submitRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ratingText = editTextRating.getText().toString().trim();
                if (!ratingText.isEmpty()) {
                    int rating = Integer.parseInt(ratingText);
                    if (rating >= 1 && rating <= 10) {
                        if (currentUser != null) {
                            String userId = currentUser.getUid();
                            UserRating userRating = new UserRating(userId, rating);
                            String key = ratingsRef.push().getKey();
                            if (key != null) {
                                ratingsRef.child(key).setValue(userRating, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                        if (databaseError == null) {
                                            editTextRating.setText(""); // Clear the EditText
                                        } else {
                                            Toast.makeText(RatingActivity.this, "Failed to submit rating", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        } else {
                            Toast.makeText(RatingActivity.this, "User not logged in", Toast.LENGTH_SHORT).show();
                            // Redirect or prompt to log in
                        }
                    } else {
                        Toast.makeText(RatingActivity.this, "Please enter a rating between 1 and 10", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RatingActivity.this, "Please enter a rating", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
