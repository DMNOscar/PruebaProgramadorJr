package com.example.pruebaprogramadoryapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap googleMap;
    private Marker rutaMarker;
    private  double latitudDir,longitudDir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng sydney = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marcador"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }


    public void Marcador (){

        LatLng posicionRuta = new LatLng(latitudDir, longitudDir);

        rutaMarker = googleMap.addMarker(new MarkerOptions() //EN ESTA PARTE SE DIBUJA UN NUEVO MARCADOR EN EL MAPA.
                .position(posicionRuta)
                .title("Estas aqui")
                .draggable(true).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marcador)));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posicionRuta, 17));

    }
}
