package com.example.pruebaprogramadoryapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebaprogramadoryapp.Adapter.AdapterListaUsuario;
import com.example.pruebaprogramadoryapp.Modelo.Usuario;
import com.example.pruebaprogramadoryapp.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentB extends Fragment {

    private RecyclerView rcvListaUsuario;
    private AdapterListaUsuario adapterListaUsuario;
    private Usuario usuario;

    public static FragmentB getInstance(Usuario usuario){
        FragmentB articuloFragment = new FragmentB();
        Bundle bundle = new Bundle();
        bundle.putParcelable("USUARIO",usuario);
        articuloFragment.setArguments(bundle);
        return  articuloFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b,container,false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            usuario = getArguments().getParcelable("USUARIO");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        if (adapterListaUsuario != null) {
            rcvListaUsuario.setAdapter(adapterListaUsuario);
            rcvListaUsuario.setLayoutManager(new GridLayoutManager(getContext(), 1));


        }else{
            Toast.makeText(getContext(), "No se inicio el adapter", Toast.LENGTH_SHORT).show();

        }

    }



    private void llenadoAdapterLista(int horasRestantes){

        List<Usuario> lista = new ArrayList<>();


        for (int i = 0; i < horasRestantes; i++) {
                lista.add(usuario);

        }


        adapterListaUsuario = new AdapterListaUsuario(lista);
    }
}
