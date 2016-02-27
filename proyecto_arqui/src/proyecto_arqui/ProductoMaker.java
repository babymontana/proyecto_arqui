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
public class ProductoMaker {
    
    private Producto producto;
   
    
    private BuilderProducto builderProducto = new BuilderProducto();
   
   
    public Producto generarProducto(Producto p, ArrayList<Integer> lista){
        this.producto = builderProducto.builtProducto(p, lista);
        return this.producto;
    }
    
   
    
}
