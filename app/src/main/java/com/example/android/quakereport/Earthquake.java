package com.example.android.quakereport;

public class Earthquake {

    private String mCity;

    private String mTime;

    private String mMag;

    public Earthquake(String City, String Time,String Mag) {
       mCity = City;
       mMag = Mag;
       mTime = Time;
    }


    public String getCity() {
        return mCity;
    }

    public String getTime() {
        return mTime;
    }

    public String getMag() {
        return mMag;
    }


}
