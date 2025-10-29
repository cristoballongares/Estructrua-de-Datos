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
    
    public void insertarMonomio(int c, int e) {
        Monomio nuevo = new Monomio(c, e);
        if (inicio == null) {
            inicio = fin = nuevo;
            return;
        }
        // Instertamos manteniendo el orden descendente del exponente
        Monomio actual = inicio;
        while (actual != null && actual.exponente > e) actual = actual.der;

        if (actual == null) { // insertar al final
            fin.der = nuevo;
            nuevo.izq = fin;
            fin = nuevo;
        } else if (actual.exponente == e) {
            actual.coeficiente += c; // combinamos monomios con mismo exponente
        } else if (actual == inicio) {
            nuevo.der = inicio;
            inicio.izq = nuevo;
            inicio = nuevo;
        } else {
            nuevo.izq = actual.izq;
            nuevo.der = actual;
            actual.izq.der = nuevo;
            actual.izq = nuevo;
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
        System.out.println("Cabeza: "+fin.coeficiente);
        while(actual!=null){
            System.out.println("Derivando: "+actual.coeficiente+" ^ "+actual.exponente);
            // Multiplicar exponente por el coeficiente
            actual.coeficiente=actual.coeficiente*actual.exponente;
            actual.exponente--;

            Monomio sig = actual.der;
            
            if(actual.exponente == -1) eliminarMonomio(actual);

            actual = sig;
        }
        JOptionPane.showMessageDialog(null, "Polinomio derivado!");
        if(inicio==null){
            JOptionPane.showMessageDialog(null, "El polinomio se quedo sin terminos:(!");
            return ;
        }
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
