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
public class AudioLibro {
    
    private ArrayList<Fragmento> fragmentos = new ArrayList<Fragmento>();
    
    public Fragmento getFragmento(int i){
        return fragmentos.get(i);
    }
    
}
