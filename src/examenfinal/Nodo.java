/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinal;

/**
 *
 * @author kimel
 */
public class Nodo {
   //Variables para guardar información 
   private int numero;
   private String palabra;
   //Enlace entre nodos
   private Nodo siguiente;
   
   //Constructor de la clase
   public Nodo(){
       this.numero = 0;
       this.palabra = null;
       this.siguiente = null;
   }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
   
   
}
