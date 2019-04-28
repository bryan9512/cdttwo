package com.example.cdttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Search extends AppCompatActivity {
    Button tomain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        tomain = (Button)findViewById(R.id.search_place_ok);

        Intent intent = new Intent(Search.this, MainActivity.class);
        startActivity(intent);

    }
}
