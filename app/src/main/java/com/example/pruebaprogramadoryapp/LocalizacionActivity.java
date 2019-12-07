package com.example.pruebaprogramadoryapp;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacion);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        obtenerUbicacion(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

    }

    public void obtenerUbicacion(Context context)
    {
        try
        {
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

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
