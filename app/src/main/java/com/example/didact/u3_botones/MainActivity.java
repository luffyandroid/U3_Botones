package com.example.didact.u3_botones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Crear tipos
    Button btnAceptar;
    CheckBox cbMusica, cbDeporte, cbCine;
    RadioGroup rgSexo;
    Spinner spProvincias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Identificar vistas
        btnAceptar = (Button)findViewById(R.id.btn_aceptar);
        cbMusica = (CheckBox)findViewById(R.id.cb_musica);
        cbDeporte = (CheckBox)findViewById(R.id.cb_deporte);
        cbCine = (CheckBox)findViewById(R.id.cb_cine);
        rgSexo = (RadioGroup)findViewById(R.id.rg_sexo);
        spProvincias=(Spinner)findViewById(R.id.sp_provincias);

        String[] provincias = {"Cádiz","Málaga","Almería","Córcoda"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,provincias);

        spProvincias.setAdapter(adaptador);


        //Evento click boton aceptar
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Has clickado aceptar",
                        Toast.LENGTH_LONG).show();
            }
        });



    }//fin onCreate

    //metodo onClick del boton Seleccionar Provincia

    public void seleccionarProvincia(View view){
        //como obtenes el valor seleccionado de una Spinner

        String provinciaSeleccionada = spProvincias.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(),"Provincia: "+provinciaSeleccionada,
                Toast.LENGTH_LONG).show();

    }

    //Evento click boton cancelar
    public void pulsarCancelar(View view){
        //Comprobar elementos checkeados
        String preferencias="";
        if(cbMusica.isChecked()){
            preferencias+="Musica ";
        }
        if(cbCine.isChecked()){
            preferencias+="Cine ";
        }
        if(cbDeporte.isChecked()){
            preferencias+="Deporte ";
        }

        Toast.makeText(getApplicationContext(),"Esta checkeado: "+preferencias,
                Toast.LENGTH_LONG).show();

        //Comprobar elementos radiobuttons
        int id=rgSexo.getCheckedRadioButtonId();

        RadioButton rbSeleccionado = (RadioButton)findViewById(id);
        String textoRbSeleccionado = rbSeleccionado.getText().toString();

        Toast.makeText(getApplicationContext(),"SEXO: "+textoRbSeleccionado,
                Toast.LENGTH_LONG).show();

    }




}//fin MainActivity
