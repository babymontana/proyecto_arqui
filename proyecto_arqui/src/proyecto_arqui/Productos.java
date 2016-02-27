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

    public void agregarLibro(Producto l, ArrayList<Integer> listaCapitulos) {
        this.libros.add((Libro) maker.generarProducto(l, listaCapitulos));
    }

    public void agregarRevista(Revista r,ArrayList<Integer> listaCapitulos) {
        this.revistas.add((Revista) maker.generarProducto(r, listaCapitulos));
    }

    public void agregarAudioLibro(AudioLibro a,ArrayList<Integer> listaCapitulos) {
         this.audioLibros.add((AudioLibro) maker.generarProducto(a, listaCapitulos));
    }

    
    public String mostrarLibros(){
        String texto="";
        for(Libro l: libros){
            texto+=l.toString();
        }
        
        return texto;
    }
}
