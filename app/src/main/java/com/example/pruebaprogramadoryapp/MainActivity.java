package com.example.pruebaprogramadoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fabActivityMapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fabActivityMapa = findViewById(R.id.fabMapa);

        fabActivityMapa.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case  R.id.fabMapa:

                Intent intent = new Intent(this, MapaActivity.class);
                startActivity(intent);

                break;

        }
    }
}
