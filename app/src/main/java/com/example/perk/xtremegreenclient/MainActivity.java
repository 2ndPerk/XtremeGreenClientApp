package com.example.perk.xtremegreenclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
        testPopulate();

    }

    //takes 2 arrays(x and y axis) and the number of total inputs, and populates the graph
    public void populateGraph(double[] x, double[] y, int num) {
        GraphView graph = (GraphView) findViewById(R.id.sampleGraph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataArray(x,y,num));
        graph.addSeries(series);
    }

    //this turns the arrays into data points
    public DataPoint[] dataArray(double[] x, double[] y, int num){
        DataPoint[] r = new DataPoint[num];
        for(int i = 0; i<num; i++) {
            r[i] = new DataPoint(x[i],y[i]);
        }
        return r;
    }

    //test
    public void testPopulate(){
        int num = 5;
        double[] x = randomArray(num);
        double[] y = randomArray(num);
        Arrays.sort(x);
        populateGraph(x,y,num);
    }

    //random array generation for test
    public double[] randomArray(int num){
        double[] r = new double[num];
        for(int i = 0; i<num; i++){
            r[i] = Math.random()*10;
        }
        return r;
    }

    public void seeGraph(int[] x, int[] y, int num){
        Intent intent = new Intent(this, viewGraph.class);

    }

}


