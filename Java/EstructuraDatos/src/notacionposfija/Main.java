/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notacionposfija;

import java.util.*;
import Estructuras.Pila; // proud of using it
/**
 *
 * @author crist
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int prioridadDentro(char op){
        return switch (op) {
            case '+','-' -> 1;
            case '*','/' -> 2;
            case '^' -> 3;
            case '(' -> 0;
            default -> -1; // -.-
        };
    }
    
    public static int prioridadFuera(char op){
        return switch (op) {
            case '+','-' -> 1;
            case '*','/' -> 2;
            case '^' -> 4;
            case '(' -> 5;
            default -> -1; // -.-
        };
    }
    
    public static String conversionInPost(String infija){
        String expr = "";
        
        Pila<Character> s = new Pila<>();
        
        for(char v:infija.toCharArray()){
           // 1.- Obtener caracteres
           int x = v;
           if(x>=48 && x<=57) expr+=v; // 2.- Si es un operando, lo pasamos a nuestra expresion postfija
           else if(v=='(') s.push(v);
           else if(v==')'){ // 3.- Si es un operador...
                while(!s.empty() && s.peek()!='('){
                        // Sacar el operador de la cima y pasarlo a la expresion postfija
     //                   System.out.println("Agregando: "+s.peek());
                        expr+=s.pop();
                    }
                 if(!s.empty()) s.pop();
           } else {  
               if(s.size()==0){
                 // 3.1 - Si la pila esta vacia, lo metemos en esta. Regresamos al paso 1
                 s.push(v);
                }
              
                else{
                 // 3.2- Si la pila NO esta vacia
                // La prioridad del operador leido es mayor que la prioridad del operador cima de la pila
                while (!s.empty() && prioridadFuera(v) <= prioridadDentro(s.peek())) {
                // ...saca el operador de la cima y añádelo a la expresión.
                expr += s.pop();
                }
                s.push(v);
             }    
           }
        }
        
        while(!s.empty()){
            // 5.- Si quedean elementos en la pila, pasarlos a la expresion
            expr+=s.pop();
        }
        
        return expr;
        // 6.- Fin del algoritmo
    }
    
    public static void main(String[] args) {
        
        String x ="0123456789";  // 48 - 57 ASCII NUMEROS 
//        for(char a:x.toCharArray()){
//            int b = a;
//            System.out.println(b);
//        }

        System.out.println(conversionInPost("5*(3-(1+2)/3)^2"));

        
    }
    
}
