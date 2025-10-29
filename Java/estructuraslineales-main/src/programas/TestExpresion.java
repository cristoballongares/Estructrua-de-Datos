/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programas;

/**
 *
 * @author Noemí
 */

import clases.Expresion;
import java.util.Scanner;

public class TestExpresion {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String cadena;
		do {
			System.out.println("Ingrese la expresión:");
			cadena = scanner.nextLine();
                        Expresion exp = new Expresion(cadena);
                        //System.out.println("x = " + cadena.length());
			String posfija = exp.convertirAPosfijo();
                        System.out.println("posfija = " + posfija);
		}while(cadena.length()>0);
		
	}
}


