package programas;

import clases.Persona;

/**
 *
 * @author Noemí
 */
public class TestSecuencia {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Joaquin");
        Persona persona2 = new Persona("Antonio", persona1);
        Persona persona3 = new Persona("Noé", persona2);
        
        System.out.println ("seq1 = " + persona1);
        System.out.println ("seq2 = " + persona2); 
        System.out.println ("seq2 = " + persona3);
    }
    
}
