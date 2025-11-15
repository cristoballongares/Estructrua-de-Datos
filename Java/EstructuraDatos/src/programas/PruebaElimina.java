/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programas;

import Estructuras.ArbolBinario;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class PruebaElimina {

    private static final String[] arr = {
        "Cris", "Belen", "Raul", "Brayan", "Kevin", "Salva", "Diego"
    };
    
 
    
    public static void main(String[] args) {
        
        ArbolBinario a = new ArbolBinario();
        for(String s: arr){
            a.insertar(s);
            System.out.println("A= "+a);
        }
        a.inorden();

        String nom = "FIN";
        do{
            try{
                nom = JOptionPane.showInputDialog("Eliminiacion", "Ingresa un nombre");
                if(nom.compareTo("FIN")!=0){
                    a.eliminar(nom);
                    System.out.println("A= "+a);
                }
            } catch(Exception e){
                System.out.println("Error "+e.getMessage());
            }
        }while(nom.compareTo("FIN")!=0);
    }
    
}
