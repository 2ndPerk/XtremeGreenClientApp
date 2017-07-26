package com.example.perk.xtremegreenclient;

/**
 * Created by micha on 2017-07-05.
 */

public class GreenhouseVariables {

    private String HR, humidity, light, temperature;

    public GreenhouseVariables(){
    }

    public void setHR(String hr){
        HR = hr;
    }

    public void setHumidity(String hum){
        humidity = hum;
    }

    public void setLight(String lit){
        light = lit;
    }

    public void setTemperature(String temp){
        temperature = temp;
    }

    public String getHR(){
        return HR;
    }

    public String getHumidity(){
        return humidity;
    }

    public String getLight(){
        return light;
    }

    public String getTemperature(){
        return temperature;
    }

    @Override
    public String toString(){
        return "Humidity: " + this.humidity + "\n" + "Light: " + this.light + "\n" + "Temperature: " + this.temperature;
    }

}
