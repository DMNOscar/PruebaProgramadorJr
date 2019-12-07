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
    Location localizacion;
    private double latitud=0, longitud=0;
    private static final int REQUEST_CODE = 1;
    private static final String PERMISOS[] = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabActivityMapa = findViewById(R.id.fabMapa);


        fabActivityMapa.setOnClickListener(this);


/*        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISOS, REQUEST_CODE);
                return;
            }
        }*/



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case  R.id.fabMapa:

                Toast.makeText(this, "Buscando Ubicacion", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LocalizacionActivity.class);
                startActivity(intent);

                break;

        }
    }




}
