package com.example.pruebaprogramadoryapp.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.pruebaprogramadoryapp.Interface.InterfaceRecycler;
import com.example.pruebaprogramadoryapp.Modelo.Usuario;
import com.example.pruebaprogramadoryapp.R;
import com.google.android.gms.maps.GoogleMap;

import java.util.Calendar;

import static android.icu.text.DateTimePatternGenerator.PatternInfo.OK;

public class FragmentoA extends Fragment implements View.OnClickListener {

    private EditText edtNombre, edtFechaNacimiento,edtApellido, edtAnimalFavorito, edtUrl;
    private Usuario usuario;
    private AppCompatButton btnEnviar;
    private static InterfaceRecycler varInterfaceRecycler;
    private Calendar calendario = Calendar.getInstance();
    private int horaActual, horasRestantes, HORAS_DIA=24;

    private int MY_LOCATION_REQUEST_CODE = OK;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtNombre = view.findViewById(R.id.edtNombre);
        edtApellido = view.findViewById(R.id.edtApellido);
        edtFechaNacimiento = view.findViewById(R.id.edtFechaNacimiento);
        edtAnimalFavorito = view.findViewById(R.id.edtAnimal);
        edtUrl = view.findViewById(R.id.edtUrl);
        btnEnviar = view.findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(this);

        horaActual =calendario.get(Calendar.HOUR_OF_DAY);

        horasRestantes =  HORAS_DIA - horaActual;


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                // Permission was denied. Display an error message.
            }
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnEnviar:

              //  usuario = new Usuario(edtNombre.getText().toString(),edtApellido.getText().toString(),edtFechaNacimiento.getText().toString(),edtAnimalFavorito.getText().toString(),edtUrl.getText().toString());


                usuario = new Usuario("Oscar","Martinez","26/06/1993","gato","https://ichef.bbci.co.uk/news/660/cpsprodpb/8536/production/_103520143_gettyimages-908714708.jpg");


                varInterfaceRecycler.ActualizarRecycler(usuario,horasRestantes);

                break;

        }
    }

    public static void ActualizarRecyclerView(InterfaceRecycler interfaceRecycler){

        varInterfaceRecycler = interfaceRecycler;

    }


}
