package com.fromscratch.getlocation;

import android.content.Context;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import android.content.IntentSender;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location!=null){
                    Log.v("a","location is not null");
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    Log.v("latitude", String.valueOf(latitude));
                    Log.v("longitude", String.valueOf(longitude));
                    String latNLong = String.valueOf(latitude) + String.valueOf(longitude);
                    Toast toast = Toast.makeText(getApplicationContext(), latNLong, Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Log.v("a","Location is null");
                    Toast toast = Toast.makeText(getApplicationContext(), "Location null lol", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}

//tes github commit
