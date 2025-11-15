/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programas;

import clases.NodoArbol;

/**
 *
 * @author crist
 */
public class T4ArbolesJCLC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NodoArbol a = new NodoArbol("Salva");
        NodoArbol c = new NodoArbol("Kevin");
        NodoArbol b = new NodoArbol(a,"Yo",c);
    
        System.out.println("Nodo a: "+a);
        System.out.println("Nodo b: "+b);
        System.out.println("Nodo c: "+c);
    
        NodoArbol d = new NodoArbol(a,"Maestra",null);
        System.out.println("Nodo d: "+d);
    }
    
}
