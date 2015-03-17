package com.example.uriel.calcularamortizacion;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Definimos el intent para pasar informacion
        final Intent informacion = new Intent(this,Resultado.class);

        //Definimos los objetos de los cuales obtendremos los datos.
        final EditText txtMonto= (EditText)findViewById(R.id.txtMonto);
        final EditText txtTasa= (EditText)findViewById(R.id.txtTasa);
        final EditText txtPeriodos= (EditText)findViewById(R.id.txtPeriodos);
        Button boton = (Button)findViewById(R.id.btnCalcular);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                informacion.putExtra("monto", txtMonto.getText().toString());
                informacion.putExtra("tasa", txtTasa.getText().toString());
                informacion.putExtra("periodos", txtPeriodos.getText().toString());

                startActivity(informacion);

            }
        });






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
