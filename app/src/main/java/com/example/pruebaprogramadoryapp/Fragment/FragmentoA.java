package com.example.pruebaprogramadoryapp.Fragment;

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

import com.example.pruebaprogramadoryapp.Modelo.Usuario;
import com.example.pruebaprogramadoryapp.R;

public class FragmentoA extends Fragment implements View.OnClickListener {

    private EditText edtNombre, edtFechaNacimiento,edtApellido, edtAnimalFavorito, edtUrl;
    private Usuario usuario;
    private AppCompatButton btnEnviar;

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
        edtFechaNacimiento = view.findViewById(R.id.edtAnimal);
        edtUrl = view.findViewById(R.id.edtUrl);
        btnEnviar = view.findViewById(R.id.btnEnviar);

    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;

        switch (view.getId()){

            case R.id.btnEnviar:

                Toast.makeText(getContext(), "Creando Usuario", Toast.LENGTH_SHORT).show();
                usuario.setNombre(edtNombre.getText().toString());
                usuario.setApellidos(edtApellido.getText().toString());
                usuario.setFechaNacimiento(edtFechaNacimiento.getText().toString());
                usuario.setAnimalFavorito(edtAnimalFavorito.getText().toString());
                usuario.setUrlImagen(edtUrl.getText().toString());


                if(usuario != null){
                    Toast.makeText(getContext(), "Enviando Usuario", Toast.LENGTH_SHORT).show();
                    fragment = FragmentB.getInstance(usuario);
                    getActivity().getSupportFragmentManager().beginTransaction().attach(fragment).addToBackStack(null).commit();

                }

                break;

        }
    }
}
