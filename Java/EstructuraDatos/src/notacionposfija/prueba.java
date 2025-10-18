/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notacionposfija;

import java.util.Stack;

/**
 *
 * @author crist
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String a = "0123456789+";
            
        Stack<Integer> s = new Stack<>();

        Boolean esNumero = false;
        String number = "";
        for(char x:a.toCharArray()){
            int b = x;
            if(b>=48 && b<=57){ // Es un numero
                number+=Integer.toString(b);
            } else {
                int v = Integer.parseInt(number);
                
                // Que operador es?
            }
        }
        
        
    }
    
}
