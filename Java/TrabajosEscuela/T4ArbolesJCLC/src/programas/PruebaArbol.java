/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programas;

import clases.ArbolBinario;

/**
 *
 * @author crist
 */
public class PruebaArbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBinario a = new ArbolBinario();
        a.insertar("Cris");
        a.insertar("bomba");
        System.out.println("a: "+a);
        a.insertar("arroz");
        System.out.println("a: "+a);
        a.insertar("Pla");
        System.out.println("a: "+a);
        a.insertar("Verd");
        System.out.println("a: "+a);
        a.insertar("Zap");
        System.out.println("a: "+a);
        a.insertar("Java");
        System.out.println("a: "+a);
        a.insertar("Fula");
        System.out.println("a: "+a);
        
        
        
        a.mostrar();
        
        a.preorden();
        a.postorden();
        a.inorden();
    }
    
}
