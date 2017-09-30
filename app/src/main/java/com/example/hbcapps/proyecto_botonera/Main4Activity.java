package com.example.hbcapps.proyecto_botonera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    //Creamos una lista de ElementosGUI
    private ArrayList<ElementosGUI> Elementos;
    //Creamos un griview para poder manejarlo desde codigo, https://developer.android.com/guide/topics/ui/layout/gridview.html
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //traer gridview desde la interfaz
        gridView = (GridView) findViewById(R.id.gridview);

        //Añadimos elementos a nuestro arreglo de elementos
        Elementos = new ArrayList<ElementosGUI>();
        Elementos.add(new ElementosGUI(R.drawable.aatrox, "Atrox",R.raw.aatrox));
        Elementos.add(new ElementosGUI(R.drawable.ahri, "Ahri",R.raw.ahri));

        //Instanciamos un nuevo adaptador
        Adaptador adaptador = new Adaptador(this,R.layout.gridviewgui,Elementos);
        //Asignamos al gridview un adaptador
        gridView.setAdapter(adaptador);

        /* El adaptador nos permite personalizar nuestro gridview a nuestra disposicion,
        * Esto nos permite mostrar estos elementos personalizados en forma de matriz*/
    }
}

