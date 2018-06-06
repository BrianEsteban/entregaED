package Graphs;

import java.util.*;

/**
 * Implemetación de la búsqueda de anchura en un grafo.
 * @author Brian Esteban Barreto Cardozo
 */
public class GraphList 
{
    public Map<String, Vertex> graph;
    
    /**
     * Costructor del grafo con el parámetro entero
     * @param size 
     */
    public GraphList(int size) 
    {
        graph = new HashMap<>(size);
    }
    
    /**
     * Implementación del nodo
     */
    public static class Vertex implements Comparable<Vertex> 
    {
        String vertice;    //denominación en String
        Long weight;    //peso del enlace, con entero o con Long
        Vertex previous = null; //apuntador
        Map<Vertex, Integer> neighbours = new HashMap<>();  //creación de la colección HashMap para sus vecinos

        /**
         * Cosntructor que pasa como atributo al nombre
         * @param vertice 
         */
        public Vertex(String vertice) 
        {
            this.vertice = vertice;
        }

        /**
         * Imprime el peso del enlace destinado.
         */
        public void printPath() 
        {
            System.out.print(this.weight);
        }
        
        @Override
        public int compareTo(Vertex other) 
        {
            return Long.compare(weight, other.weight);
        }  
    }
    
    /**
     * Arista del grafo.
     */
    public static class Node 
    {
        String vertice1;  //primer vertice
        String vertice2;  //segundo vertice
        int weight; //peso del enlace
        
        /**
         * Costructor que pasa todos los parámetros.
         * @param vertice1
         * @param vertice2
         * @param weight 
         */
        public Node(String vertice1, String vertice2, int weight) 
        {
            this.vertice1 = vertice1;
            this.vertice2 = vertice2;
            this.weight = weight;
        }
    }
    
    /**
     * Imprimer el camino para llegar al nodo o vertice final 
     * @param end
     */
    public void printPath(String end) 
    {
        graph.get(end).printPath();
    }

    /**
     * Enlaza los vertices.
     * @param newNode 
     */
    public void addNode(Node newNode)
    {
        if (!graph.containsKey(newNode.vertice1))
            graph.put(newNode.vertice1, new Vertex(newNode.vertice1));  //se enlaza el primer vertice
        
        if (!graph.containsKey(newNode.vertice2))
            graph.put(newNode.vertice2, new Vertex(newNode.vertice2));  //se enlaza el segundo vertice
        
        graph.get(newNode.vertice1).neighbours.put(graph.get(newNode.vertice2), newNode.weight);
        graph.get(newNode.vertice2).neighbours.put(graph.get(newNode.vertice1), newNode.weight);
    }
    
    /**
     * Determina el vertice que luego hallará su camino mínimo 
     * @param start 
     */
    public void BFS(String start) 
    {
        Vertex source = graph.get(start);   //
        NavigableSet<Vertex> q = new TreeSet<>();   //creacíon de la colección ordenada TreeSet para iterar los valores del grafo
        
        for (Vertex v : graph.values()) 
        {
            v.previous = ( (v == source) ? source : null);      //se define al vertice anterior 
            v.weight = ( (v == source) ? 0l : Long.MAX_VALUE);  //se define su peso o longitud
            q.add(v);   //agrega el vertice  a la colección
        }
        BFS(q);
    }  
    
    /**
     * Determina el camino más corto dado un vértice inicial
     * @param q 
     */
    public void BFS(NavigableSet<Vertex> q)
    {
        Vertex u, v;
        while (!q.isEmpty())    //si tiene elementos realiza el proceso. También se podría implementar con filas 
        {
            u = q.pollFirst();  //retorna el primer elemento
            for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) //entrada a la colección con el vertice como llave y un valor entero itera hasta la cantidad de vecinos del vertice
            {
                v = a.getKey();
                Long alternateWeight = u.weight + a.getValue();
                
                if (alternateWeight < v.weight) 
                {
                    q.remove(v);
                    v.weight = alternateWeight;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

}
