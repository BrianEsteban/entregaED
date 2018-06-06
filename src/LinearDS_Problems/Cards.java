package LinearDS_Problems;

import java.io.*;
import java.util.*;


/*
# Contest Problem: ThrowingCardsAway
# https://www.urionlinejudge.com.br/judge/en/problems/view/1110
*/

/**
 * Throwing Cards Away consiste en tomar el mazo de una baraja ordenada de 1 a n, y la secuencia que sigue es: quitar el primer elemento,
 * luego quitar el segundo pero encolarlo inmediatamente a la lista, y así sucesivamente hasta que hayan menos de dos cartas. Lo que 
 * imprime es las cartas eliminadas antecedidas de la frase: "Discarded cards:" y también la carta que queda antecedida de la frase:
 * "Remaining cards:"
 * @author Brian Esteban Barreto Cardozo
 */
public class Cards 
{
    Node head = null;
    
    /**
     * Creación de la clase estática Node
     */
    public static class Node 
    {
        int value;  //Valor almacenado en el nodo
        Node next;  //apuntador
        
        /**
         * Costructor vacío
         */
        public Node(){}

        /**
         * Costructor con el parámetro
         * @param value 
         */
        public Node(int value) 
        {
            this.value = value;
        }
    }
    
    /**
     * Determina si la lista está vacia o no
     * @return verdadero si está vacía, falso si tiene al menos un elemento
     */
    public boolean isEmpty()
    {
        return head == null ? true : false;     //Verifica si existe el nodo de la cabeza
    }
    
    /**
     * Desencola o imprime el primer elemento ingresado.
     * @return la información guardada en info, o sea el elemento desencolado.
     */
    public int dequeue()
    {
        Node temp = head;       //se duplica la cabeza en temp
        head = head.next;       //la cabeza original toma un nuevo valor
        int info = temp.value;  //se guarda a la información de temp en esta variable para no perder información
        temp = null;            //se elimina a temp
        System.gc();             //se recoge lo que no sirve
        return info;

    }
     
    /**
     * Encolar es lo mismo que insertar un nodo al final
     * @param newNode 
     */
    public void enqueue(Node newNode) 
    {
        if (isEmpty())              //si la cola está vacia el nuevo nodo será la cabeza
            head = newNode;
        else
        {
            Node temp = head;
            while(temp.next != null) //recorre hasta que el apuntador de un nodo sea null y ahí se agrega el nuevo nodo
                temp = temp.next;
            
            temp.next = newNode;     //inserta al final
        }    
    }
    
    /**
     * Tamaño de la cola
     * @return la dimension de la cola
     */
    public int size()
    {
        int size = 0;           //contador inicializado en 0
        Node temp = head;
        while(temp != null)
        {
            temp = temp.next;   //cada vez que pasa por un nodo va aumentando el contador
            size ++;
        }   
        return size;
    }
    
    /**
     * Prueba del programa ThrowingCardsAway
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException 
    {
        Cards card = new Cards();
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n_cards = sc.nextInt();             //lectura por scanner del número de cartas
        
        while(n_cards != 0)
        {
            for(int i = 1; i <= n_cards; i++)   //ciclo for con el limite n_cards
                card.enqueue(new Node(i));      //se encolan los números enteros hasta ese n
            
            bw.write("Discarded cards: ");
            while(card.size() >= 2)             //mientras sea mayor a 1 el tamaño de la cola: desencola la primera, y la siguiente la desencola y la encola
            {
                bw.write(card.dequeue() + ", "); //se desencola la primera carta y es la que se imprime
                int deq_enq = card.dequeue();    //la segunda se desencola y posteriormente se vuelve a encolar
                Node enq = new Node(deq_enq);    
                card.enqueue(enq);
            }
            bw.write("\n" + "Remaining cards: " + card.dequeue() + "\n");   //desencola
            bw.flush();
            n_cards = sc.nextInt();
        }           
    }
}
/*
//Entradas: 7 19 10 6 0.
7 
Rspuesta: 
Discarded cards: 1, 3, 5, 7, 4, 2, 
Remaining cards: 6

19
Respuesta:
Discarded cards: 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 4, 8, 12, 16, 2, 10, 18, 14, 
Remaining cards: 6

10
Respuesta:
Discarded cards: 1, 3, 5, 7, 9, 2, 6, 10, 8, 
Remaining cards: 4

6
Respuesta
Discarded cards: 1, 3, 5, 2, 6, 
Remaining cards: 4

0
fin
*/