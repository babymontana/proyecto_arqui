/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arqui;

import java.util.ArrayList;

/**
 *
 * @author Emmanuel
 */
public class Productos {

    private ArrayList<Libro> libros = new ArrayList<Libro>();
    private ArrayList<Revista> revistas = new ArrayList<Revista>();
    private ArrayList<AudioLibro> audioLibros = new ArrayList<AudioLibro>();

    private ProductoMaker maker = new ProductoMaker();

    public void agregarLibro(Libro l, ArrayList<Integer> listaCapitulos) {
        this.libros.add(maker.generarLibro(l, listaCapitulos));
    }

    public void agregarRevista(Revista r) {
        this.revistas.add(r);
    }

    public void agregarAudioLibro(AudioLibro a) {
        this.audioLibros.add(a);
    }

    public void rentaProducto() {

    }

    public void verificarVencimiento() {

    }
    
    public void mostrarLibros(){
        for(Libro l: libros){
            System.out.println(l.toString());
        }
    }
}
