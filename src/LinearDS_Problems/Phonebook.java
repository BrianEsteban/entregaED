package LinearDS_Problems;
import java.io.*;
import java.util.Scanner;

/*
# Contest Problem: Economic Phonebook
# //https://www.urionlinejudge.com.br/judge/en/problems/view/1211
*/

/**
 * Economic Phonebook nos pide comparar distintas lineas, cada una con un número entero de n cifras, mientras se repitan digitos 
 * de izquierda a derecha con el que está inmediatamente enseguida se van a contar como ahorro, y será este contador la respuesta final.
 * @author Brian Esteban Barreto Cardozo
 */
public class Phonebook 
{
    Node head = null;
    
    public static class Node 
    {
        int value;  //única información que tendrá el nodo
        Node next;  //apuntador

        /**
         * Constructor sin parámetros
         */
        public Node() {}

        /**
         * Constructor con el parámetro
         * @param value 
         */
        public Node(int value) {
            this.value = value;
        }

        /**
         * Visualización de nodo con el parámetro value
         * @return 
         */
        @Override
        public String toString() {
            return value + " ";
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
     * Imprime la información (menos la entera) de todos los nodos de la lista.
     */
    public void printList()
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        Node temp = head;
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
     * Inserta los nodos de manera ordenada, 
     * @param newNode 
     */    
    public void insertInOrder(Node newNode)
    {
        if (isEmpty())          //si la lista es vacía tan solo define al nuevo nodo como al cabeza
            head = newNode;
        else
        {
            Node temp = head;   //duplica a la cabeza
            while(temp.next != null && temp.next.value < newNode.value) //recorre mientras el siguiente no sea nulo y el nuevo nodo tenga un valor mayor al del nodo temporal
                temp = temp.next;
            
            if (temp.value > newNode.value)  //si el nuevo nodo tiene un valor menor al nodo temporal los enlaza y se define al nuevo nodo como la cabeza 
            {
                newNode.next = temp;
                head = newNode;
            }else                            //si el nuevo nodo tiene un valor mayor al nodo temporal los enlaza y se define al siguiente a temporal como la cabeza 
            {
                newNode.next = temp.next;
                temp.next = newNode; 
            }
        }    
    }
            
    /**
     * Tamaño de la lista
     * @return los cantidad de nodos que tiene la lista.
     */
    public int size()
    {
        int count = 1;                  //se declara al contadoe en uno
        if (isEmpty()) 
            return 0;                   //si la lista está vacía retorna un cero
        else
        {
            Node temp = head;
            while(temp.next != null)    //recorre la lista
            {
                count ++;               //va recorriendo los nodos y sumando uno cada que pasa por uno nuevo para obtener el total.
                temp = temp.next;   
            }
            return count;
        }
    }
        
    /**
     * Inserta un nuevo nodo al final de la lista
     * @param newNode 
     */
    public void insertAtEnd(Node newNode)
    {
        if (isEmpty())          //primero verifica si la lista está vacía
            head = newNode;     //si la condición fue verdadera designa como la cabeza al nuevo nodo que se va a añadir
        else
        {
            Node temp = head;           //Creación de un nodo temporal
            while(temp.next != null)    //si la lista tiene elementos deberá recorrerlos todos con el ciclo while
                temp = temp.next;       
                                       //en el momento en que el nodo temporal apunte a nulo saldrà del ciclo
            temp.next = newNode;       //el último nodo apunta al nuevo nodo
        }    
    }
    
    /**
     * Determina el digito de un número entero de un nodo en específico
     * @param cifra 
     * @param index
     * @return el número de la posición cifra en el arreglo.
     */
    public int get_element(int cifra, int index)
    {
        Node temp = head;   
        for (int i = 0; i < index; i++) //se llega al nodo indicado con el ciclo for teniendo como tope a index
            temp = temp.next;
        
        int digits = Integer.toString(temp.value).length(); //número de digitos que tiene el entero almacenado en el nodo temporal actual
        if (cifra >= digits)    //si la cifra excede a la cantidad de digitos no tiene sentido
            return 0;
        else
        {            
            int[] array = new int[digits];          //se crea el arreglo de dimensión del número de digitos
            int mod = (int) Math.pow(10,digits);    //mod será un 1 con tantos ceros como digitos que posteriomente se usará
            int div = (int) Math.pow(10,digits-1);  //div se usará para obtener la parte entera del valor del nodo temporal
            
            for (int i = 0; i < digits; i++)        //ciclo hasta el número de digitos
            {
                array[i] = (temp.value % mod) / div; //lo que se ingresará al arreglo sera la parte enterea del modulo del valor del nodo temporal 
                mod = mod/10;
                div = div/10;
            }
            return array[cifra];    
        }
    }
    
    /**
     * Compara los valores enteros de dos nodos.
     * @param list
     * @return 
     */
    public int comparation(Phonebook list)
    {
        Node temp = head;
        Node comp = head;
        int count = 0;
        int digits = Integer.toString(temp.value).length(); //número de digitos de un entero almacenado en temporal
        while(comp.next != null)    //recorre la lista
        {
            comp = comp.next;
            for (int i = 0; i < digits; i++) 
            {
                int a = list.get_element(i, index(temp.value)); //cada cifra del nodo temp es guardada en a
                int b = list.get_element(i, index(comp.value)); //cada cifra del nodo comp es guardada en b
                if (a == b)     //comapara a y b, si son iguales aumenta va aumentando el contador
                    count ++;
            }
        }
        return count;
    }
    
    /**
     * Posición en la lista del nodo que cotiene a value
     * @param value
     * @return la posicion en que esta el nodo
     */
    public int index(int value)
    {
        Node temp = head;
        int count = 0;
        
        while(temp.next != null && temp.value != value) //recorre la lista si el nodo temporal no contiene el valor que se pasó como parámetro.
        {
            count++;                                    //el contador aumenta cada que pasa por un nuevo nodo
            temp = temp.next;                           
        }
        return count;
    }
    
    /**
     * Ordenamiento de matrices
     * @param list
     * @return 
     */
    public Phonebook radixSort(Phonebook list)
    {
        Phonebook pbk = new Phonebook(); 
        for (int i = 0; i < 10; i++) 
        {
            int[] jars = new int[10];
            for (int j = 0; j < list.size()-1; j++) 
            {
                int element = list.get_element(j, i);
                jars[element] = jars[element] + j;
            }
            pbk.insertAtEnd(new Node(jars[i]));
        }
        return pbk;
    }
    

    /**
     * Prueba del ejercicio Economic Phonebook
     * @paramargs 
     */    
    public static void main(String[] args) throws IOException 
    {
        Phonebook pb = new Phonebook();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //lectura de la cantidad de números que se quieren escribir
        
        for (int i = 0; i < n; i++) 
        {   
            int digit = sc.nextInt();   //número entero que almacenará el nodo
            pb.insertInOrder(new Node(digit));  //inserta en la lista nodos en orden ascendente
        }
        
        System.out.println(pb.comparation(pb)); //imprime el número de digitos que se pueden ahorrar.

    }
    
}

/*
Entradas:
2
12345
12354

Respuesta:
3
*/