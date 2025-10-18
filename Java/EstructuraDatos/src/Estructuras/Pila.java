/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author crist
 */
public class Pila<T> {
        
    // Por que "T"?
    // T es un PARAMETRO DE TIPO, actua como un MARCADOR DE POSICION para un tipo de dato
    // que se especificara mas adelante. Supongamos que es como una "plantilla"
    // Resulta muy util porque nos brinda seguridad de tipos, es decir, solo permitira almacenar
    // datos del tipo que se especifico
    // No necesariamente se tiene que llamar T, solo es por buena practica, con "T" nos referimos a "Type"
    // Por ejemplo, en un map usariamos <K,V> K = Key, V = Value :))
    
    // Clase interna Nodo, especial para nuestra pila
    private static class Nodo<T> {
        T dato;
        Nodo<T> sig;
        
        Nodo(T dato){
            this.dato = dato;
            this.sig = null; // ant(?
        }
    }
    
    // Atributos
    
    private Nodo<T> cima;
    private int tam;
    public Pila(){
        tam = 0;
        this.cima = null;
    }
    
    // Metodos
    
    public boolean empty(){
        return this.cima==null;
    }
    
    public void push(T dato){
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        // El nuevo nodo depe apuntar a la cima antigua
        nuevoNodo.sig=this.cima;
        // Actualizamos la cima con el nuevo nodo
        this.cima = nuevoNodo;
        this.tam++;
    }
    
    public T pop(){
        if(empty()){
            throw new IllegalStateException("La pila esta vacia");
        }
        
        T datoDevuelto = this.cima.dato;
        
        this.cima = this.cima.sig;
        this.tam--;
        return datoDevuelto;
    }
    
    public T peek(){
        if(empty()){
            throw new IllegalStateException("La pila esta vacia");
        }
        return this.cima.dato;
    }
    
    public int size(){return this.tam;}
    
    
    
}
