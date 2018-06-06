package LinearDS_Problems;

import java.io.*;
import java.util.*;

/*
# Contest Problem: MonkAndOrderOfPhoenix
# https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/monk-and-order-of-phoenix/
*/

/**
 * El problema de la piedra filosofal se soluciona con pilas, pues nos dice que Harry y Monk tienen bolsas de la misma clase, de las 
 * cuales sólo tienen acceso a la última moneda que hayan agregado. "Harry" nos indica que Harry lanza a Monk un moneda, "Remove" nos 
 * indica que se elimina la última moneda insertada en el bolso de Monk. Cuando "x" sea igual a la suma del valor de todas las monedas 
 * se debe imprimir la cantidad de monedas en el bolso de Monk. 
 * @author Brian Esteban Barreto Cardozo
 */
public class PhilosopherStone 
{
    Node head = null;
     
    public static class Node
    {
        int value;
        Node next;

        public Node() {}

        /**
         * Constructor con el parámetro value
         * @param value 
         */
        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + " ";
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
    public int pop()
    {
        Node temp = head;
        head = head.next;        //ahora la cabeza será al que esta estaba apuntando
        
        int info = temp.value;   //Guarda información   
        temp = null;                    
        System.gc();             //elimina el nodo
        return info;
    }

    /**
     * Realiza un recorrido de la pila, realizando la suma total del valor que registre el nodo.
     * @return suma total
     */
    public int add()
    {
        if (isEmpty())  //si es vacía su suma es cero
            return 0;
        else
        {
            int sum = 0;
            Node temp = head;
            while(temp.next != null)    //recorre la lista
            {
                sum += temp.value;      //extrae la información entera del nodo y la va sumando nodo a nodo
                temp = temp.next;
            }
            sum += temp.value;          //adicionalmente suma el valor del nodo que no ingresa al ciclo
            return sum;
        }
    }
    
    /**
     * Prueba del ejercicio Monk and order of phoenix.
     * @param args 
     */
    public static void main(String[] args)
    {
        PhilosopherStone bagHarry = new PhilosopherStone(); //se crea la pila de Harry
        PhilosopherStone bagMonk = new PhilosopherStone();  //se crea la pila de Monk
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n_coins = sc.nextInt(); //lectura del número de monedas
        
        for (int i = 0; i < n_coins; i++) 
        {
            int value_coin = sc.nextInt();
            Node coins = new Node(value_coin);
            bagHarry.push(coins);   //se insertan el número de monedas en la pila de Harry
        }
        
        int n_instructions = sc.nextInt();  //lectura por consola del número de instrucciones
        int x = sc.nextInt();               //cuando duerme Monk
        int cantidad = 0;
        
        for (int i = 0; i < n_instructions; i++)
        {
            if(bagMonk.add() != x)  //mientras la suma de los valores de la pila de Monk sea distinta a lo que duerme Monk
            {
                String instruction = sc.next();
                if(instruction.equals("Harry")) //Harry: moneda de Harry a Monk.
                {
                    int coinHarry = bagHarry.pop(); //toma el valor de su último nodo insertado y posteriormente se inserta en la pila de Monk
                    Node coinMonk = new Node(coinHarry); 
                    bagMonk.push(coinMonk); //se inserta en la pila de Monk
                    cantidad++; //se aumenta la cantidad de monedas
                }
                else if (instruction.equals("Remove"))  //Remove: elimina moneda de Monk
                {
                    bagMonk.pop();  //se elimina el último elemento insertado en la pila de Monk 
                    cantidad--; //se desminuye en uno la cantidad
                }
            }else
            {
                break;
            }
        }
        System.out.println(cantidad); //se imprime la cantidad
    }
}

/*
//Entradas:
4
3 1 1 4
6 7
Harry
Harry
Harry
Remove
Remove
Harry
//Respuesta: 2
*/