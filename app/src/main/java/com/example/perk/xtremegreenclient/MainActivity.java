package com.example.perk.xtremegreenclient;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//comment

public class MainActivity extends AppCompatActivity {

    private TextView tv1, tv2, tv3;
    private Button blight, btemp, bhum;
    private Ranges rangeHum, rangeTemp, rangeLight;

   //FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference XtremeGreenHum, XtremeGreenLight, XtremeGreenTemp;
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



        //I  guess we need shared preferences
       SharedPreferences sharedPref = getSharedPreferences("com.example.perk.xtremegreenclient", Context.MODE_PRIVATE);

       double lightmin = Double.parseDouble(sharedPref.getString(getString(R.string.lightmin),"0.0"));
        double lightmax = Double.parseDouble(sharedPref.getString(getString(R.string.lightmax),"0.0"));
        double tempmin = Double.parseDouble(sharedPref.getString(getString(R.string.tempmin),"0.0"));
        double tempmax = Double.parseDouble(sharedPref.getString(getString(R.string.tempmax),"0.0"));
        double hummin = Double.parseDouble(sharedPref.getString(getString(R.string.hummin),"0.0"));
        double hummax = Double.parseDouble(sharedPref.getString(getString(R.string.hummax),"0.0"));

        //Why is this not in any order?
        int humId = 3;
        int tempId = 1;
        int lightId = 2;


        rangeHum = new Ranges(hummin,hummax,humId);
        rangeLight = new Ranges(lightmin,lightmax,lightId);
        rangeTemp = new Ranges(tempmin,tempmax,tempId);


        //notifications are hard
        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        final NotificationManager noteMan = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);



    /** Just tap the button, and it shows. It takes the value from the firebase reference as a snapshot, and then stores it as a string. Places it as the textObject. Simple.
     * */

                XtremeGreenTemp.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String obj = (String) dataSnapshot.getValue();
                        tv1.setText(obj);
                        if(!testRange(Double.parseDouble(obj.replaceAll("[^\\.0123456789]","")), rangeTemp.getMin(), rangeTemp.getMax()))
                        {
                            Notification n = new Notification.Builder(MainActivity.this)
                                    .setContentTitle("XTREMEGREEEEEEEEN")
                                    .setContentText("heat's in defeat")
                                    .setSmallIcon(R.mipmap.temperature_icon).build();
                            noteMan.notify(1,n);
                        }
                    }

                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("Error.");
                    }
                });

                XtremeGreenLight.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String obj = (String) dataSnapshot.getValue();
                        tv2.setText(obj);
                        if(!testRange(Double.parseDouble(obj.replaceAll("[^\\.0123456789]","")), rangeLight.getMin(), rangeLight.getMax()))
                        {
                           Notification n = new Notification.Builder(MainActivity.this)
                                .setContentTitle("XTREMEGREEEEEEEEN")
                                .setContentText("light ain't right")
                                .setSmallIcon(R.mipmap.light_icon).build();
                            noteMan.notify(2,n);
                        }
                    }

                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("Error.");
                    }
                });

        XtremeGreenHum.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String obj = (String) dataSnapshot.getValue();
                        tv3.setText(obj);
                        if(!testRange(Double.parseDouble(obj.replaceAll("[^\\.0123456789]","")), rangeHum.getMin(), rangeHum.getMax()))
                        {
                            Notification n = new Notification.Builder(MainActivity.this)
                                    .setContentTitle("XTREMEGREEEEEEEEN")
                                    .setContentText("humidity shmidity")
                                    .setSmallIcon(R.mipmap.light_icon).build();
                            noteMan.notify(3,n);
                        }
                    }

                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("Error.");
                    }
                });

        btemp = (Button) findViewById(R.id.temprange2);

        btemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeRangeTemp(rangeTemp);
            }
        });

   /*     blight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeRangeTemp(rangeLight);            }
        });

        bhum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
            changeRangeTemp(rangeHum);
            }
        });*/

    }
    public boolean testRange(double x, double min, double max)
    {
        if(x>=min && x<=max)
            return true;
        else
            return false;
    }

    private void changeRangeTemp(Ranges range) {
        //Intent intent = new Intent(this, RangeSetterActivity.class);// Does not exist yet, make it later
        //intent.putExtra("Range", range);
        //startActivity(intent);
    }

}

