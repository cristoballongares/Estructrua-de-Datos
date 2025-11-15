package clases;
/**
 *
 * @author crist
 */
public class NodoArbol {

    protected Object dato;
    protected NodoArbol izq;
    protected NodoArbol der;
    
    public NodoArbol(Object dato){
        this.dato = dato;
        izq = null;
        der = null;
    }
    
    public NodoArbol(NodoArbol izq, Object dato, NodoArbol der){
        this.izq = izq;
        this.dato = dato;
        this.der = der;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoArbol getIzq() {
        return izq;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public NodoArbol getDer() {
        return der;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }
    
    @Override
    public String toString(){
        return ""+dato+"("+izq+" , "+der+")";
    }
    
    public void insertar(Object obj){
        if(obj.toString().compareTo(this.dato.toString())<0){
            if(this.izq==null){ // Significa que el subarbol esta vacio
                this.izq = new NodoArbol(obj);
            } else { // Continuamos recorriendo el subarbol izquierdo 
                izq.insertar(obj);
            }
        } else if(obj.toString().compareTo(this.dato.toString())>0){
            if(der==null){
                this.der = new NodoArbol(obj);
            } else { // recorremos el subarbol derecho
                der.insertar(obj);
            }
        }
    }
    
}
