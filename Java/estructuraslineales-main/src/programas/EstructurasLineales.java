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
 class EstructurasLineales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EstructurasLineales variable = new EstructurasLineales();
        System.out.println("suma = " + variable.suma(3,5));
        System.out.println("resta = " + variable.resta(3,5));
        String cadena = "Ejemplo";
        
    }
    private int suma(int a, int b){
        return a + b;
    }
    private static int resta(int a, int b){
        return a - b;
    }
    
}
