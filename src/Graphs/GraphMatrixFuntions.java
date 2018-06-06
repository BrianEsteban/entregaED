package Graphs;

import java.io.*;

/**
 * Representación de un grafo por medio de la matriz de adyacencia, segmentado en métodos.
 * @author Brian Esteban Barreto Cardozo
 */
public class GraphMatrixFuntions 
{
    /**
     * Inicializa todas las posiciones de la matriz en cero
     * @param matrix
     * @param nodes 
     */
    public void initializeMatrix(int[][] matrix,int nodes)
    {
        for (int i = 0; i < nodes; i++)  
            for (int j = 0; j < nodes; j++) 
                matrix[i][j] = 0;
    }
    
    /**
     * Llena con unos las posiciones de la matriz que tienen dos números(nodos) enlazados
     * @param matrix
     * @param edges
     * @throws IOException 
     */
    public void fillMatrix(int[][] matrix, int edges) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= edges; i++) 
        {
            String input = br.readLine();       //se lee la linea de conexión entre dos nodos
            String[] data = input.split(" ");   //se dividen los dos nodos enlazados
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);
            matrix[x-1][y-1] = 1;           //enlace en doble dirección
            matrix[y-1][x-1] = 1;           //enlace en doble dirección
        }
    }
    
    /**
     * Imprime la matriz
     * @param matrix
     * @param nodes
     * @throws IOException 
     */
    public void printMatrix(int[][] matrix, int nodes) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < nodes; i++)
        {
            for (int j = 0; j < nodes; j++)
                bw.write(matrix[i][j] + " ");    
            
            bw.write("\n");
            bw.flush();
        }
    }
    
    /**
     * Prueba de la matriz simétrica que se debe imprimir según los nodos y las aristas
     * @param args
     * @throws IOException 
     */   
    public static void main(String[] args) throws IOException 
    {
        GraphMatrixFuntions graph = new GraphMatrixFuntions();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nodes = br.readLine();   //lectura del número de nodos
        String edges = br.readLine();   //lectura del números de aristas o enlaces 
        
        int matrix_adj [][] = new int[Integer.parseInt(nodes)][Integer.parseInt(nodes)];    //creación de la matriz cuadrada
        
        graph.initializeMatrix(matrix_adj, Integer.parseInt(nodes));    
        graph.fillMatrix(matrix_adj, Integer.parseInt(edges));
        graph.printMatrix(matrix_adj, Integer.parseInt(nodes));
       
    }
    
}
