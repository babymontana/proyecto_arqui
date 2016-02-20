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
public class Revista {
    
    private ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    
    public Articulo getArticulo(int i){
        return articulos.get(i);
    }
    
}
