/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arqui;

import java.util.Date;

/**
 *
 * @author Emmanuel
 */
public class Usuario {
    
    private int id;
    private Visor visor = new Visor();
    private Date fechaRegistro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Visor getVisor() {
        return visor;
    }

    public void setVisor(Visor visor) {
        this.visor = visor;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
    
}
