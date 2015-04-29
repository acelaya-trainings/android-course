package com.alejandrocelaya.location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main extends ActionBarActivity {

    private LocationManager locationManager;
    private LocationListener locationListener;
    private TextView longitudTxt;
    private TextView latitudTxt;
    private TextView precisionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        longitudTxt = (TextView) findViewById(R.id.longitud);
        latitudTxt = (TextView) findViewById(R.id.latitud);
        precisionTxt = (TextView) findViewById(R.id.precision);
        Button b = (Button) findViewById(R.id.activar);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLocation();
            }
        });
    }

    private void startLocation() {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        displayLocation(location);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                displayLocation(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            @Override
            public void onProviderEnabled(String provider) {}
            @Override
            public void onProviderDisabled(String provider) {}
        };
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                30000,
                0,
                locationListener
        );
    }

    private void displayLocation(Location location) {
        if (location != null) {
            longitudTxt.setText(String.format("Longitud: %s", String.valueOf(location.getLongitude())));
            latitudTxt.setText(String.format("Latitud: %s", String.valueOf(location.getLatitude())));
            precisionTxt.setText(String.format("Precision: %s", String.valueOf(location.getAccuracy())));
        } else {
            longitudTxt.setText("NO HAY DATOS");
            latitudTxt.setText("NO HAY DATOS");
            precisionTxt.setText("NO HAY DATOS");
        }
    }

}
