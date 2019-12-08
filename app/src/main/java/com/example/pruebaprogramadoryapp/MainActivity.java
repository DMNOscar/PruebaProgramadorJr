package com.example.pruebaprogramadoryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fabActivityMapa;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabActivityMapa = findViewById(R.id.fabMapa);
        fabActivityMapa.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case  R.id.fabMapa:

                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

                    Toast.makeText(this, "Buscando Ubicacion", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, LocalizacionActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(this, "El GPS esta Desactivado", Toast.LENGTH_SHORT).show();
                }

                break;

        }
    }




}
