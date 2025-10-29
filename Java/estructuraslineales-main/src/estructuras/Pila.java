
package estructuras;

import pilas.Nodo;

/**
 *
 * @author Noemí
 */
public class Pila <T> {
    
    private Nodo <T> top;
    private int size;
    
    public Pila(){
        top = null;
        size= 0;
    }

    public boolean isEmpty(){
        return top == null;
    }
    
    public int size(){
        return size;
    }
    
    public T getTop(){
        if(isEmpty()){
            return null;
        }
        return top.getElemento();
    }
    
    public T pop(){
        if(isEmpty()){
            return null;
        }
        T elemento = top.getElemento();
        Nodo <T> aux = top.getSiguiente();
        top = aux;
        //top = top.getSiguiente();
        size--;
        return elemento;
    }
    
    public void push(T elem){
        Nodo <T> nuevo = new Nodo(elem,top);
        top = nuevo;
        size++;
    }
    
    @Override 
    public String toString(){
        return "" + top;
    }
}
