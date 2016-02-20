/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arqui;
import java.util.*;
/**
 *
 * @author Emmanuel
 */
public class BuilderLibro {
    
    public Libro builtLibro(Libro libro, ArrayList<Integer> listaCapitulos){
        Libro copiaLibro = new Libro() ;
        ArrayList<Capitulo> capitulos = new ArrayList<>();
        copiaLibro.setNombre(libro.getNombre());
        for (Integer i : listaCapitulos) {
            
            capitulos.add(libro.getCapitulo(i));
        }
        copiaLibro.setCapitulos(capitulos);
        
        return copiaLibro;
    }
    
}
