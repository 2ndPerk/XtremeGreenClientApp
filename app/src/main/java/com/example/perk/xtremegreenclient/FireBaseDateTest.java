package com.example.perk.xtremegreenclient;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by micha on 2017-07-05.
 */

public class FireBaseDateTest {
    private FirebaseDatabase database;
    //private DatabaseReference myDatabase = database.getReference();
    private ValueEventListener postListener;

    public FireBaseDateTest() {
        database = FirebaseDatabase.getInstance();
        postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println(dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

    };
}
