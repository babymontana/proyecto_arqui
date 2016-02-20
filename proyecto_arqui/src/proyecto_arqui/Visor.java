/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arqui;


/**
 *
 * @author Emmanuel
 */
public class Visor {
    
    private Productos productos;

    public Visor(Productos productos) {
        this.productos = productos;
    } 
    
    public void visualizarProductos(){
        productos.mostrarLibros();
    }
    
    public void presentarProductos(){
        
    }
    
}
