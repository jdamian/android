package com.example.jdamian.androidbasicudemy;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MyActivity extends Activity implements View.OnClickListener{

    TextView tv1, tv2 , tv3;
    EditText editText;
    Button boton;
    String texto;
    CheckBox ch1,ch2;
    Spinner spinner;
    ListView listview;
    String[] valores=new String[]{"manzana","pera","naranja","limon","uva","mango","fresa","papaya","melon","sandia","guayaba","durazno","mandarina","pera","banana","nispero","pacay","sandia"};
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        editText = (EditText) findViewById(R.id.edittext);
        boton = (Button) findViewById(R.id.button);
        tv1 = (TextView) findViewById(R.id.textview1);
        tv2 = (TextView) findViewById(R.id.textview2);
        tv3 = (TextView) findViewById(R.id.textview3);
        ch1 = (CheckBox) findViewById(R.id.chk1);
        ch2 = (CheckBox) findViewById(R.id.chk2);
        spinner = (Spinner) findViewById(R.id.spinner);
        listview = (ListView) findViewById(R.id.listview);
        imagen = (ImageView)findViewById(R.id.imagen);


        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.meses, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,valores);
        listview.setAdapter(adaptador);

        boton.setOnClickListener(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv3.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                texto = editText.getText().toString();
                tv2.setText(texto);

                Toast.makeText(getApplicationContext(),"Esto es un mensaje en TOAST",Toast.LENGTH_SHORT).show();

                if (ch1.isChecked()==true){
                    tv1.setText("Buenos dias Lady");
                }
                if (ch2.isChecked()==true){
                    tv1.setText("Buenos dias Joven");
                }
                break;
            case R.id.bt_abrir:
                texto = editText.getText().toString();
                Intent intent = new Intent(getBaseContext(),Segunda.class);
                intent.putExtra("valor",texto);
                startActivity(intent);
                break;
        }
    }
}
