package com.example.myapp5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class toast extends AppCompatActivity
{

    Button btnToast;

    EditText txtDesplaVertical;
    EditText txtDesplaHorizontal;
    EditText txtTexto;

    int despHorizontal ;
    int despVertical;
    int vertical;
    int horizontal;
    String texto;

    RadioGroup rg;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;

    RadioGroup rg2;
    RadioButton rb4;
    RadioButton rb5;
    RadioButton rb6;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        setTitle("Configurar Toast");

        txtDesplaVertical = findViewById(R.id.edittxtV);
        txtDesplaHorizontal = findViewById(R.id.edittxtH);
        txtTexto = findViewById(R.id.edittxtTitulo);

        rg = findViewById(R.id.rGroup);
        rb1 = findViewById(R.id.rbup);
        rb2 = findViewById(R.id.rbCenter);
        rb3 = findViewById(R.id.rbdown);

        rg2 = findViewById(R.id.rGroup2);
        rb4 = findViewById(R.id.rbLeft);
        rb5 = findViewById(R.id.rbCentro);
        rb6 = findViewById(R.id.rbRight);

        btnToast = findViewById(R.id.btnToast);

        btnToast.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                despHorizontal = Integer.parseInt(txtDesplaHorizontal.getText().toString());
                despVertical = Integer.parseInt(txtDesplaVertical.getText().toString());
                texto = txtTexto.getText().toString();

                vertical = dezplazarVertical(rb1, rb2, rb3);
                horizontal = dezplazarHorizontal(rb4, rb5, rb6);

                Toast t1 = Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG);
                t1.setGravity(vertical | horizontal, despHorizontal, despVertical);

                TextView txt = (TextView) t1.getView().findViewById(android.R.id.message);
                View view = t1.getView();
                t1.show();
            }
        });

    }


    public int dezplazarVertical(RadioButton rb1, RadioButton rb2, RadioButton rb3)
    {

        if (rb1.isChecked())
        {
            vertical = Gravity.TOP;
        }
        else if (rb2.isChecked())
        {
            vertical = Gravity.CENTER;
        }
        else if (rb3.isChecked())
        {
            vertical = Gravity.BOTTOM;
        }

        return vertical;
    }


    public int dezplazarHorizontal(RadioButton rb4, RadioButton rb5, RadioButton rb6)
    {
        if (rb4.isChecked())
        {
            horizontal = Gravity.LEFT;
        }
        else if (rb5.isChecked())
        {
            horizontal = Gravity.CENTER;
        }
        else if (rb6.isChecked())
        {
            horizontal = Gravity.RIGHT;
        }

        return horizontal;
    }
}