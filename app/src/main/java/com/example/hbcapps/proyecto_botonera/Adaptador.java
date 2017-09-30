package com.example.hbcapps.proyecto_botonera;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


//Esta es nuestra clase adaptador, aca personalizaremos nuestros elementos a ser mostrados en el gridview
public class Adaptador extends BaseAdapter {

    //El adaptador debe tener un contexto, la referencia de nuestro layout personalizado y la lista de elementos
    private Context context;
    private int layout;
    private ArrayList<ElementosGUI> Elementos;

    //Este es el constructor de nuestra clase adaptador, su funcion es asignar los valores anteriormente mencionados
    public Adaptador(Context context, int layout, ArrayList<ElementosGUI> Elementos){
        this.context = context;
        this.layout = layout;
        this.Elementos = Elementos;
    }

    //Este metodo hace que se dibujen solo los elementos que se encuentran en nuestra lista
    @Override
    public int getCount() {
        return this.Elementos.size();
    }

    //Este metodo no lo he utilizado, basta con solo sobreescribirlo
    @Override
    public Object getItem(int position) {
        return null;
    }

    //Este metodo es igual que el anterior xD
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //Este es el mas importante, el objetivo de este metodo es crear nuestros objetos personalizados y
    //mandarlos a nuestro layout principal
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup)
    {
        //Creamos una nueva vista con el valor que nos entrega el convertView
        View v = convertView;

        //Esto nos permite inflar nuestras vistas, http://www.mhjaso.com/blog/inflater/
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.gridviewgui, null);

        //En esta linea estamos creando un objeto tipo ElementosGUI con nombre elemento_actual
        //Estamos obteniendo el elemento actual por la posicion ej: Elementos.get(0); esto nos retorna un objeto,
        //Este objeto contiene la referencia de la imagen del campeon, el nombre del campeon y el sonido
        ElementosGUI elemento_actual = Elementos.get(position);

        //Obtenemos el nombre del campeon con el objeto creado anteriormente mediante el metodo getNombre()
        //Este metodo se encuentra ElementosGUI.java
        String NombreActual = elemento_actual.getNombre();
        //Obtenemos de la misma forma la referencia de la imagen actual
        final int imgActual = elemento_actual.getImagen();
        //Obtenemos de la misma forma el sonido actual
        final int sonidoActual = elemento_actual.getSonido();

        //Traemos las vistas creadas desde nuestro layout
        TextView Nombre = (TextView) v.findViewById(R.id.txtchamp/*<-Esto es una referencia*/);
        ImageButton imagen = (ImageButton) v.findViewById(R.id.imgbtnfoto);

        //Asignamos el nombre al campeon en el textView
        Nombre.setText(NombreActual);
        //Asignamos la imagen al campeon con la referencia
        imagen.setImageResource(imgActual);

        //Cuando se haga click en la imagen se reproducira el sonido actual
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mpsonido = new MediaPlayer().create(context, sonidoActual);
                mpsonido.start();
            }
        });

        //Retornamos nuestra vista
        return v;
    }
}
