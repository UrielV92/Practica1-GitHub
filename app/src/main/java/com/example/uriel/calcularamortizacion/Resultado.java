package com.example.uriel.calcularamortizacion;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;


public class Resultado extends ActionBarActivity {

    public TableLayout ty;
    public TableRow tr;

    public TextView numero,saldoInicial, cuotaT, interes, capital, saldoFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        double monto = Double.parseDouble(getIntent().getExtras().getString("monto"));
        double tasa = Double.parseDouble(getIntent().getExtras().getString("tasa"))*0.01;
        int periodos = Integer.parseInt(getIntent().getExtras().getString("periodos"));
        ty=(TableLayout)findViewById(R.id.tabla);
        ty.setColumnStretchable(0,true);

        double cuota;
        DecimalFormat df = new DecimalFormat("#.00");

        cuota=((tasa*(Math.pow((1+tasa),periodos))*monto)/ (Math.pow((1+tasa),periodos)-1));

        df.format(cuota);

        ((TextView)findViewById(R.id.lblMontoCuota)).setText(df.format(cuota));

        int cont=1;
        double auxInteres=0;
        double auxCapital=0;
        double saldofinal=0;

       double auxSaldoinicial=monto;
   for (int i=1; i<= periodos;i++) {

       auxInteres=auxSaldoinicial*tasa;
       auxCapital=cuota-auxInteres;
       saldofinal=auxSaldoinicial-auxCapital;

            tr = new TableRow(this);
            numero = new TextView(this);
            saldoInicial = new TextView(this);
            cuotaT = new TextView(this);
            interes = new TextView(this);
            capital = new TextView(this);
            saldoFinal = new TextView(this);

            numero.setText(""+i+"   ");
            saldoInicial.setText("$"+df.format(auxSaldoinicial)+"   ");
            cuotaT.setText("$"+df.format(cuota)+"  ");
            interes.setText("$"+df.format(auxInteres)+"   ");
            capital.setText("$"+df.format(auxCapital)+"   ");
            saldoFinal.setText("$"+df.format(saldofinal));

            auxSaldoinicial=saldofinal;

            tr.addView(numero);
            tr.addView(saldoInicial);
            tr.addView(cuotaT);
            tr.addView(interes);
            tr.addView(capital);
            tr.addView(saldoFinal);

            ty.addView(tr);
            cont++;

    }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultado, menu);
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
