package notacionposfija;

import java.util.*;
import Estructuras.Pila; // proud of using it
import javax.swing.JOptionPane;
/**
 *
 * @author crist
 */
import Estructuras.Pila;

public class Main {

    public static int prioridadDentro(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            case '(' -> 0;
            default -> -1;
        };
    }

    public static int prioridadFuera(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 4;
            case '(' -> 5;
            default -> -1;
        };
    }

    public static boolean esOperando(char c) {
        return Character.isLetterOrDigit(c); // ahora incluimos letras y numeros
    }

    public static boolean esOperador(char c) {
        return "+-*/^".indexOf(c) != -1;
    }

    public static String conversionInPost(String infija) {
        String expr = "";
        Pila<Character> s = new Pila<>();
        
        for(char v:infija.toCharArray()){
           // 1.- Obtener caracteres
           int x = v;
           if(x>=48 && x<=57) expr+=v;
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

            if (v == ' ') continue; // ignorar espacios

            if (esOperando(v)) {
                expr += v;
            }
            else if (v == '(') {
                s.push(v);
            }
            else if (v == ')') {
                // vaciar hasta el '('
                while (!s.empty() && s.peek() != '(') {
                    expr += s.pop();
                }
                if (!s.empty()) s.pop(); // eliminar el '('
            }
            else if (esOperador(v)) {
                // tratar operadores con prioridad
                while (!s.empty() && prioridadFuera(v) <= prioridadDentro(s.peek())) {
                    expr += s.pop();
                }
                s.push(v);
            }
            else {
                // ignorar caracteres desconocidos
            }
        }

        // vaciar pila (sin meter '(')
        while (!s.empty()) {
            char top = s.pop();
            if (top != '(' && top != ')') expr += top;
        }

        return expr;
    }
    }
    public static void main(String[] args) {
        
           
        
        System.out.println(conversionInPost("(-b+((b^2)-4*a*c)^(1/2))/(2*a)"));
    }
}
