/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Stack;

/**
 *
 * @author Noemí
 */
public class Expresion {
    String infija;

    public Expresion(String infija) {
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
        return "infija=" + infija;
    }
    
    
    private boolean isMatch() {	
		String expresion = infija;
                Stack <Character> stack = new Stack(); 
		for(int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			switch(ch) {	
				case '(' :
					stack.push(ch);
					break;
				case '[' : 
					stack.push(ch);
					break;
				case '{' : 
					stack.push(ch);
					break;
				case ')' :
					if(stack.isEmpty()) {
						System.out.println("La coincidencia de soporte falló");
						return false;
					}else if(stack.peek().toString().charAt(0) != '(' ) {					
							stack.pop();	
							System.out.println("La coincidencia de soporte falló");
							return false;
						  }else {
								 stack.pop();
							  }	
					break;
				case ']' :
					if(stack.isEmpty()) {
						System.out.println("La coincidencia de soporte falló");
						return false;
					}else if(stack.peek().toString().charAt(0) != '[' ) {					
							stack.pop();	
							System.out.println("La coincidencia de soporte falló");
							return false;
						  }else {
							 stack.pop();
						  }	
					break;
				case '}' :
					if(stack.isEmpty()) {
						System.out.println("La coincidencia de soporte falló");
						return false;
					}else if(stack.peek().toString().charAt(0) != '{' ) {					
							stack.pop();
							System.out.println("La coincidencia de soporte falló");
							return false;
						  }else {
								 stack.pop();
							  }	
					break;
				}		
			}
		// La pila no está vacía después del procesamiento de caracteres
		if(!stack.isEmpty()) {
			System.out.println("Error en la expresión");
			return false;
		}		
		//System.out.println("The corchetes coinciden con éxito ");
		return true;
	}
	// Algoritmo de prioridad de símbolo aritmético
	private boolean isPriority(char a, char b) {
		if(a == '(' || a == '[' || a == '{') return true;
		//if(b == '(' || b == '[' || b == '{' ) return false;
		
		if(b == '*' || b == '/' || b == '%')
			return false;
		else if(a == '*' || a == '/' || a == '%')
			return true;
			else return !(b == '+' || b == '-');
		
	}
	// Algoritmo de infijo a sufijo
	private String convertir() {
		String curString = infija;
                String posfija="";
                Stack <Character> stack = new Stack(); 
		for(int i = 0; i < curString.length(); i++) {
			char t = curString.charAt(i);
			if(t >= 48 && t <= 57 || t >= 65 && t <= 90 || t >= 97 && t <= 122 ) {
				// Salida digital directa
				System.out.print(t);
                                // concatenar en posfija
                                posfija += t;
			}else if((t == ')' || t == ']' || t == '}') && !stack.isEmpty()) {
					   // Cuando la parte superior de la pila no es ‘(’, pop la pila y la salida
						while(!stack.isEmpty() && 
                                                        stack.peek().toString().charAt(0) != '(' && 
                                                        stack.peek().toString().charAt(0) != '[' && 
                                                        stack.peek().toString().charAt(0) != '{'){
							posfija += stack.peek(); 
							System.out.print(stack.pop());
						}
						// Hasta que la parte superior de la pila sea ‘(’
						if(!stack.isEmpty()) 
							stack.pop();			
			  		}else {// Operador o ‘(’
			  			// Cuando la pila no está vacía y la prioridad de t es menor que el elemento superior de la pila, salga de la pila y salga, y luego t se empujará a la pila
			  			while(!stack.isEmpty() && 
                                                        stack.peek().toString().charAt(0) != '(' && 
                                                        !isPriority(t, stack.peek().toString().charAt(0))) {
			  				
                                                        posfija += stack.peek(); 
			  				System.out.print(stack.pop());
			  				
			  			}
			  			stack.push(t);
			  			
			  		}
		}
		while(!stack.isEmpty()) {
                        posfija += stack.peek(); 
			System.out.print(stack.pop());
		}
		System.out.println();
                return posfija;
	}
        
        public String convertirAPosfijo(){
            if(this.isMatch())
		return convertir();
            return "Error";
        }
    
}
