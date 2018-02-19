package com.example.juanjusue.examenjuanmajusue2t.GPSAdmin;
/**
 * Created by JuanmaJR on 18/02/2018.
 */


import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import android.util.Log;

import com.example.juanjusue.examenjuanmajusue2t.DataHolder.DataHolder;
import com.example.juanjusue.examenjuanmajusue2t.sqllite.Contact;
import com.google.firebase.crash.FirebaseCrash;

import org.json.JSONException;


public class GPSTrackerEvents implements LocationListener {

    GPSTracker gpsTracker;

    public GPSTrackerEvents(GPSTracker gpsTracker){
        this.gpsTracker=gpsTracker;
    }


    ///_________________________SI NUESTRA POSICION CAMBIA, LA ACTUALIZAREMOS EN FIREBASE__________________\\\
    @Override
    public void onLocationChanged(Location location) {

        if(gpsTracker.canGetLocation()){
            Log.v("SecondActivity",location.getLatitude()+"  "+location.getLongitude());
            // FBCoche fbcoche = new FBCoche(2017,"Cochecito","ferrari",gpsTracker.getLatitude(),gpsTracker.getLongitude(),"");


            Contact contact = null;
            try {
                contact = new Contact(DataHolder.jsonObjectTwitter.get("UserName").toString(),location.getLatitude(),location.getLongitude());
            } catch (JSONException e) {
                FirebaseCrash.report(new Exception("Error Contacto"));
            }
            DataHolder.instance.fireBaseAdmin.insertarenrama("/Contacts/0",contact.toMap());
        }
        else{
            gpsTracker.showSettingsAlert();
        }
    }
    ///_____________________________________________________________________________________________________\\\

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