package Graphs;

import java.io.*;
import java.util.Scanner;

/**
 * Representación de grafos con matrices de adyacencia
 * @author Brian Esteban Barreto Cardozo
 */
public class GraphMatrixAdj 
{    
    private int n;
    private int[][] matrix;
    
    /**
     * Constructor con parámetro n
     * @param n numero de nodos
     */
    public GraphMatrixAdj(int n) 
    {
        this.n = n;
        matrix = new int[this.n][this.n];
        //initialize
        for(int i=0; i< n; i++)
        {
            for(int j=0; j< n; j++)
                matrix[i][j] = 0;  
        }
    }
    
    /**
     * Inserción reflejada en la matriz de adyacencia
     * @param i
     * @param j 
     */
    public void insert(int i, int j)
    {
        matrix[i][j] += 1;
    }
    
    /**
     * Eliminación o borrado de datos en la matriz de adyacencia
     * @param i
     * @param j 
     */
    public void delete(int i, int j)
    {
        if(matrix[i][j]>0)
            matrix[i][j] -= 1;
    }
    
    /**
     * Imprime la matriz de adyacencia
     */
    public void printMatrix()
    {
        for(int i = 0; i< n; i++)
        {
            for(int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + "  ");        
            
            System.out.println();
        }  
    }
    
    /**
     * Prueba de la matriz de adyacencia
     * @param args 
     * @throws java.io.IOException 
     */
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        GraphMatrixAdj g = new GraphMatrixAdj(n);
        
        for (int i = 0; i < n; i++) 
        {
            String input = br.readLine();
            String[] data = input.split(" ");
            
            for (int j = 0; j < data.length; j++) 
                g.insert(i, Integer.parseInt(data[j]));
        }
        g.printMatrix();     
    }
}


