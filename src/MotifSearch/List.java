package MotifSearch;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 * Lista que utiliza el Main con los métodos meramente necesarios
 * @author Brian Esteban Barreto Cardozo
 */
public class List 
{
    Sequence head = null;
    
    /**
     * Determina si la lista está vacia o no
     * @return verdadero si está vacía, falso si tiene al menos un elemento
     */
    public boolean isEmpty()
    {
        return head == null ? true : false;     //Verifica si existe el nodo de la cabeza
    }
    
    /**
     * Imprime la información de todos los nodos de la lista.
     */
    public void printList()
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        Sequence temp = head;
        try
        {
            while(temp != null)            //recorre cada nodo para su posteior impresión mientras el siguiente nodo sea distinto de nulo
            {
                bw.write(temp.toString()); //Imprime la información que se haya depositado en el nodo. Para ello se hace un llamado a toString
                temp = temp.next;          //Avanza al siguiente nodo
            }
            bw.flush();                    //Necesario para que funcione el buffer
        }
        catch(Exception e)
        {
            e.printStackTrace();            
        }
    }
    
    /**
     * Inserta un nuevo nodo al final de la lista
     * @param newSequence 
     */
    public void insertAtEnd(Sequence newSequence)
    {
        if (isEmpty())          //primero verifica si la lista está vacía
            head = newSequence;     //si la condición fue verdadera designa como la cabeza al nuevo nodo que se va a añadir
        else
        {
            Sequence temp = head;           //Creación de un nodo temporal
            while(temp.next != null)    //si la lista tiene elementos deberá recorrerlos todos con el ciclo while
                temp = temp.next;       
                                       //en el momento en que el nodo temporal apunte a nulo saldrà del ciclo
            temp.next = newSequence;       //el último nodo apunta al nuevo nodo
        }    
    }
    
    public static void main(String[] args) {}
    
}