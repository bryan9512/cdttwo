package com.example.cdttwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yongbeom.aircalendar.core.AirCalendarIntent;

public class AirCalendarDatePickerActivity extends AppCompatActivity {
    static final int myrequestCode=11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_calendar_date_picker);

        //int dd=5,yyyy=2019,MM=0;
        AirCalendarIntent intent = new AirCalendarIntent(this);
            intent.isBooking(false);
            intent.isSelect(false);
            //intent.setEndDate(yyyy ,MM, dd);
            //intent.setEndDate(yyyy,MM,dd);
            intent.isMonthLabels(false);
            intent.setActiveMonth(3);
            intent.setMaxYear(2030);
            startActivityForResult(intent,myrequestCode);

    }
}
