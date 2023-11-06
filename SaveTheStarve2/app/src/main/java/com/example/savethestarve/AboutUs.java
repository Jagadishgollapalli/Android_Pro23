package com.example.savethestarve;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AboutUs extends MainActivity{
    private ImageButton imageButton6;
    private ImageButton imageButton7;
    private ImageButton imageButton8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        imageButton6 = findViewById(R.id.imageButton6);
        imageButton7 = findViewById(R.id.imageButton7);
        imageButton8 = findViewById(R.id.imageButton8);

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFacebookPage();
            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagramPage();
            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTwitterPage();
            }
        });
    }

    private void openFacebookPage() {
        Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/your_facebook_page"));
        startActivity(in);
    }

    private void openTwitterPage() {
        Intent in= new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/your_twitter_page"));
        startActivity(in);
    }

    private void openInstagramPage() {
        Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/your_instagram_page"));
        startActivity(in);
    }
    }


