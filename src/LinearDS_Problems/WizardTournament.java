package LinearDS_Problems;

import java.io.*;
import java.util.Scanner;

/**
 * El program del torneo de los magos consiste en seguir dos instrucciones clásicas en las filas, la primera instruccion es encolar
 * con la carateristica especial que los estudiantes de las escuelas queden agrupados, la segunda instruccion es desencolar común y corriente.
 * @author Brian Esteban Barreto Cardozo
 */
public class WizardTournament 
{
    Node head = null;
    
    public static class Node 
    {
        int school; 
        int number; 

        Node next;  //apuntador

        public Node(){}
        
        /**
         * Constructor con los parámetros school y number
         * @param school
         * @param number 
         */
        public Node(int school, int number) 
        {
            this.school = school;
            this.number = number;
        }

        @Override
        public String toString() {
            return school + " " + number;
        }
    }
    
    /**
     * Si la cabeza está vacía es por que la cola está vacía
     * @return verdadero si está vacía, falso si tiene al menos un elemente
     */
    public boolean isEmpty()
    {
        return head == null;
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
     * Prueba del ejercicio del torneo de los magos
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        WizardTournament student = new WizardTournament();  //se crea la fila student
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        
        int q = sc.nextInt();   //lectura de número de instrucciones
       
        for (int i = 0; i < q; i++)     //se hace un ciclo for que itere hasta el número de instrucciones indicado
        {
            String instruction = br.readLine();
            String[] data = instruction.split(" "); //se divide la instrucción por cada espacio que se deje en la cadena de caracteres con el metodo split()
            switch(data[0]) //el primer caracter dice cual es la instrucción
            {
                case "E":   //si es "E" encola un nuevo nodo con los datos que también son tomados de la cadena
                    Node st = new Node(Integer.parseInt(data[1]), Integer.parseInt(data[2]));   //el segundo y tercer caracter serán los dos parámetros del nodo (escuela y número)
                    student.enqueue(st);
                    break;
                case "D":   //si es "D" simplemente se llama a la función que desencola y se imprimen los datos que arroje
                    System.out.println(student.dequeue());
                    break;
                default:    
                    break;
            }       
        }
    }
}

/*
//Entradas:
5
E 1 1
E 2 1
E 1 2
D

D
//Respuesta:
1 1
1 2
*/