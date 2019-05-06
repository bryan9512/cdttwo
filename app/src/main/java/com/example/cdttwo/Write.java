package com.example.cdttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Write extends AppCompatActivity {
    final static int myrequestCode=11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        Button datesearch = (Button)findViewById(R.id.searchdate);
        datesearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Write.this,AirCalendarDatePickerActivity.class);
                startActivityForResult(intent,myrequestCode);
            }
        });
    }
}
