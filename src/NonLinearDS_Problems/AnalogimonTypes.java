package NonLinearDS_Problems;

import java.io.*;
import java.util.*;

/**
 * https://www.urionlinejudge.com.br/judge/en/problems/view/2562
 * @author Brian Esteban Barreto Cardozo
 */

class Node
{        
    int next;      
    int distance;
  
   /**
    * Costructor que instancia el nodo al que se apunta y la distancia entre nodos
    * @param next
    * @param distance 
    */
    public Node(int next, int distance) 
    {
        this.next = next;
        this.distance = distance;
    }
}
class Graph 
{
    int nodes;          //numero de nodos
    List<Node>[] link;  //lista de nodos
       
    /**
     * Constructor de la grafo que instancia el número de nodos y los enlaza
     * @param nodes 
     */
    public Graph(int nodes) 
    {          
        this.nodes = nodes;
        link = new ArrayList[nodes];    //crea una lista de la misma dimensión de nodos
            
        for (int i = 0; i < nodes; i++) //cada posición del arrayList es la cabeza de un nuevo arrayList
            link[i] = new ArrayList(); 
    }
       
    /**
     * Inserta un nodo en el grafo
     * @param nodo_inicio
     * @param next
     * @param distance 
     */
    public void insertNode(int node, int next, int distance) 
    {
        link[node].add(new Node(next, distance));   //enlaza en la posición de la lista de nodos a otro nodo con su respectiva distancia
    }
    
    /**
     * Arroja la lista de nodos enlazados con el nodo que se pasa por parámetro
     * @param nodo_inicio
     * @return 
     */
    public List<Node> adyacentes(int node) 
    {
        return link[node];
    }
    
    /**
     * Contador de la cantidad de elementos de una lista de adyacencia que puede tener valres que tambien tengan lista de adyacencia
     * @param n
     * @return 
     */
    public int countAnalogimon(int n)
    {
        int count = 0;
        List temp = adyacentes(n);
        for (int i = 0; i < temp.size(); i++) 
        {
            while(!adyacentes((int) temp.get(i)).isEmpty())
                count++;
        }
        return count;
    }
}

public class AnalogimonTypes 
{
    /**
     * Prueba del ejercicio Analogimon types con grafos sobre listas de adyacencia
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        
        String input = br.readLine();
        String[] data = input.split(" ");
        Graph g = new Graph(Integer.parseInt(data[0]));
        
        for (int i = 0; i < Integer.parseInt(data[1]); i++) 
        {
            input = br.readLine();
            String[] dat = input.split(" ");
            g.insertNode(Integer.parseInt(data[0]), Integer.parseInt(data[1]), 0);
        }
        
        int analogimon = sc.nextInt();
        System.out.println(g.countAnalogimon(analogimon));
    }
}


