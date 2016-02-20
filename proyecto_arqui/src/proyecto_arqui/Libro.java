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
public class Libro {
    
    private ArrayList<Capitulo> capitulos = new ArrayList<Capitulo>();
    
    public Capitulo getCapitulo(int i){
        return capitulos.get(i);
    }
    
    public void longitudTexto(){

    }

}
