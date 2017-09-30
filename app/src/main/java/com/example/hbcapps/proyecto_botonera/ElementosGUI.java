package com.example.hbcapps.proyecto_botonera;

/*Esta clase tiene como funcion crear objetos de tipo elementos,
Estos contienen todos los datos que van a ser asignado en nuestra interfaz por cada elemento.
 */


//Creamos nuestra clase en este caso se llama ElementosGui
public class ElementosGUI {
    //En este entero guardamos la referencia de la imagen
    private int Imagen;
    //En este String guardamos el nombre del campeon
    private String Nombre;
    //En este entero guardamos la referencia de el sonido
    private int Sonido;

    //Creamos el metodo constructor que recibe todos los argumentos y los pasa a la clase
    public ElementosGUI(int Imagen, String Nombre,int Sonido){
        this.Imagen = Imagen;
        this.Nombre = Nombre;
        this.Sonido = Sonido;
    }

    //METODOS GET, no se ponen los set por que las referencias no se modifican

    //metodo que nos permite obtener la referencia de la imagen del campeon
    public int getImagen(){
        return Imagen;
    }

    //metodo que nos permite obtener el nombre del campeon
    public String getNombre(){
        return Nombre;
    }

    //metodo que nos permite obtener la referencia de donde se encuenta el sonido
    public int getSonido(){
        return this.Sonido;
    }

}
