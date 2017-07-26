package com.example.perk.xtremegreenclient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class RangeSetterActive extends AppCompatActivity {
    private EditText min, max;
    private Ranges ranges;


    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate (Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.range_setter_layout);

        sharedPref = getSharedPreferences("com.example.perk.xtremegreenclient", Context.MODE_PRIVATE);
        editor = sharedPref.edit();


        ranges= (Ranges) getIntent().getSerializableExtra("Range");

        min= (EditText) findViewById(R.id.Min);
        max= (EditText) findViewById(R.id.Max);



        if(ranges != null)
        {
            min.setText(Double.toString(ranges.getMin()));
            max.setText(Double.toString(ranges.getMax()));
        }
        Intent i = getIntent();
        double[] x = i.getDoubleArrayExtra("X_AXIS_ARRAY");
        double[] y = i.getDoubleArrayExtra("Y_AXIS_ARRAY");
        int num = i.getIntExtra("NUM_DATA_POINTS",-1);
        populateGraph(x,y,num);

    }

  public void onSubmitClick(View v)
    {

        Intent resultIntent = new Intent();
      /*  resultIntent.putExtra("rangeID", ranges.getId());
        ranges.setMin(Double.parseDouble(min.getText().toString()));
        ranges.setMax(Double.parseDouble(max.getText().toString()));
        resultIntent.putExtra("Min", ranges.getMin());
        resultIntent.putExtra("Max", ranges.getMax());*/

        switch (ranges.getId()) {
            case 1:
                editor.putString(getString(R.string.tempmin), min.getText().toString());
                editor.putString((getString(R.string.tempmax)), max.getText().toString());

                break;
            case 2:
                editor.putString((getString(R.string.lightmin)), min.getText().toString());
                editor.putString((getString(R.string.lightmax)), max.getText().toString());
                break;
            case 3:
                editor.putString((getString(R.string.hummin)), min.getText().toString());
                editor.putString((getString(R.string.hummax)), max.getText().toString());
                break;
        }

        setResult(Activity.RESULT_OK, resultIntent);
        editor.commit();
        finish();

    }

    public void onCancelClick(View v)
    {
        Intent resultIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, resultIntent);
        finish();
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
