/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

import java.util.Hashtable;

/**
 * Prueba clases en java
 * @author Brian Esteban Barreto Cardozo
 */
public class HashTableClassJava 
{
    /**
     * Prueba de la clase Hashtable de java.
     * @param args 
     */
    public static void main(String[] args) 
    {
        Hashtable<String,String> contenedor=new Hashtable<String,String>();
        
        contenedor.put("1", "Brian");
        contenedor.put("2", "Esteban");
        contenedor.put("3", "Barreto");
        contenedor.put("4", "Cardozo");
        
        System.out.println(contenedor.get("1") + " " + contenedor.get("3"));    //recupera info
        
    }
    
}
