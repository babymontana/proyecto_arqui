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
public class Revista implements Producto{
    
    private ArrayList<Partes> articulos = new ArrayList<Partes>();
    
    public Partes getArticulo(int i){
        return articulos.get(i);
    }

    

    @Override
    public ArrayList<Partes> getPartes() {
        return this.articulos;
    }

    @Override
    public void setPartes(ArrayList<Partes> partes) {
        this.articulos=partes;
    }
    
}
