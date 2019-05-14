package com.example.cdttwo;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;

public class Write extends AppCompatActivity implements OnMapReadyCallback {
    final static int myrequestCode=11;

    static Handler han;
    static Handler han2;
    private boolean positionFlag;
    LatLng w;
    public static double xandyx=0;
    public static double xandyy=0;

    @SuppressLint("HandlerLeak")
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

        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.map, mapFragment).commit();
        }

        mapFragment.getMapAsync((OnMapReadyCallback) this);

    }
//onCreate

    public void thrun(){


        Thread thread= new Thread(new Runnable() {
            private boolean positionFlag;
            private void getPoint(String... addr) {
                geo geo = new geo(Write.this, listener);
                geo.execute(addr);
            }

            private geo.OnGeoPointListener listener = new geo.OnGeoPointListener() {
                @Override
                public void onPoint(geo.Point[] p) {
                    int sCnt = 0;
                    for (geo.Point point : p) {

                        if (point.havePoint) sCnt++;
                        final String a= point.toString();
                        double k=  point.x;
                        double d=  point.y;
                        xandyx=point.x;
                        xandyy=point.y;

                        Message msg=han.obtainMessage();
                        Message msg2=han2.obtainMessage();
                        msg.obj=Double.toString(k);
                        msg2.obj=Double.toString(d);
                        han.sendMessage(msg);
                        han2.sendMessage(msg2);



                        Context context = getApplicationContext();
                        CharSequence text = (CharSequence) a;
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();



                    }

                }

                @Override
                public void onProgress(int progress, int max) {

                }
            };
            @Override
            public void run() {
                final EditText editText=(EditText)findViewById(R.id.searchmaptxt);
                final String c=editText.getText().toString();
                getPoint(
                        c

                );


            }


        });

        thread.start();



    }

    @UiThread
    @Override
    public void onMapReady ( @NonNull final NaverMap naverMap){
        final Marker marker1 = new Marker();
        findViewById(R.id.searchmap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thrun();

                han = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        Context context = getApplicationContext();
                        CharSequence text = (CharSequence) msg.obj;
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                    }
                };
                han2 = new Handler() {
                    @Override
                    public void handleMessage(Message msg2) {
                        super.handleMessage(msg2);
                        Context context = getApplicationContext();
                        CharSequence text = (CharSequence) msg2.obj;
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                };

                LatLng k=  new LatLng((double)xandyy, (double)xandyx);

                marker1.setPosition(k);
                marker1.setMap(naverMap);
                naverMap.moveCamera(CameraUpdate.scrollTo(k));



            }



        });



    }
}
