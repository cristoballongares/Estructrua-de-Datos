
package pilas;

import java.util.Stack;

/**
 *
 * @author Noemí
 */
public class Expresion {
    String infija;
    
    public Expresion(String infija){
        this.infija = infija;
    }

    public String getInfija() {
        return infija;
    }

    public void setInfija(String infija) {
        this.infija = infija;
    }

    @Override
    public String toString() {
        return "Expresion{" + "infija=" + infija + '}';
    }
   
    public String esCorrecta(){
        return isMatch()?"La expresion es correcta":"ERROR en la expresion";
    }
    
    private boolean isMatch(){
        String expresion = infija;
        Stack <Character> stack = new Stack();
        
        for (int i=0; i < expresion.length(); i++){
            char ch = expresion.charAt(i);
            switch(ch){
                case '(':
                case '[':
                case '{': stack.push(ch);
                            break;
                case ')':
                    if (stack.isEmpty()){
                        System.out.println("ERROR: Falta un (");
                        return false;
                    } else if (stack.peek().toString().charAt(0) != '('){
                        stack.pop();
                        System.out.println("ERROR: Se esperaba un (");
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (stack.isEmpty()){
                        System.out.println("ERROR: Falta una {");
                        return false;
                    } else if (stack.peek().toString().charAt(0) != '{'){
                        stack.pop();
                        System.out.println("ERROR: Se esperaba un {");
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;    
                case ']':
                    if (stack.isEmpty()){
                        System.out.println("ERROR: Falta un [");
                        return false;
                    } else if (stack.peek().toString().charAt(0) != '['){
                        stack.pop();
                        System.out.println("ERROR: Se esperaba un [");
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;    
            } // Fin del switch
        } // fin del for
        if (!stack.isEmpty()){
            System.out.println("ERROR: Demasiados símbolos abiertos");
            return false;
        }
        return true;
    }
    
} // Fin de la clase Expresion
