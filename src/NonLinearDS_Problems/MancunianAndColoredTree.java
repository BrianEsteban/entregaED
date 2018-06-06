package NonLinearDS_Problems;

import java.io.*;
import java.util.Scanner;

/**
 * Contest Problem: https://www.hackerearth.com/practice/data-structures/trees/binary-and-nary-trees/practice-problems/algorithm/mancunian-and-colored-tree
 * @author Brian Esteban Barreto Cardozo
 */
public class MancunianAndColoredTree 
{    
    /**
     * Prueba del ejercicio pero con arreglos
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException 
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        
        int[] color = new int[10];      //arreglo definido para los colores 
        int[] storeNode = new int[11];  //arreglo definido para almacenar los 'nodos'       
        int parent;
        String input = br.readLine();
        String[] data = input.split(" ");
        int n = Integer.parseInt(data[0]);
        
        storeNode[1] = -1;  //se inicializa la primera posición porque el primer nodo nunca tendrá un ancestro o padre
        
        for (int i = 2; i <= n; i++)    //lectura de n nodos
            storeNode[i] = sc.nextInt();
            
        for (int i = 1; i <= n; i++)    //lectura de n+1 colores
            color[i] = sc.nextInt();
        
        for (int i = 1; i <= n; i++) 
        {
            parent = -1;                
            while(storeNode[i] != -1)   //mientras esté en una posición que no sea la primera entra al ciclo
            {
                if (color[storeNode[i]] == color[i]) //analiza si el nodo es igual al ancestro
                {
                    parent = storeNode[i];  //toma el valor correspondiente al nodo i
                    break;
                }
                storeNode[i] = storeNode[storeNode[i]];
            }
            bw.write(parent + " ");
            bw.flush();
        }
    }
}

/*
Entradas:
5 4
1 1 3 3
1 4 2 1 2

*/