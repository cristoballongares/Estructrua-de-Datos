/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programas;

import Estructuras.ArbolBinario;

/**
 *
 * @author crist
 */
public class TestArbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArbolBinario a = new ArbolBinario();
        
        for (String arg : args) {
            a.insertar(arg);
        }
        
        System.out.println(""+a);
        a.mostrar();
        System.out.println(a.altura());
        
        
        a.inorden();
        a.postorden();
        a.preorden();
        
    }
    
}
