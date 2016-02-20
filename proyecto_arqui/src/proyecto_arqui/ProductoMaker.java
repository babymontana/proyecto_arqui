/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arqui;

/**
 *
 * @author Emmanuel
 */
public class ProductoMaker {
    
    private Libro libro;
    private Revista revista;
    private AudioLibro audioLibro;
    
    private BuilderLibro builderLibro = new BuilderLibro();
    private BuilderRevista builderRevista = new BuilderRevista();
    private BuilderAudioLibro builderAudioLibro = new BuilderAudioLibro();
    
    public Libro generarLibro(){
        this.libro = builderLibro.builtLibro();
        return this.libro;
    }
    
    public Revista generarRevista(){
        this.revista= builderRevista.builtRevista();
        return this.revista;
    }
    
    public AudioLibro generarAudioLibro(){
        this.audioLibro=builderAudioLibro.builtAudiolibro();
        return this.audioLibro;
    }
    
}
