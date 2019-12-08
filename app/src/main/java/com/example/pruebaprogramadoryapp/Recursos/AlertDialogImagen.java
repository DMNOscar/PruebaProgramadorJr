package com.example.pruebaprogramadoryapp.Recursos;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebaprogramadoryapp.R;

import java.io.InputStream;
import java.net.URL;

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
        //
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Cargamos la imagen
        new CargarImagenURL(imgFotoUsuario,context).execute(urlImagen);



        //Creamos un Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //Enviamos la vista al Builder
        builder.setView(view);

        builder.setCancelable(false);

        //Guaradamos el Builder en el alertdialog
        alertDialogError = builder.create();

        //Tiempo para necesario cargarla imagen
        Thread.currentThread();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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


