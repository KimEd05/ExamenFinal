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
public class ExamenFinal {

    public static void main(String[] args) {
        ListaCircularSimple listaCircular = new ListaCircularSimple();
       
        System.out.println("--- Lista Circular Simple ---");
        
        listaCircular.insertarFinal(0, "Palabra 1");
        listaCircular.insertarFinal(1, "Prueba");
        listaCircular.insertarInicio(2, "Kimberly");
        listaCircular.insertarReferencia(0, 5, "Modificación");
        listaCircular.insertarPosicion(0, 0, "Aparecerá al inicio");
        listaCircular.listar();
        
        listaCircular.eliminarPorPosicion(0);
        listaCircular.listar();
    }
    
}
