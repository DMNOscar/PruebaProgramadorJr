package com.example.pruebaprogramadoryapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.jar.Manifest;

public class LocalizacionActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap googleMap;
    private double latitud, longitud;

    private LocationManager locationManager;
    private Location location;


    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacion);


        Toolbar toolbar = findViewById(R.id.toolbar);
       // toolbar.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        obtenerUbicacion(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void obtenerUbicacion(Context context) {
        try {
            //CHECAMOS QUE LOS PERMISOS
            if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                //ACTIVAMOS EL SERVICIO DE UBICACION DEL SISTEMA
                locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

                //VARIABLES
                boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                if(isNetworkEnabled) {
                    //PEDIMOS ACTUALICE LA UBICACION DEL SISTEMA
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0,this );
                    if(locationManager != null) //VERIFICAMOS QUE EL LOCATIONMANAGER SEA DIFERENTE DE NULL
                    {
                        //PEDIMOS LA ULTIMA LOCALIZACION OBTENIDA POR EL SISTEMA.
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        latitud = location.getLatitude();
                        longitud = location.getLongitude();

                        Toast.makeText(context, "Localizado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void onLocationChanged(Location location) {

        latitud = location.getLatitude();
        longitud = location.getLongitude();

        LatLng ubicacionUsuario = new LatLng(latitud, longitud);
        googleMap.addMarker(new MarkerOptions().position(ubicacionUsuario).title("Estas aqui"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacionUsuario,16));

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

        Toast.makeText(this, "onProviderEnabled", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProviderDisabled(String s) {
        Toast.makeText(this, "onProviderDisabled", Toast.LENGTH_SHORT).show();

    }
}
