package com.example.perk.xtremegreenclient;

import java.io.Serializable;

/**
 * Created by Miles on 7/14/2017.
 */

public class Ranges implements Serializable {
    private double min, max;
    private int id;  //1 == temp 2 == light 3 == hum

    public Ranges() {}
    public Ranges (double min, double max, int id) {
        this.min = min;
        this.max = max;
        this.id= id;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
