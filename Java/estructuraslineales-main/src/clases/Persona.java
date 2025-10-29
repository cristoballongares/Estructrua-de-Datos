package clases;

/**
 *
 * @author Noemí
 */
public class Persona {
    String nombre;
    Persona amigo;  //campo de enlace

    public Persona(String nombre, Persona amigo) {
        this.nombre = nombre;
        this.amigo = amigo;
    }
    
    
    
    public Persona(String nombre){
        this.nombre=nombre;
        amigo=null;
    }
    public Persona(){
        this("anónimo");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return nombre + ", " + amigo;
    }
    
}
