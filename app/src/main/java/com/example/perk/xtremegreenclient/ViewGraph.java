package com.example.perk.xtremegreenclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.w3c.dom.Text;

import java.util.Arrays;

public class ViewGraph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_graph);
        Intent i = getIntent();
        double[] x = i.getDoubleArrayExtra("X_AXIS_ARRAY");
        double[] y = i.getDoubleArrayExtra("Y_AXIS_ARRAY");
        int num = i.getIntExtra("NUM_DATA_POINTS",-1);
        String name = i.getStringExtra("DATA_TYPE");
        ((EditText)findViewById(R.id.nameText)).setText(name);

        populateGraph(x,y,num);
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
        for(int i = 0; i < num; i++) {
            r[i] = new DataPoint(x[i], y[i]);
        }
        return r;
    }


}
