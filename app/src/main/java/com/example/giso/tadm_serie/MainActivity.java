package com.example.giso.tadm_serie;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText num;
    TextView display;
    Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num=findViewById(R.id.num);
        display = findViewById(R.id.display);
        calc=findViewById(R.id.btnserie);
        //final String numero = num.getText().toString();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,
                            "Ingresa un numero", Toast.LENGTH_SHORT).show();
                }
                else{
                    AsyncTarea asyncTarea = new AsyncTarea();
                    asyncTarea.execute(Integer.parseInt(num.getText().toString()));
                }
            }
        });
    }

    private class  AsyncTarea extends AsyncTask<Integer, Integer,Boolean> {
        String resultado="0\n1\n";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Integer... params) {
            int n1 = 0;
            int n2 = 1;
            int aux;
            int limite = params[0];
            int i=1;
            while ((i) <= limite) {
                aux = n1;
                n1 = n2;
                n2 = aux + n1;
                i++;
                resultado += n2+"\n";
            }
            return true;
        }
        private void UnSegundo() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            display.setText(resultado);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(MainActivity.this,
                    "O_O",Toast.LENGTH_SHORT).show();
        }
    }
}
