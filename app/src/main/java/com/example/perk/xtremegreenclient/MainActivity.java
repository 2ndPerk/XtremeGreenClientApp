package com.example.perk.xtremegreenclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //when button clicked to change activity
    public void onClick(View v){
        int num = 10;
        double[] x = randomArray(num);
        double[] y = randomArray(num);
        Arrays.sort(x);
        chooseGraph(x, y ,num);
    }

    // Displays graph corresponding to button clicked (e.g., humidity)
    public void chooseGraph(double[] x, double[] y, int num){
        Intent intent = new Intent(this, ViewGraph.class);
        intent.putExtra("X_AXIS_ARRAY", x);
        intent.putExtra("Y_AXIS_ARRAY", y);
        intent.putExtra("NUM_DATA_POINTS", num);
        startActivity(intent);
    }


    //random array generation for test
    public double[] randomArray(int num){
        double[] r = new double[num];
        for(int i = 0; i<num; i++){
            r[i] = Math.random()*10;
        }
        return r;
    }

}


