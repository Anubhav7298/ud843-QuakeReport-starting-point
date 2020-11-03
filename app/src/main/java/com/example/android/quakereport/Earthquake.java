package com.example.android.quakereport;

public class Earthquake {

    private String mCity;

    private long mTime;

    private int mMag;

    public Earthquake(String City, long Time, int Mag) {
       mCity = City;
       mMag = Mag;
       mTime = Time;
    }


    public String getCity() {
        String S="";
        if(mCity.contains("of")){
        String[] arr = mCity.split("of",2);
        arr[0] = arr[0] + "of";
        S = arr[0];}

        if(mCity.contains("the")){
        String[] arr = mCity.split("the",2);
        arr[0] = arr[0] + "the";
            S = arr[0];}
        return S;
    }

    public String getSplitCity() {
          String S="";
        if(mCity.contains("of")){
        for(int j = 0 ; j < mCity.length() ; j++) {
            if (mCity.charAt(j) == 'o' && mCity.charAt(j + 1) == 'f'){
                S=mCity.substring((j + 2), (mCity.length()));
            break;}
        }}
        if(mCity.contains("the")){
            for(int j = 0 ; j < mCity.length() ; j++) {
                if (mCity.charAt(j) == 't' && mCity.charAt(j + 1) == 'h' && mCity.charAt(j+2)== 'e'){
                    S=mCity.substring((j + 3), (mCity.length()));
                    break;}
            }}

        return S;

    }

    public long getTime() {
        return mTime;
    }

    public int getMag() {
        return mMag;
    }


}
