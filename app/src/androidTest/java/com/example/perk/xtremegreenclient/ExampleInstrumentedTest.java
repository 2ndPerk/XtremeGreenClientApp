package com.example.perk.xtremegreenclient;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest extends Activity {

    public static final String Prefs_Name  = "XtremeGreenPref";
    public int rangeValueTemp; // Holder for Range Value


    //Shared Preferences Setup
    SharedPreferences values = getSharedPreferences(Prefs_Name, 0);
    SharedPreferences.Editor valuesEditor = values.edit();
    FirebaseDatabase fbDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myDatabase = fbDatabase.getReference("GreenhouseVariables");

    @Test
    public void useAppContext() throws Exception {
       /* Context appContext = InstrumentationRegistry.getTargetContext();
        GreenhouseVariables tester = new GreenhouseVariables();
        tester.setHR("WhatIsHR");
        tester.setHumidity("1");
        tester.setLight("10");
        tester.setTemperature("1");
        valuesEditor.putInt("lightCheck", 2);
        rangeValueTemp = values.getInt("lightcheck", 0);
        //Test to see if Value we saved is actually being saved
        assertEquals(2, rangeValueTemp);

        myDatabase.child(tester.getHR()).setValue(tester);
        myDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            GreenhouseVariables returnValues = (GreenhouseVariables) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Error.");
            }

            }
        }); */

        //assertTrue(!testRange(4.0,5.0,10.0); kind of a test, but not yet
       // assertEquals("com.example.perk.xtremegreenclient", appContext.getPackageName());
    }

}