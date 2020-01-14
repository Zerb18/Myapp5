package com.example.myapp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    Button btnToast;
    Button btnNotificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Inicio");

        btnToast = findViewById(R.id.btnToast);
        btnNotificacion = findViewById(R.id.btnNotificacion);

        btnToast.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent (v.getContext(), toast.class);
                startActivity(intent1);
            }
        });

        btnNotificacion.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent (v.getContext(), notificacion.class);
                startActivity(intent2);
            }
        });
    }
}