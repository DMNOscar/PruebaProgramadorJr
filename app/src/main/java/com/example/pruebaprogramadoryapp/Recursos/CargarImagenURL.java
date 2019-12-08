package com.example.pruebaprogramadoryapp.Recursos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;


import java.io.InputStream;

public class CargarImagenURL extends AsyncTask<String, Void, Bitmap> {
    private  ImageView bmImage;
    private Context context;

    public CargarImagenURL(ImageView bmImage, Context context) {
        this.bmImage = bmImage;
        this.context = context;
    }

    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap bitmap = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Toast.makeText(context, "Error: "+e.toString(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}