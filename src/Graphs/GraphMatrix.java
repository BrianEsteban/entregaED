package Graphs;

import java.io.*;

/**
 * Representación de un grafo por medio de la matriz de adyacencia.
 * @author Brian Esteban Barreto Cardozo
 */
public class GraphMatrix 
{
    /**
     * Prueba de la matriz simétrica que se debe imprimir según los nodos y las aristas
     * @param args
     * @throws IOException 
     */   
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String nodes = br.readLine();   //lectura del número de nodos
        String edges = br.readLine();   //lectura del números de aristas o enlaces 
        
        int x,y;
        int matrix_adj [][] = new int[Integer.parseInt(nodes)][Integer.parseInt(nodes)];
        
        //inicialización de la matriz en cero
        for (int i = 0; i < Integer.parseInt(nodes); i++)  
            for (int j = 0; j < Integer.parseInt(nodes); j++) 
                matrix_adj[i][j] = 0;
                
        //se llena la matriz de adyacencia
        for (int i = 1; i <= Integer.parseInt(edges); i++) 
        {
            String input = br.readLine();       //se lee la linea de conexión entre dos nodos
            String[] data = input.split(" ");   //se dividen los dos nodos enlazados
            x = Integer.parseInt(data[0]);
            y = Integer.parseInt(data[1]);
            matrix_adj[x-1][y-1] = 1;           //enlace en doble dirección
            matrix_adj[y-1][x-1] = 1;           //enlace en doble dirección
        }
       
        //se imprime la matriz de adyacencia
        for (int i = 0; i < Integer.parseInt(nodes); i++)
        {
            for (int j = 0; j < Integer.parseInt(nodes); j++)
                bw.write(matrix_adj[i][j] + " ");    
            
            bw.write("\n");
            bw.flush();
        }
    }
}
