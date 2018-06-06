package LinearDataStructures;
import java.io.*;

/**
 * Implementación de los métodos de las pilas
 * @author Brian Esteban Barreto Cardozo
 */
public class Stack 
{
    Node head = null;
    
    /**
     * Verifica si la pila tiene elementos o no
     * @return false si la pila tiene elementos, de lo contrario true
     */
    public boolean isEmpty()
    {
        return head == null ? true : false;
    }
    
    /**
     * Imprime de la forma FILO(First Input, Last Output).
     */
    public void printStack()
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try
        {
            bw.write("Grades: \n");
            while(!isEmpty()) //Mientras la pila no sea vacía va imprimiendo la información de los nodos.
            {
                bw.write(pop()); //llamado del método pop
            }
            bw.flush();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Información del último nodo insertado. 
     * @return la información del nodo que esté designado como la cabeza.
     */
    public String peek()
    {
        Node temp = head;
        String info = temp.toString(); //Se guarda la información de nodo que oficia como cabeza.
        return info;    //Como en las pilas solo se puede acceder directamente al último elemento insertado, la información será del último nodo.
    } 
    
    /**
     * Insertar un nodo en la pila.
     * @param newNode 
     */
    public void push(Node newNode) 
    {
        newNode.next = head;  
        head = newNode;  //siguiendo los parámetros de las pilas, sólo se podrá insertar elementos al inicio, y este a su vez se convertirá en la cabeza.
    }
    
    /**
     * Eliminar un nodo de la pila.
     * @return la información del elemento eliminado.
     */
    public String pop()
    {
        Node temp = head;
        head = head.next;                //ahora la cabeza será al que esta estaba apuntando
        
        String info = temp.toString();  //Guarda información   
        temp = null;                    
        System.gc();                    //elimina el nodo
        return info;
    }
     
    /**
     * Prueba de los métodos con el ejemplo de las notas de un estudiante.
     * @param args 
     */
    public static void main(String[] args) throws IOException 
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack grades = new Stack();
        grades.push(new Node("Quiz 5: ",3.9));
        grades.push(new Node("Quiz 4: ",5.0));
        grades.push(new Node("Quiz 3: ",2.9));
        grades.push(new Node("Quiz 2: ",3.9));
        grades.push(new Node("Quiz 1: ",4.9));
        bw.write(grades.peek());
        bw.flush();
        grades.pop();
        grades.printStack();
    }
}
