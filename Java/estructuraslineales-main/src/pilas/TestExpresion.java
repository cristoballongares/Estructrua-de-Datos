package pilas;

import javax.swing.JOptionPane;

/**
 *
 * @author Noemí
 */
public class TestExpresion {
    public static void main(String[] args) {
        String cadena; 
        do{
            cadena = JOptionPane.showInputDialog("Ingrese una expresión");
            Expresion e = new Expresion(cadena);
            
            JOptionPane.showMessageDialog(null, e.esCorrecta());
        }while (cadena.length()!=0);
    }
}
