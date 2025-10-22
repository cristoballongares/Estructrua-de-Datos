/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructuradatos;

import javax.swing.JOptionPane;
import Estructuras.Polinomio;

/**
 *
 * @author crist
 */
public class ProgramaPolinomio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opt = 0;
        
        Polinomio p = new Polinomio();
        
        String msg = "Operaciones: \n"
                + "1.- Agregar monomios\n"
                + "2.- Mostrar polinomio\n"
                + "3.- Derivar polinomio\n"
                + "4.- Salir\n"
                + "Escriba el numero de la operacion:";
        
        do{
            
            opt=Integer.parseInt(JOptionPane.showInputDialog(msg));
            
            switch(opt){
                case 1: 
                    
                    int t = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de monomios a agregar"));
                    for(int i=1;i<=t;i++){
                        int a = Integer.parseInt(JOptionPane.showInputDialog("("+i+") Ingresa el coeficiente del monomio"));
                        int e=1;
                        do{
                            e = Integer.parseInt(JOptionPane.showInputDialog("("+i+") Ingresa el exponente del monomio"));
                        }while(e==0);
                        p.insertarMonomio(a, e);
                    }
                    break;
                
                case 2: p.mostrarPolinomio(); break;
                
                case 3: p.derviacion(); break;
            }
            
            
        }while(opt!=4);
        
    }
    
}
