package LinearDS_Problems;

import java.io.*;
import java.util.Scanner;

/**
 * Contest Problem: https://www.urionlinejudge.com.br/judge/en/problems/view/1851
 * @author Brian Esteban Barreto Cardozo
 */
public class Dragon 
{
    Node head = null;
    
    public static class Node 
    {
        int days;   //dias
        int fine;   //multa por día 

        Node next;  //apuntador

        public Node() {}

        /**
         * Costructor que inicializa días y multa
         * @param days
         * @param fine 
         */
        public Node(int days, int fine) {
            this.days = days;
            this.fine = fine;
        }

        @Override
        public String toString() {
            return days + " " + fine + "\n";
        }
    }
    
    /**
     * Verifica si está o no vacía la lista
     * @return true si la lista está vacía y false de lo contrario
     */
    public boolean isEmpty()
    { 
        return head == null ? true : false;
    }
    
    /**
     * Inserta de manera ordenada los nodos según los días
     * @param newNode 
     */
    public void insert(Node newNode)
    {
        if (isEmpty())      //si es vacía el nuevo nodo oficiará como la cabeza
            head = newNode;
        else
        {
            Node temp = head;
            Node aux = temp;

            while(temp != null && newNode.days > temp.days) //mientras temporal sea distinto de nulo y los días del nuevo nodo sean mayores a los de temporal recorre
            {
                aux = temp;
                temp = temp.next;
            }

            newNode.next = temp;    //enlaza el nuevo nodo
            aux.next = newNode;     //se enlaza al nuevo nodo
        }
    }
        
    /**
     * La multa que se le genera por no entrenar a un Dragon
     * @return 
     */
    public int fine()
    {
        Node temp = head;
        int fine = 0;
        while(temp.next != null && temp.days > 0)   //si el nodo que está recorriendo tiene dias de entrenamiento mayor a cero
        {
            Node aux = temp;        //el nodo auxiliar es con el que se realiza el segundo recorrido
            int days = temp.days;   
            temp.days--;
            while(aux.next != null) //el segundo recorrido irá multiplicando la multa que tienen los que le siguen por el números de días sin atenderlos
            {
                aux = aux.next;
                fine += aux.fine * days;    //multa acumulada
            }
            temp = temp.next;
        }
        return fine;
    }
    
    /**
     * Prueba del ejercicio How to train your dragon
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Dragon list = new Dragon();
        String input = br.readLine();   //la entrada aceptada deberá contener dos enteros separados por un espacio
        int fineTotal = 0;
                
        while( !input.equalsIgnoreCase("") )    //si la entrada es nula termina la ejecución 
        {
            String[] data = input.split(" ");   //separa los enteros
            list.insert(new Node(Integer.parseInt(data[0]), Integer.parseInt(data[1]))); //inserta en la lista el nodo con los parámetros enteros
            fineTotal = list.fine();
            input = br.readLine();   
        }

        System.out.println(fineTotal);
     
    }
}
