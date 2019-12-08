package com.example.pruebaprogramadoryapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pruebaprogramadoryapp.Adapter.AdapterListaUsuario;
import com.example.pruebaprogramadoryapp.Interface.InterfaceRecycler;
import com.example.pruebaprogramadoryapp.Modelo.Usuario;
import com.example.pruebaprogramadoryapp.R;
import com.example.pruebaprogramadoryapp.Recursos.AlertDialogImagen;

import java.util.ArrayList;
import java.util.List;

public class FragmentB extends Fragment implements InterfaceRecycler {

    private RecyclerView rcvListaUsuario;
    private AdapterListaUsuario adapterListaUsuario;


    private  List<Usuario> lista = new ArrayList<>();
    private FragmentoA fragmentoA;

    private AlertDialogImagen alertDialog = new AlertDialogImagen();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcvListaUsuario = view.findViewById(R.id.rcvListaUsuario);
        fragmentoA.ActualizarRecyclerView(this);

    }

    private void llenadoAdapterLista(Usuario usuario ,int horasRestantes){

        lista.clear();
        for (int i = 0; i < horasRestantes; i++) {
                lista.add( usuario);
            }
            rcvListaUsuario.setHasFixedSize(true);
            rcvListaUsuario.setLayoutManager(new LinearLayoutManager(getContext()));
            adapterListaUsuario = new AdapterListaUsuario(lista,getContext());
            rcvListaUsuario.setAdapter(adapterListaUsuario);

            alertDialog.crearDialogError(getContext(),usuario.getUrlImagen(), usuario.getAnimalFavorito()).show();

    }

    @Override
    public void ActualizarRecycler(Usuario usuario, int item) {

        llenadoAdapterLista(usuario, item);

    }
}
