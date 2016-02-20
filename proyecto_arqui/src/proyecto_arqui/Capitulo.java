/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arqui;

/**
 *
 * @author Emmanuel
 */
public class Capitulo {
    
    private String texto;
    private String titulo;
    private int numeroPaginas;
    
    public Capitulo(){}

    public Capitulo(String texto, String titulo, int numeroPaginas) {
        this.texto = texto;
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String toString(){
        StringBuilder texto = new StringBuilder();
        texto.append("\nTitulo Capitulo: " + titulo);
        texto.append("\nNo.Pags: " + numeroPaginas);
        texto.append("\nTexto:\n" + this.texto);
        return texto.toString();
    }
    
    
}
