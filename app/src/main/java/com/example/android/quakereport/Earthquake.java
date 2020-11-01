package com.example.android.quakereport;

public class Earthquake {

    private String mCity;

    private long mTime;

    private String mMag;

    public Earthquake(String City, long Time,String Mag) {
       mCity = City;
       mMag = Mag;
       mTime = Time;
    }


    public String getCity() {
        return mCity;
    }

    public long getTime() {
        return mTime;
    }

    public String getMag() {
        return mMag;
    }


}
