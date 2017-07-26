package com.example.perk.xtremegreenclient;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest extends MainActivity {

    public static final String Prefs_Name  = "XtremeGreenPref";


    //Shared Preferences Setup
    SharedPreferences values = getSharedPreferences(Prefs_Name, 0);
    SharedPreferences.Editor valuesEditor = values.edit();
    FirebaseDatabase fbDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myDatabase = fbDatabase.getReference("GreenhouseVariables");

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        //test that ranges detection is correct
        assertTrue(!testRange(4.0,5.0,10.0));
       // assertEquals("com.example.perk.xtremegreenclient", appContext.getPackageName());
    }

    @Test
    public void doesGraph(){
        onView(withId(R.id.humButton)).perform(click());
        assertNotNull(onView(withId(R.id.sampleGraph)));
    }


}