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
public class AudioLibro implements Producto {
    
    private ArrayList<Partes> fragmentos = new ArrayList<Partes>();
    
    public Partes getFragmento(int i){
        return fragmentos.get(i);
    }

    

    @Override
    public ArrayList<Partes> getPartes() {
        return this.fragmentos;
    }

    @Override
    public void setPartes(ArrayList<Partes> partes) {
        this.fragmentos=partes;
    }

    
    
}
