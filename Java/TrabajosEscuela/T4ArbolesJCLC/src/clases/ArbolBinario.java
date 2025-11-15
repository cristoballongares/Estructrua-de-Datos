package clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author crist
 */
public class ArbolBinario {
    private NodoArbol raiz;
    
    public ArbolBinario(){
        raiz = null;
    }
    
    public void insertar(Object obj){
        if(raiz==null) raiz = new NodoArbol(obj);
        else raiz.insertar(obj);
    
    }    
    
    private void preorden(NodoArbol nodo){
        if(nodo == null) return;
            System.out.printf("%s ", nodo.dato); // Raiz
            preorden(nodo.izq);
            preorden(nodo.der);
    }
    
    public void preorden(){
        System.out.println("Preorden: ");
        this.preorden(raiz);
        System.out.println("");
    }
    
    private void postorden(NodoArbol nodo){
        if(nodo == null) return;
            preorden(nodo.izq);
            preorden(nodo.der);
            System.out.printf("%s ", nodo.dato); // Raiz
    }
    
    public void postorden(){
        System.out.println("Post orden: ");
        this.postorden(raiz);
        System.out.println("");
    }
    
    private void inorden(NodoArbol nodo){
        if(nodo == null) return ;
            preorden(nodo.izq);
            System.out.printf("%s ", nodo.dato); // Raiz
            preorden(nodo.der);
    }
    
    public void inorden(){
        System.out.println("Inorden: ");
        this.inorden(raiz);
        System.out.println("");
    }
    
    
    private void mostrar(NodoArbol nodo, int profundidad){
        int i;
        for(i=0;i<profundidad;i++){
            System.out.print("\t");
        }
        if(nodo==null){
            System.out.println("└─> " + nodo);
            return ;
        }
        System.out.printf("└─> %s\n", nodo.dato); // esta es la raiz
        mostrar(nodo.izq, profundidad+1);
        mostrar(nodo.der, profundidad+1);

    }
    
    public void mostrar(){
        System.out.println("Arbol por niveles");
        this.mostrar(raiz,0);
    }
    
    private int altura(NodoArbol nodo){
        if(nodo==null) return 0;
        if(isLeaf(nodo)) return 1;
        return 1+Math.max(altura(nodo.izq), altura(nodo.der));
    }
    
    public int altura(){
        return altura(raiz);
    }

    protected NodoArbol eliminar(NodoArbol raizSub, Object dato) throws Exception{
        if(raizSub == null){
            throw new Exception("Dato no encontrado");
        } else if(dato.toString().compareTo(raizSub.dato.toString())<0){
            NodoArbol iz;
            iz =eliminar(raizSub.izq,dato);
            raizSub.izq = iz; 
        } else if(dato.toString().compareTo(raizSub.dato.toString())>0){
            NodoArbol de;
            de =eliminar(raizSub.der,dato);
            raizSub.der = de; 
        } else { // yeii, porfin nuevo datooo
            NodoArbol q;
            q = raizSub;
            if(q.izq==null) // Caso 1
                raizSub = q.der;
            else if(q.der == null)
                raizSub = q.izq; // caso 2
            else{
                q = reemplazar(q);
            }
            q = null;
        }
        return raizSub;
    }
    
    public void eliminar(Object valor) throws Exception{
        raiz = eliminar(raiz,valor);
    }
    
    private NodoArbol reemplazar(NodoArbol act){
        NodoArbol sucesor,padre;
    
        padre = act;
        sucesor = act.izq;
        
        while(sucesor.der!=null){
            padre = sucesor;
            sucesor = sucesor.der;
        }
        
        act.dato = sucesor.dato;
        if(padre == act) padre.izq=sucesor.izq;
        else padre.der = sucesor.izq;
        return sucesor;
    
    }
    
    public int peso(){
        return peso(raiz);
    }
    
    private int peso(NodoArbol s){
        if(s==null) return 0;
        if(isLeaf(s)) return 1;
        return 1+peso(s.izq)+peso(s.der);
    }
    
    public boolean isRoot(NodoArbol nodo){
        return raiz==nodo;
    }
   
    public boolean isLeaf(NodoArbol nodo){
        return nodo.izq==null && nodo.der==null;
    }
   
    public boolean isInternal(NodoArbol nodo){
        return !isLeaf(nodo);
    }
    
    @Override
    public String toString(){
        return ""+raiz;
    }
    
    public void recorrer(){
        this.preorden();
        this.postorden();
        this.inorden(); 
    }
    
    
}
