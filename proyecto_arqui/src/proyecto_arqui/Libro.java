/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arqui;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Emmanuel
 */
public class Libro {
    
    private String nombre;
    private ArrayList<Capitulo> capitulos = new ArrayList<Capitulo>();
    private Date fechaVencimiento;
    
    public Date getFechaVencimiento(){
        return  this.fechaVencimiento;
    }
    
    public String getFechaString(){
        return  this.fechaVencimiento.getYear()+"-"+(this.fechaVencimiento.getMonth())+"-"+this.fechaVencimiento.getDate();

    }
    
    public void setFecha(Date fechaVencimiento){
        this.fechaVencimiento=fechaVencimiento;
    }
    
    public Capitulo getCapitulo(int i){
        return capitulos.get(i);
    }

    public String getNombre() {
        return nombre;
    }
    
    public void longitudTexto(){
    
    }

    public ArrayList<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(ArrayList<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString(){
        StringBuilder texto = new StringBuilder();
        if(this.capitulos.size()>0){     
        texto.append("\n\nTitulo del libro: " + nombre);
        for(Capitulo c: capitulos){
            texto.append(c.toString());
        }
        }
        return texto.toString();
    }
    
    
    
}
