/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class Polinomio{
    
    private static class Monomio{
        
        int coeficiente, exponente;
        Monomio izq, der;
      
        public Monomio(){
            izq=der=null;
        }
        
        public Monomio(int cof, int exp){
            coeficiente = cof;
            exponente = exp;
            izq = null; der = null;
        }
        
        public Monomio(int cof, int exp, Monomio der, Monomio izq){
            coeficiente = cof;
            exponente = exp;
            this.der = der;
            this.izq = izq;
        }
        
    };
    
    Monomio inicio, fin;
    
    public Polinomio(){
        this.inicio = null;
        this.fin = null;
    }
    
    public void insertarMonomio(int c,int e){
        Monomio x = new Monomio(c,e);
        
        if(inicio == null && fin == null){
            inicio=fin=x;
        } else if(fin!=null){
            x.izq=fin;
            x.der=null;
            fin.der=x;
            fin=x;
        }
    }
    
    public void eliminarMonomio(Monomio x){
        
        if(inicio!=null && fin!=null){
            
            // Monomio unico..
            if(x.izq == null && x.der == null){
                inicio=fin=null;
            } 
            // Al inicio del poliniomio
            else if(x.izq == null && x.der!=null){
                inicio = x.der; // Actualizamos la cabeza del Polinomio
                inicio.izq=null;
                x.der=null; // Desvinculamos totalmente el monomio de exponente 0
            }
            // Al final del polinomio
            else if(x.izq !=null && x.der == null){
               fin = x.izq; // Actualizamos el final del polinomio
               fin.der = null; // Desvinculamos totalmente el monomio de exponente 0
               x.izq = null; // Desvinculamos totalmente el monomio de exponente 0
            }
            // En medio de monomios
            else if(x.izq!=null && x.der!=null){
                x.izq.der = x.der; // Actualizamos la referencia derecha del predecesor de x
                x.der.izq = x.izq; // Acturalizamos la referencia izquierda del sucesor de x
                
                x.izq=x.der=null; // Desvinculamos totalmente el monomio del exponente 0
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede eliminar un monomio, la lista esta vacia");
        }
        
    }
    
    public void derviacion(){
        
        // Primero, verificar que la lista no este vacia
        if(inicio == null && fin == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia, no se puede derivar");
            return ;
        }
        
        Monomio actual = inicio;
        
        while(actual!=null){
            // Multiplicar exponente por el coeficiente
            actual.coeficiente=actual.coeficiente*actual.exponente;
            actual.exponente--;  
           
            if(actual.exponente == 0) eliminarMonomio(actual);
            
            actual = actual.der;
        }
        JOptionPane.showMessageDialog(null, "Polinomio derivado!");
        mostrarPolinomio();
    }
    
    public void mostrarPolinomio(){
        String msg = "Polinomio obtenido: \n";
        Monomio actual = inicio;
        if(actual!=null){
            while(actual!=null){
                msg+= "<- "+actual.coeficiente+"^("+actual.exponente+") -> ";
            
                actual = actual.der;
            
            }
        }
        
        JOptionPane.showMessageDialog(null, msg);
    }
    
    
    
}
