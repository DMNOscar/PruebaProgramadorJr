package com.example.pruebaprogramadoryapp.Recursos;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Consulta extends AsyncTask<String, Void, String>{

    private static String URL_PETICION = "http://beta.yappapp.mx/test/json/apps";
    private Context contex;
    ProgressDialog progressDialog;
    public Consulta(Context contex) {
        this.contex = contex;
    }

    @Override
    protected String doInBackground(String... strings) {



        RequestQueue queue = Volley.newRequestQueue(contex);

        StringRequest request = new StringRequest(0, URL_PETICION, new Response.Listener<String>() {
            public void onResponse(String response) {
                if(response != null){

                    Toast.makeText(contex, "Respuesta "+response, Toast.LENGTH_LONG).show();
                    Log.i("peticion",response);
                    progressDialog.dismiss();
                }

            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(contex, "Error "+error.toString(), Toast.LENGTH_LONG).show();
                Log.i("peticion",error.toString());
                progressDialog.dismiss();
            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy(30000, 1, 1.0F));

        queue.add(request);

        return null;
    }

    protected void onPostExecute(String result) {

        progressDialog = new ProgressDialog(contex);
        progressDialog.setTitle("Esto tarda un poco");
        progressDialog.setMessage("Esperando respuesta...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);

        progressDialog.show();


    }


}