package com.example.myapp5;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class notificacion extends AppCompatActivity
{

    private static final String CHANNEL_ID = "canal";

    EditText txtTitulo;
    EditText txtMensaje;
    EditText txtSegundos;

    Button btnNotificacion;

    String titulo;
    String mensaje;
    int segundos;

    PendingIntent pendingIntent;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);
        setTitle("Configurar Notificación");
        createNotificationChannel();

        txtTitulo = findViewById(R.id.edittxtTitulo);
        txtMensaje = findViewById(R.id.txtTexto);
        txtSegundos = findViewById(R.id.txtSegundos);
        btnNotificacion = findViewById(R.id.btnNotificacion);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        pendingIntent = PendingIntent.getActivity(this, 0, getIntent(), 0);

        btnNotificacion.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int segundos = Integer.parseInt(txtSegundos.getText().toString());
                int milisegundos = segundos * 1000;
                Log.i("MilliSeconds",milisegundos + " milisegundos");

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        String titulo = txtTitulo.getText().toString();
                        String mensaje = txtMensaje.getText().toString();

                        Intent resultIntent = new Intent(getApplicationContext(), notificacion.class);
                        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
                        stackBuilder.addNextIntentWithParentStack(resultIntent);
                        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                                .setSmallIcon(R.drawable.game_icon)
                                .setContentTitle(titulo)
                                .setContentIntent(resultPendingIntent)
                                .setContentText(mensaje)
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
                        notificationManager.notify(0, builder.build());
                    }
                }, milisegundos);
            }
        });
    }

    private void createNotificationChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = ("nombre");
            String description = ("descripción");
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}