package LinearDS_Problems;

import java.io.*;
import java.util.Scanner;

/*
# Contest Problem: GoingToTheMarket
# https://www.urionlinejudge.com.br/judge/en/problems/view/1281
*/

/**
 * Going to the Market tiene como objetivo final hacer la cuenta total de los productos según su precio y cantidad.
 * Se utilizan listas para solucionar el problema.
 * @author Brian Esteban Barreto Cardozo
 */
public class Market 
{
    Node head = null;
    
    public static class Node 
    {
        String product_name;    //nombre del producto
        double price;           //precio del producto
        
        Node next;              //Apuntador

        public Node(){}

        /**
         * Constructor que inicializa la variable product_name y price
         * @param product_name
         * @param price 
         */
        public Node(String product_name, double price) 
        {
            this.product_name = product_name;
            this.price = price;
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
     * Inserta un nuevo nodo en una posición específica
     * @param newNode
     * @param index posición en la lista en la que se quiere insertar el nuevo nodo
     */
    public void insertAt(Node newNode, int index)
    {
        if (index == 0) //si es cero el índice se inserta al inicio
        {
            newNode.next = head;
            head = newNode;
        }
        else
        {
            Node temp = head;

            for (int i = 0; i < index-1; i++)  //conociendo la posición en la que se quiere insertar el nodo, se itera n veces
                temp = temp.next;           //recorre la lista deteniendose en la posición n
            
            newNode.next = temp.next;   //se apunta el nuevo nodo a un elemento de la lista que quedo luego de la iteración
            temp.next = newNode;        //se apunta al elemento de la lista al nuevo nodo. Se sigue ese orden para evitar la pérdida de información.
        }
    }
    
    /**
     * A partir del nombre del producto se obtiene el precio, 
     * @param name
     * @return el precio del producto dado su nombre
     */
    public double priceSearch(String name)
    {
        if (isEmpty()) 
            return 0;
        else
        {
            Node temp = head;
            try
            {
                while(!temp.product_name.equals(name) && temp.next != null) //mientras haya nodos y el nombre no coincida con alguno de los que anteriormente se insertaron, seguirá recorriendo
                    temp = temp.next;
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return temp.price;            
        }    
    }
    
    /**
     * , con un ciclo insertar en posiciones específicas los
     * nodos que tienen los parámetros de nombre y precio de los productos, enseguida se halla el precio de los productos que se 
     * comprarán con el método priceSearch y se multiplican por la cantidad, todo esto se va sumando para finalmente imprimir el total.
     * @param args 
     */
    public static void main(String[] args) throws IOException 
    {
        Market list = new Market();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();   //lectura del números de casos que se quiere corra el programa
        double total;
        
        while(cases > 0)    //mientras el número de casos sea mayor a cero se hará el proceso
        {
            total = 0;
            int products = sc.nextInt();    //lectura del número de productos
            for (int i = 0; i < products; i++) //itera tantas veces como productos haya
            {
                String name = sc.next();    //lectura del nombre del producto
                double price = sc.nextDouble();     //lectura del precio del producto
                Node product_i = new Node(name, price); //creación del nodo pasandole nombre y precio del producto
                list.insertAt(product_i, i);    //inserción del nodo a la lista
            }

            int shopping = sc.nextInt();    //lectura de productos comprados
                
            for (int i = 0; i < shopping; i++)  //itera tantas veces como productos se hayan comprado
            {
                String name = sc.next();    //lectura del nombre del producto
                int amount = sc.nextInt();  //lectura de la cantidad de cada producto comprado
                total += list.priceSearch(name) * amount;   //costo total de los productos comprados
            }       
           
            bw.write("R$ " + total + "\n"); //imprime el costo total
            bw.flush();
            cases--;
        }   
    }
}

/*
//Entradas:
2 
4 
mamao 2,19 
cebola 3,10 
tomate 2,80 
uva 2,73 
3 
mamao 2 
tomate 1 
uva 3 
5 
morango 6,70 
repolho 1,12 
brocolis 1,71 
tomate 2,80 
cebola 2,81 4 
brocolis 2 
tomate 1 
cebola 1 
morango 1

//Respuesta: 
R$ 15.37
R$ 15.73
*/