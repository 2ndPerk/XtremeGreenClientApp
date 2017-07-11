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

        XtremeGreenTemp = FirebaseDatabase.getInstance().getReference("Tempurature");
        XtremeGreenLight = FirebaseDatabase.getInstance().getReference("Light");
        XtremeGreenHum = FirebaseDatabase.getInstance().getReference("Humidty");


        tv1 = (TextView) findViewById(R.id.tempText);
        tv2 = (TextView) findViewById(R.id.lightText);
        tv3 = (TextView) findViewById(R.id.humidityText);

        //final Query humidityQuery = XtremeGreen.orderByChild("Humidity");
    /** Just tap the button, and it shows. It takes the value from the firebase reference as a snapshot, and then stores it as a string. Places it as the textObject. Simple.
     * */

        tv1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                XtremeGreenTemp.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String obj = (String) dataSnapshot.getValue();
                        tv1.setText(obj);
                    }

                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("Error.");
                    }
                });
            }

            ;
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                XtremeGreenLight.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String obj = (String) dataSnapshot.getValue();
                        tv2.setText(obj);
                    }

                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("Error.");
                    }
                });


            }

        });

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
            }
        });
    }
}
//comments and stuff for things

