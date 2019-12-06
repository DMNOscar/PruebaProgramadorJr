package com.example.pruebaprogramadoryapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pruebaprogramadoryapp.Modelo.Usuario;
import com.example.pruebaprogramadoryapp.R;

import java.util.List;

public class AdapterListaUsuario extends RecyclerView.Adapter<AdapterListaUsuario.AdapterListaUsuarioHolder>{

    private List<Usuario> listaUsuario;
    private Context context;

    public AdapterListaUsuario(List<Usuario> lista) {

        this.listaUsuario = lista;
    }


    @NonNull
    @Override
    public AdapterListaUsuarioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from( parent.getContext());
        View view = inflater.inflate(R.layout.item_card_datos_usuario, parent, false);

        return new AdapterListaUsuarioHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListaUsuarioHolder holder, int position) {

        holder.txtvNombre.setText(listaUsuario.get(position).getNombre());
        holder.txtvApellidos.setText(listaUsuario.get(position).getApellidos());
        holder.txtvEdad.setText(listaUsuario.get(position).getFechaNacimiento());
        holder.txtvAnimalFavorito.setText(listaUsuario.get(position).getAnimalFavorito());
        Glide.with(context).load(listaUsuario.get(position).getUrlImagen()).into(holder.imgAnimalFavorito);

    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class AdapterListaUsuarioHolder extends RecyclerView.ViewHolder {

        private TextView txtvNombre, txtvApellidos, txtvEdad, txtvAnimalFavorito;
        private ImageView imgAnimalFavorito;

        public AdapterListaUsuarioHolder(@NonNull View itemView) {
            super(itemView);

            txtvNombre = itemView.findViewById(R.id.txtvNombre);
            txtvApellidos = itemView.findViewById(R.id.txtvApellidos);
            txtvEdad = itemView.findViewById(R.id.txtvEdad);
            txtvAnimalFavorito = itemView.findViewById(R.id.txtvAnimalFavorito);
            imgAnimalFavorito = itemView.findViewById(R.id.imgAnimalFavorito);

        }

    }
}
