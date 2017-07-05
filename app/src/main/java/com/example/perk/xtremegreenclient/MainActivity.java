package com.example.perk.xtremegreenclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//comment

public class MainActivity extends AppCompatActivity {

    private TextView tv1, tv2, tv3;

    private double temp1 = 23.2;
    private double temp2 = 18.9;
    private double temp3 = 34.1;
    private double light1 = 12.0;
    private double light2 = 1.2;
    private double light3 = 2.3;
    private double hum1 = 23.2;
    private double hum2 = 18.7;
    private double hum3 = 15.2;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    //Firebase.setAndroidContext(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tempText);
        tv2 = (TextView) findViewById(R.id.lightText);
        tv3 = (TextView) findViewById(R.id.humidityText);

    }

}




//comments and stuff for things
