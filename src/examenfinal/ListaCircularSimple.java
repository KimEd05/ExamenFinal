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
public class ListaCircularSimple {
    private Nodo inicio;
    private Nodo fin;
    private int tamaño;
    
    public void Lista(){
        inicio = null;
        fin = null;
        tamaño = 0;
    }

    public boolean ListaVacia(){
        return inicio == null;
    }
    
    public int getTamaño() {
        return tamaño;
    }
      
    public void insertarInicio(int numero, String palabra){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setNumero(numero);
        nuevoNodo.setPalabra(palabra);
        
        if(ListaVacia()){
        inicio = nuevoNodo;
        fin = nuevoNodo;
        fin.setSiguiente(inicio);
        
        } else {
        nuevoNodo.setSiguiente(inicio);
        inicio = nuevoNodo;
        fin.setSiguiente(inicio);
        }
        
        tamaño++;
    }

    public void insertarFinal(int numero, String palabra){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setNumero(numero);
        nuevoNodo.setPalabra(palabra);
        
        if(ListaVacia()){
        inicio = nuevoNodo;
        fin = nuevoNodo;
        fin.setSiguiente(inicio);
        
        } else {
        fin.setSiguiente(nuevoNodo);
        nuevoNodo.setSiguiente(inicio);
        fin = nuevoNodo;
        }
        
        tamaño++;
    }
    
    public void insertarReferencia(int referencia, int numero, String palabra){
    
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setNumero(numero);
        nuevoNodo.setPalabra(palabra);
        
        if(!ListaVacia()){
            if(buscar(referencia)){
                Nodo aux = inicio;
                while(aux.getNumero() != referencia){
                    aux = aux.getSiguiente();
                }
                
                if(aux == fin){
                    aux.setSiguiente(nuevoNodo);
                    nuevoNodo.setSiguiente(inicio);
                    fin = nuevoNodo;
                } else {
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevoNodo);
                    nuevoNodo.setSiguiente(siguiente);
                }
                tamaño++;
            }
        }
    }
    
    public void insertarPosicion(int posicion, int numero, String palabra){
       
        if(posicion >= 0 && posicion <= tamaño){
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.setNumero(numero);
            nuevoNodo.setPalabra(palabra);
            if(posicion == 0){
                nuevoNodo.setSiguiente(inicio);
                inicio = nuevoNodo;
                fin.setSiguiente(inicio);
            }
            else{
                if(posicion == tamaño){
                    fin.setSiguiente(nuevoNodo);
                    nuevoNodo.setSiguiente(inicio);
                    fin = nuevoNodo;     
                }
                else{
                    Nodo aux = inicio;
                    for (int i = 0; i < (posicion--); i++) {
                        aux = aux.getSiguiente();
                    }
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevoNodo);
                    nuevoNodo.setSiguiente(siguiente);
                }
            }
            tamaño++;
        }
    }
    
    public boolean buscar(int referencia){
        Nodo aux = inicio;
        boolean existe = false;
        
        do{
            if (referencia == aux.getNumero()){
                existe = true;
            } else {
                aux = aux.getSiguiente();
            }
        } while(aux != inicio && existe != true);
        
        return existe;
    }
    
    
    public int getNumero(int referencia) throws Exception{
        if (buscar(referencia)){
            Nodo aux = inicio;
            int contador = 0;
            
            while(referencia != aux.getNumero()){
            contador++;
            aux = aux.getSiguiente();
            }
           
            return contador;
        } else {
        throw new Exception("El número no existe dentro de la lista.");
        } 
    } 
    
    public int getPosicion(int referencia) throws Exception{
        if (buscar(referencia)) {
            Nodo aux = inicio;
            int contador = 0;
            
            while(referencia != aux.getNumero()){
                contador ++;
                aux = aux.getSiguiente();
            }
            return contador;
        } else {
            throw new Exception("El número no existe en la lista.");
        }
    }
    
    public void editarPorReferencia(int referencia, int numero, String palabra){
        if (buscar(referencia)) {
            Nodo aux = inicio;
            while(aux.getNumero()!= referencia){
                aux = aux.getSiguiente();
            }
            aux.setNumero(numero);
            aux.setPalabra(palabra);
        }
    }
    
    public void editarPorPosicion(int posicion , int numero, String palabra){
        if(posicion >=0 && posicion<tamaño){
            if(posicion == 0){
                inicio.setNumero(numero);
                inicio.setPalabra(palabra);
            }
            else{
                Nodo aux = inicio;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setNumero(numero);
                aux.setPalabra(palabra);
            }
        }
    }
    
    public void eliminarPorReferencia(int referencia){
        if (buscar(referencia)) {
            if (inicio.getNumero() == referencia) {
                inicio = inicio.getSiguiente();
                fin.setSiguiente(inicio); 
            } else{
                Nodo aux = inicio;
                while(aux.getSiguiente().getNumero()!= referencia){
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == fin) {
                    aux.setSiguiente(inicio);
                    fin = aux;
                } else {
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(siguiente.getSiguiente());  
                }
            }
            tamaño--;
        }
    }
    
    public void eliminarPorPosicion(int posicion){
        if(posicion>=0 && posicion<tamaño){
            if(posicion == 0){
                inicio = inicio.getSiguiente();
                fin.setSiguiente(inicio);
            }
            else{
                Nodo aux = inicio;
                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == fin) {
                    aux.setSiguiente(inicio);
                    fin = aux;
                } else {
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(siguiente.getSiguiente());  
                }
            }
            tamaño--;
        }
    }
    
    public void listar(){
        if (!ListaVacia()) {
            Nodo aux = inicio;
            int i = 0;
            do{
                System.out.println(i + ". [ " + aux.getNumero()+ " ] [ " + aux.getPalabra()+ " ]");
                aux = aux.getSiguiente();
                i++;
            }while(aux != inicio);
        }
    }
    
}
