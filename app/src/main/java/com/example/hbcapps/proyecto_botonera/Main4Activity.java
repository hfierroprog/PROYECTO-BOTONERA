package com.example.hbcapps.proyecto_botonera;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    //Cremos objetos de tipo Button que se encuentran en nuestra botonera
    private Button Corki;
    private Button Ekko;

    //Creamos objetos media player
    private MediaPlayer mpCorki;
    private MediaPlayer mpEkko;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //Traemos los botones de nuestra interfaz para poder manejarlos desde codigo
        Corki = (Button) findViewById(R.id.btnCorki);
        Ekko = (Button) findViewById(R.id.btnEkko);

        //Una vez que el boton sea clickeado
        Corki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Borramos temporalmente el boton Ekko
                Ekko.setVisibility(View.INVISIBLE);
                //Mientras se escucha el sonido el texto del boton sera Reproduciendo..
                Corki.setText("Reproduciendo..");
                //Asignamos a mpCorki un objeto con nuestro archivo de sonido
                mpCorki = MediaPlayer.create(Main4Activity.this,R.raw.corki);
                //Mientras se este reproduciendo el sonido desactivamos el botn para que no se repita
                Corki.setClickable(false);
                //Lo reproducimos
                mpCorki.start();
                //Esto se ejecutara cuando el audio ya se ha reproducido
                mpCorki.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        //Volver a activar los botones
                        Corki.setClickable(true);
                        Ekko.setVisibility(View.VISIBLE);
                        //Dejamos el texto del boton como estaba
                        Corki.setText("Corki");
                        //Le indica al reproductor que ya lo hemos utilizado, que puede finalizar
                        mp.release();
                    }
                });
            }
        });

        Ekko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Corki.setVisibility(View.INVISIBLE);
                Ekko.setText("Reproduciendo...");

                mpEkko = MediaPlayer.create(Main4Activity.this,R.raw.ekko);
                Ekko.setClickable(false);
                mpEkko.start();
                mpEkko.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Ekko.setClickable(true);
                        Corki.setVisibility(View.VISIBLE);
                        Ekko.setText("Ekko");
                        mp.release();
                    }
                });
            }
        });
    }
}
