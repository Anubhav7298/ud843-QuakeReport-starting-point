package com.example.android.quakereport;

public class Earthquake {

    private String mCity;

    private long mTime;

    private String mMag;

    public Earthquake(String City, long Time, String Mag) {
       mCity = City;
       mMag = Mag;
       mTime = Time;
    }


    public String getCity() {

        String []arr = mCity.split("of",2);
        arr[0] = arr[0] + " of ";
        return arr[0];
    }

    public String getSplitCity() {

        String []arr = mCity.split("of",2);
        return arr[1];
    }

    public long getTime() {
        return mTime;
    }

    public String getMag() {
        return mMag;
    }


}
