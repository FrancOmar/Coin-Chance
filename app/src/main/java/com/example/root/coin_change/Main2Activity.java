package com.example.root.coin_change;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tx = (TextView)findViewById(R.id.bienve);

        Intent intent = getIntent();
        Bundle extras;
        extras = intent.getExtras();

        if(extras!=null){
            String dato = extras.getString("Dato");
            tx.setText("Bienvenido "+dato);
        }

    }

    public void cambio(View v){
        EditText n = (EditText)findViewById(R.id.numon);
        TextView pan = (TextView)findViewById(R.id.pantalla);
        String num = n.getText().toString();
        double saldo = Integer.parseInt(num);

        String res = " ";
        int[] moneda = {500, 200,100, 50, 10, 5, 1};
        int [] cambio = Main.calcula(saldo, moneda);
        int rec = cambio.length;
        for(int i = 0; i < rec; i++)
            res = res+"\n"+moneda[i]+" = "+cambio[i]+" unidad(es)";
        pan.setText(res);
    }
    public void volver(View v){
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
