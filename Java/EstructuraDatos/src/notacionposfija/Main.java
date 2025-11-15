package notacionposfija;

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
        return Character.isLetterOrDigit(c);
    }

    public static boolean esOperador(char c) {
        return "+-*/^".indexOf(c) != -1;
    }

    public static String conversionInPost(String infija) {

        infija = prepararUnarios(infija);

        StringBuilder expr = new StringBuilder();
        Pila<Character> pila = new Pila<>();

        for (char v : infija.toCharArray()) {

            if (v == ' ') continue;

            if (esOperando(v)) {
                expr.append(v);
            }
            else if (v == '(') {
                pila.push(v);
            }
            else if (v == ')') {
                while (!pila.empty() && pila.peek() != '(') {
                    expr.append(pila.pop());
                }
                if (!pila.empty()) pila.pop(); 
            }
            else if (esOperador(v)) {
                while (!pila.empty() && prioridadFuera(v) <= prioridadDentro(pila.peek())) {
                    expr.append(pila.pop());
                }
                pila.push(v);
            }
        }

        while (!pila.empty()) {
            char top = pila.pop();
            if (top != '(') expr.append(top);
        }

        return expr.toString();
    }
    private static String prepararUnarios(String s) {
        StringBuilder r = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-' && (i == 0 || s.charAt(i - 1) == '(')) {
                r.append("0");
            }
            r.append(c);
        }
        return r.toString();
    }


    public static void main(String[] args) {
        System.out.println(conversionInPost("(-b+((b^2)-4*a*c)^(1/2))/(2*a)"));
    }
}
