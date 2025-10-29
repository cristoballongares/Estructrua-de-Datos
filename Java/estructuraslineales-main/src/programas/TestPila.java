/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programas;

import javax.swing.JOptionPane;
import pilas.Pila;

/**
 *
 * @author Noemí
 */
public class TestPila {
    public static void main(String[] args) {
        Pila <Character> pila = new Pila();
        String texto = JOptionPane.showInputDialog(null, 
                "Ingrese una cadena");
        char []array = texto.toCharArray();
        for(char c : array){
            pila.push(c);
        }
        String reverse = "";
        while (!pila.isEmpty()){
            System.out.println("En la pila hay " + pila.size() + " datos." + 
                        "\n" + pila + "\n");
            reverse += pila.pop();
        }
        System.out.println("En la pila hay " + pila.size() + " datos." + 
                        "\n" + pila);
        System.out.println("Cadena invertida: " + reverse);
    }
}
