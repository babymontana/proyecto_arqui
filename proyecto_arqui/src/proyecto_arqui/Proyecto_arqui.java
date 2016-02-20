/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arqui;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Proyecto_arqui {
     public static void main(String[] args){
        //Libro 1
        String texto_1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam consequat."; 
        String texto_2 = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident";
        String texto_3 = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae";
        Capitulo c1_a = new Capitulo(texto_1, "ABC", 2);
        Capitulo c1_b = new Capitulo(texto_2, "RST", 3);
        Capitulo c1_c = new Capitulo(texto_3, "XYZ", 2);
        ArrayList<Capitulo> cap_libro1 = new ArrayList<Capitulo>();
        cap_libro1.add(c1_a);
        cap_libro1.add(c1_b);
        cap_libro1.add(c1_c);
        Libro primero = new Libro();
        primero.setNombre("UML");
        primero.setCapitulos(cap_libro1);
        
        //Libro 2
        String texto_4 = "Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime";
        String texto_5 = "Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.";
        String texto_6 = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
        Capitulo c2_a = new Capitulo(texto_4, "IJK", 1);
        Capitulo c2_b = new Capitulo(texto_5, "UVW", 2);
        Capitulo c2_c = new Capitulo(texto_6, "OPQ", 3);
        ArrayList<Capitulo> cap_libro2 = new ArrayList<Capitulo>();
        cap_libro2.add(c2_a);
        cap_libro2.add(c2_b);
        cap_libro2.add(c2_c);        
        Libro segundo = new Libro();
        segundo.setNombre("Cuentos del Pato Donald");
        segundo.setCapitulos(cap_libro2);
        
        
        Productos productos = new Productos();    
        Visor visor = new Visor(productos);     
        
        //Lista de capitulos
        ArrayList<Integer> listaCapitulos = new ArrayList<Integer>();
        listaCapitulos.add(0);
        listaCapitulos.add(2);
        
        productos.agregarLibro(primero, listaCapitulos);
        
        visor.visualizarProductos();
    }
    
}
