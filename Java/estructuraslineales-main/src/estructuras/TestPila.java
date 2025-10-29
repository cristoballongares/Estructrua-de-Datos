package estructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author Noemí
 */
public class TestPila {
    public static void main(String[] args) {
        Pila <Character> pila = new Pila();
        
        String texto = JOptionPane.showInputDialog(
                "Ingrese una cadena");
        char [] array = texto.toCharArray();
        for (char c : array){
            pila.push(c);
        }
        String reverse="";
        while(!pila.isEmpty()){
            System.out.println(
                    "size="+pila.size()+
                            " " + pila);
            reverse += pila.pop();
        }
        System.out.println(
                    "size="+pila.size()+
                            " " + pila);
        System.out.println("reverse = " + reverse);
    }
}
