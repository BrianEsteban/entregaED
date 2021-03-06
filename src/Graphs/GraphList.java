package Graphs;

import java.util.*;

/**
 * Reresentación de grafos con listas adyacentes
 * @author Brian Esteban Barreto Cardozo
 */

public class GraphList
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        Graph g = new Graph(nodes);
    }
}

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
}




