package com.example.hbcapps.proyecto_botonera;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    private Button Gallo;
    private Button Caballo;
    private Button Perro;
    private Button Leon;
    private Button Vaca;

    private MediaPlayer mpGallo;
    private MediaPlayer mpCaballo;
    private MediaPlayer mpPerro;
    private MediaPlayer mpLeon;
    private MediaPlayer mpVaca;

    private ArrayList<ElementosGUI> Elementos;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        gridView =(GridView) findViewById(R.id.gridview);

        Elementos = new ArrayList<ElementosGUI>();
        Elementos.add(new ElementosGUI(R.drawable.boton, "Gallo",R.raw.gallo));
        Elementos.add(new ElementosGUI(R.drawable.boton, "Caballo",R.raw.caballo));
        Elementos.add(new ElementosGUI(R.drawable.boton, "Perro",R.raw.perro));
        Elementos.add(new ElementosGUI(R.drawable.boton, "Leon",R.raw.leon));
        Elementos.add(new ElementosGUI(R.drawable.boton, "Vaca",R.raw.vaca));

        Gallo = (Button) findViewById(R.id.btnGallo);
        Caballo = (Button) findViewById(R.id.btnCaballo);
        Perro = (Button) findViewById(R.id.btnPerro);
        Leon = (Button) findViewById(R.id.btnLeon);
        Vaca = (Button) findViewById(R.id.btnVaca);

        Gallo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gallo.setText("Reproduciendo");
                mpGallo = MediaPlayer.create(Main3Activity.this,R.raw.gallo);
                Gallo.setClickable(false);
                mpGallo.start();
                //Un toast para ver como va
                Context context = getApplicationContext();
                CharSequence text = "Reproduciendo...";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                mpGallo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Gallo.setClickable(true);
                        Gallo.setText("Gallo");
                        mp.release();
                    }
                });
            }
        });

        Caballo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Caballo.setText("Reproduciendo");
                mpCaballo = MediaPlayer.create(Main3Activity.this,R.raw.caballo);
                Caballo.setClickable(false);
                mpCaballo.start();
                Context context = getApplicationContext();
                CharSequence text = "Reproduciendo...";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                mpCaballo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Caballo.setClickable(true);
                        Caballo.setText("Caballo");
                        mp.release();
                    }
                });
            }
        });

        Perro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Perro.setText("Reproduciendo");
                mpPerro = MediaPlayer.create(Main3Activity.this,R.raw.perro);
                Perro.setClickable(false);
                mpPerro.start();
                Context context = getApplicationContext();
                CharSequence text = "Reproduciendo...";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                mpPerro.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Perro.setClickable(true);
                        Perro.setText("Perro");
                        mp.release();
                    }
                });
            }
        });

        Leon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leon.setText("Reproduciendo");
                mpLeon = MediaPlayer.create(Main3Activity.this,R.raw.leon);
                Leon.setClickable(false);
                mpLeon.start();
                Context context = getApplicationContext();
                CharSequence text = "Reproduciendo...";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                mpLeon.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Leon.setClickable(true);
                        Leon.setText("León");
                        mp.release();
                    }
                });
            }
        });

        Vaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vaca.setText("Reproduciendo");
                mpVaca = MediaPlayer.create(Main3Activity.this,R.raw.vaca);
                Vaca.setClickable(false);
                mpVaca.start();
                Context context = getApplicationContext();
                CharSequence text = "Reproduciendo...";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                mpVaca.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Vaca.setClickable(true);
                        Vaca.setText("Vaca");
                        mp.release();
                    }
                });
            }
        });

        Adaptador adaptador = new Adaptador(this,R.layout.gridviewgui,Elementos);

        gridView.setAdapter(adaptador);
    }
}
