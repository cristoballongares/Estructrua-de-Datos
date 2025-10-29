/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import clases.Alumno;
import java.util.ArrayList;

/**
 *
 * @author Noemí
 */
public class ListaObjetos {
    public static void main(String[] args) {
        ArrayList lista = new ArrayList();
        
        lista.add("Noemí");
        lista.add(98);
        lista.add(123.5);
        lista.add(345.32f);
        lista.add('z');
        
        lista.add(new Alumno("Noe", 90));
        
        // for each
        lista.forEach((x) -> {
            System.out.print(" " + x);
        });
        System.out.println("");
        
    }
}
