package com.example.pruebaprogramadoryapp.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.pruebaprogramadoryapp.Interface.InterfaceRecycler;
import com.example.pruebaprogramadoryapp.Modelo.Usuario;
import com.example.pruebaprogramadoryapp.R;

import java.util.Calendar;

import static android.icu.text.DateTimePatternGenerator.PatternInfo.OK;
import static androidx.core.content.ContextCompat.checkSelfPermission;

public class FragmentoA extends Fragment implements View.OnClickListener {

    private EditText edtNombre, edtAnioNacimiento,edtApellido, edtAnimalFavorito, edtUrl, edtMesNacimiento,edtDiaNacimiento;
    private Usuario usuario;
    private AppCompatButton btnEnviar;
    private static InterfaceRecycler varInterfaceRecycler;
    private Calendar calendario = Calendar.getInstance();
    private int horaActual, horasRestantes, HORAS_DIA=24, anioActual,edadUsuario;

    private static final int REQUEST_CODE = 1;
    private static final String PERMISOS[] = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};



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
        edtAnioNacimiento = view.findViewById(R.id.edtAnioNacimiento);
        edtMesNacimiento = view.findViewById(R.id.edtMesNacimiento);
        edtDiaNacimiento = view.findViewById(R.id.edtDiaNacimiento);
        edtAnimalFavorito = view.findViewById(R.id.edtAnimal);
        edtUrl = view.findViewById(R.id.edtUrl);
        btnEnviar = view.findViewById(R.id.btnEnviar);

        edtNombre.setText("Oscar");
        edtApellido.setText("Martinez");
        edtAnioNacimiento.setText("1993");
        edtMesNacimiento.setText("06");
        edtDiaNacimiento.setText("26");
        edtAnimalFavorito.setText("Gato");
        edtUrl.setText("https://www.purina.es/gato/purina-one/sites/g/files/mcldtz1856/files/2018-06/Mi_gato_no_come%20%282%29.jpg");


        horaActual =calendario.get(Calendar.HOUR_OF_DAY);
        anioActual=calendario.get(Calendar.YEAR);

        horasRestantes =  HORAS_DIA - horaActual;

        btnEnviar.setOnClickListener(this);
        
        VerificarPermisos();

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnEnviar:

               if(edtNombre.getText().length() > 0 && edtApellido.getText().length() > 0 &&
                   edtDiaNacimiento.getText().length() > 0 && edtMesNacimiento.getText().length() > 0
                   && edtAnioNacimiento.getText().length() > 0 && edtAnimalFavorito.getText().length() > 0 && edtUrl.getText().length() > 0){

                   // Calculamos la edad de usuario
                   if(edtAnioNacimiento.getText().length() == 4){
                       edadUsuario = anioActual - Integer.parseInt(edtAnioNacimiento.getText().toString());

                       usuario = new Usuario(edtNombre.getText().toString(),edtApellido.getText().toString(),String.valueOf(edadUsuario),edtAnimalFavorito.getText().toString(),edtUrl.getText().toString());


                       varInterfaceRecycler.ActualizarRecycler(usuario,horasRestantes);
                   }else {
                       Toast.makeText(getContext(), "verifica que el año de nacimiento tenga el siguiete formato: aaaa", Toast.LENGTH_SHORT).show();

                   }



                }else {

                   Toast.makeText(getContext(), "Aun hay campos vacios", Toast.LENGTH_SHORT).show();

               }


                break;

        }
    }


    private void VerificarPermisos(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(getContext(),Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(getContext(),Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), PERMISOS, REQUEST_CODE);
                return;
            }
        }

    }

    public static void ActualizarRecyclerView(InterfaceRecycler interfaceRecycler){

        varInterfaceRecycler = interfaceRecycler;

    }





}
