package com.example.pruebaprogramadoryapp.Recursos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pruebaprogramadoryapp.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AlertDialogImagen {

    private TextView txtTitulo;
    private ImageView imgFotoUsuario;
    private Handler handler;
    URL url ;

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


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            url = new URL(urlImagen);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imgFotoUsuario.setImageBitmap(bmp);

        } catch (MalformedURLException e) {
            Toast.makeText(context, "Error" + e.toString(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(context, "Error Conexion" + e.toString(), Toast.LENGTH_SHORT).show();
        }


      //  Glide.with(context).load(urlImagen).into(imgFotoUsuario);

        //Creamos un Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //Enviamos la vista al Builder
        builder.setView(view);

        //Guaradamos el Builder en el alertdialog
        alertDialogError = builder.create();




        Toast.makeText(context, "Creamdo Alert", Toast.LENGTH_SHORT).show();

        return alertDialogError;
    }
}


