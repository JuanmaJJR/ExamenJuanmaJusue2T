package com.example.juanjusue.examenjuanmajusue2t.GPSAdmin;
/**
 * Created by JuanmaJR on 18/02/2018.
 */


import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;



public class GPSTrackerEvents implements LocationListener {

    GPSTracker gpsTracker;

    public GPSTrackerEvents(GPSTracker gpsTracker){
        this.gpsTracker=gpsTracker;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}