package com.example.pruebaprogramadoryapp.Recursos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pruebaprogramadoryapp.R;

public class AlertDialogImagen {

    private TextView txtTitulo;
    private ImageView imgFotoUsuario;
    private Handler handler;

    public AlertDialog crearDialogError(Context context, String urlImagen, String animalFavorito) {


        //Elemento de tipo AlertDialog
        final AlertDialog alertDialogError;
        //necesario par ainflar la vista
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //Inflamos y guardamos la vista del alertdialog
        View view = layoutInflater.inflate(R.layout.item_alertdialog_imagen, null);

        txtTitulo = view.findViewById(R.id.txtvTitulo);
        imgFotoUsuario = view.findViewById(R.id.imgAlertDialog);

        txtTitulo.setText(animalFavorito);
        Glide.with(context).load(urlImagen).into(imgFotoUsuario);

        //Creamos un Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //Enviamos la vista al Builder
        builder.setView(view);

        //Guaradamos el Builder en el alertdialog
        alertDialogError = builder.create();

        handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                alertDialogError.dismiss();


            }
        },5000);


        return alertDialogError;
    }
}


