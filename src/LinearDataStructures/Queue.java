package LinearDataStructures;
import java.io.*;

/**
 * Implementación de los métodos tradicionales de las colas(queue)
 * @author Brian Esteban Barreto Cardozo
 */
public class Queue 
{
    Node head = null;
    
    /**
     * Verifica si está vacía la cola
     * @return verdadero si está vacía, falso si tiene al menos un elemento
     */
    public boolean isEmpty()
    {
        return head == null;    //Si la cabeza está vacía es por que la cola está vacía
    }
    
    /**
     * 
     */
    public void printQueue()
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;                   //se iguala a temp como la cabeza
        try
        {
            bw.write("Grades: \n");
            while(temp != null)             //Pregunta si el nodo temporal es nulo, si no es así sigue recorriendo e imprimiendo.
            {
                bw.write(temp.toString());  //Imprime los elementos que estén en la cola, manteniendo su identidad de que el primero que entra es el primero en imprimirse.
                temp = temp.next;
            }
            bw.flush();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Desencola o imprime el primer elemento ingresado entero.
     * @return la información guardada en info, o sea el elemento desencolado.
     */
    public int dequeueInt()
    {
        Node temp = head;        //se duplica la cabeza en temp
        head = head.next;        //la cabeza original toma un nuevo valor
        int info = temp.digit;   //se guarda a la información de temp en esta variable para no perder información
        temp = null;             //se elimina a temp
        System.gc();             //se recoge lo que no sirve
        return info;
    }
    
    /**
     * Desencola o imprime el primer elemento ingresado.
     * @return la información guardada en info, o sea el elemento desencolado.
     */
    public String dequeue()
    {
        if(isEmpty())                       //verifica con el método isEmpty si la cola está vacía
            return "vacia";
        else                                //si la cola tiene al menos un elemento
        {
            Node temp = head;               //se duplica la cabeza en temp
            head = head.next;               //la cabeza original toma un nuevo valor
            String info = temp.toString();  //se guarda a la información de temp en esta variable para no perder información
            temp = null;                    //se elimina a temp
            System.gc();                    //se recoge lo que no sirve
            return info;
        }
    }
     
    /**
     * Encolar es lo mismo que insertar un nodo al final
     * @param newNode 
     */
    public void enqueue(Node newNode) 
    {
        if (isEmpty())          //si la cola está vacia el nuevo nodo será la cabeza
            head = newNode;
        else
        {
            Node temp = head;
            while(temp.next != null)    //recorre hasta que el apuntador de un nodo sea null y ahí se agrega el nuevo nodo
                temp = temp.next;
            
            temp.next = newNode;        //inserta al final
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
     * Prueba de los métodos creados con nodos que tienen dos parámetros. 
     * @param args 
     */
    public static void main(String[] args) 
    {
        Queue grades = new Queue();
        grades.enqueue(new Node("Quiz 1: ",3.9));
        grades.enqueue(new Node("Quiz 2: ",5.0));
        grades.enqueue(new Node("Quiz 3: ",2.9));
        grades.enqueue(new Node("Quiz 4: ",3.9));
        grades.enqueue(new Node("Quiz 5: ",4.9));
        grades.printQueue();
        grades.dequeue();
        grades.dequeue();
        grades.printQueue();
    }
}
