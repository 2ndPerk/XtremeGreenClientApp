package com.example.perk.xtremegreenclient;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * pretty straight forward thing, takes mins and maxes the user enters and assigns them to the ranges objects
 * Created by Miles on 7/14/2017.
 */

public class RangeSetterActivity extends Activity {
    private EditText min, max;
    private Ranges ranges;

    SharedPreferences sharedPref = getSharedPreferences("com.example.perk.xtremegreenclient", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.range_setter_layout);
        ranges= (Ranges) getIntent().getSerializableExtra("Range");
        min= (EditText) findViewById(R.id.Min);
        max= (EditText) findViewById(R.id.Max);






        if(ranges != null)
        {
            min.setText(Double.toString(ranges.getMin()));
            max.setText(Double.toString(ranges.getMax()));
        }

    }

    public void onSubmitClick(View v)
    {
        ranges.setMin(Double.parseDouble(min.getText().toString()));
        ranges.setMax(Double.parseDouble(max.getText().toString()));

        switch (ranges.getId()) {
            case 1:
                editor.putString(getString(R.string.tempmin), min.getText().toString());
                editor.putString((getString(R.string.tempmax)), max.getText().toString());
                break;
            case 2:
                editor.putString((getString(R.string.lightmin)), min.getText().toString());
                editor.putString((getString(R.string.lightmin)), max.getText().toString());
                break;
            case 3:
                editor.putString((getString(R.string.hummin)), min.getText().toString());
                editor.putString((getString(R.string.hummax)), max.getText().toString());
                break;
        }

        editor.commit();
        finish();

    }

    public void onCancelClick(View v)
    {
        finish();
    }
}
