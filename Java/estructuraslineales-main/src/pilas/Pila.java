package pilas;

import java.util.ArrayList;
import java.util.Arrays;


public class Pila <T>{
    
    private Nodo <T> top;
    private int size;
    
    public Pila(){
        top = null; 
        size = 0;
    }
    
    public boolean isEmpty(){
        return top == null; 
    }
    
    public int size(){
        return size;
    }
    
    public T getTop(){
        if (isEmpty())
            return null;
        return top.getElemento();
    }
       
    public T pop(){
        if (isEmpty())
            return null;
        T elemento = top.getElemento();
        Nodo <T> aux = top.getSiguiente();
        top = aux;
        size--;
        return elemento;
    }
    
    public void push(T elemento){
        Nodo <T> nuevo = new Nodo(elemento, top);
        top = nuevo; 
        size++;
    }
    
    public ArrayList<T> getNodos(){
        ArrayList a = new ArrayList();
        String datos = "" + top;
        String [] arr = datos.split("\n");
        a.addAll(Arrays.asList(arr));
        return a;
    }
    
    public void resetear(boolean op){
        if(op){
            top  = null;
        }
    }
    
    @Override
    public String toString(){
        return "" + top;
    }
    
}
