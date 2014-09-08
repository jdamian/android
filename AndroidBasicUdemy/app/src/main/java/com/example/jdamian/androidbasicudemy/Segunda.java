package com.example.jdamian.androidbasicudemy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by jdamian on 08/09/2014.
 */
public class Segunda extends Activity {

    String nuevoValor = "no ingreso datos";
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_activity);

        textview = (TextView) findViewById(R.id.texto);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            nuevoValor = extras.getString("valor");
            textview.setText(nuevoValor);
        }
    }
}
