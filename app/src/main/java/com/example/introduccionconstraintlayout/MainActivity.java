package com.example.introduccionconstraintlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //para ocultar el tulbar en el aparece el titulo de la pantalla
        getSupportActionBar().hide();
        btnLogin = findViewById(R.id.buttonLogin);

        //ahora si podemos definir el evento click sobre el botton login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, NotasActivity.class);
                startActivity(i);
            }
        });
    }
}
