package com.example.perk.xtremegreenclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    //FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference XtremeGreenHR, XtremeGreenHum, XtremeGreenLight, XtremeGreenTemp;
    //Firebase.setAndroidContext(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //XtremeGreen = FirebaseDatabase.getInstance().getReferenceFromUrl("https://xtremegreen-group9.firebaseio.com/");
        XtremeGreenHum = FirebaseDatabase.getInstance().getReference("Humidty");
        //XtremeGreen = XtremeGreen.child("xtremegreen-group9");

        tv1 = (TextView) findViewById(R.id.tempText);
        tv2 = (TextView) findViewById(R.id.lightText);
        tv3 = (TextView) findViewById(R.id.humidityText);

        //final Query humidityQuery = XtremeGreen.orderByChild("Humidity");

        tv3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                XtremeGreenHum.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String obj = (String) dataSnapshot.getValue();
                        tv3.setText(obj);
                    }
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("Error.");
                    }
            });



        };
        /*XtremeGreen.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                dataSnapshot.getChildren().iterator().next().getValue(GreenhouseVariables.class);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

        });

    }}



//comments and stuff for things
