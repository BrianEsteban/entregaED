package LinearDS_Problems;

import java.io.*;
import java.util.Scanner;

/**
 * https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/monk-and-order-of-phoenix/
 * @author Brian Esteban Barreto Cardozo
 */
public class Phoenix 
{
    Node head = null;
    
    public static class Node 
    {
        int height; //altura de los luchadores

        Node next;  //Apuntador

        public Node() {}

        /**
         * Costructor con el parámetro height
         * @param height 
         */
        public Node(int height) 
        {
            this.height = height;
        }

        @Override
        public String toString() {
            return height + " ";
        }
    }

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
     * Prueba del ejercicio Monk and Order of Phoenix
     * @param args 
     */
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n_stacks = sc.nextInt();    //lectura del número de pilas
        
        for (int i = 0; i < n_stacks; i++)  //Itera el número de pilas 
        {
            Phoenix stack = new Phoenix();
            int fighters  = sc.nextInt();   //lectura dl número de los peleadores
            
            for (int j = 0; j < fighters; j++) 
            {
                int heigth = sc.nextInt();      //lectura de las alturas de los peleadores
                stack.push(new Node(heigth));   //inserta a la pila correspondiente
            }
            stack.printStack();                 //prueba si se ingresaron 
            
            int n_instructions = sc.nextInt();  //instrucción 0: elimina, instrucción 1: agrega , instrucción 2: info 
            for (int j = 0; j < n_instructions; j++) 
            {
                int instruction = sc.nextInt();
                
                switch(instruction)
                {
                    case 0:
                        int eliminar = sc.nextInt();
                        if (i-1 == eliminar) 
                        {  
                            stack.pop();
                        }
                }
            }
        }
    }
}
