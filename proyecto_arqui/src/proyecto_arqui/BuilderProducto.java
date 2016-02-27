/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arqui;

import java.util.ArrayList;

/**
 *
 * @author Emmanuel
 */
class BuilderProducto {

    public Producto builtProducto(Producto p, ArrayList<Integer> Lista) {
        ArrayList<Partes> partes = p.getPartes();
         ArrayList<Partes> auxpartes = new   ArrayList<Partes>();
        for (int i=0; i<partes.size();i++){
            if(Lista.contains(i)){
                auxpartes.add(partes.get(i));
            }
        }
        p.setPartes(auxpartes);
        return p;
    }
    
}
