package NonLinearDS_Problems;

import java.io.*;
import Graphs.GraphListMap;

/**
 * Contest Problem: Ants Colony
 * //https://www.urionlinejudge.com.br/judge/problems/view/1135
 * @author Brian Esteban Barreto Cardozo
 */

public class AntsColony 
{
    /**
     * Prueba del ejercicio Ants colony.
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ianthills;  //hormigueros
        
        while( (ianthills = Integer.parseInt(br.readLine()) ) != 0) //lectura del número de hormigueros que mientras sea distinto a cero continua la ejecución
        {
            GraphListMap g = new GraphListMap(ianthills); //se le pasa el números de hormigueros como parámetro al grafo para hallar el camino más corto
            for (int i = 1; i < ianthills ; i++)
            {
                String input = br.readLine();
                String[] data = input.split(" ");   //se dividen las entradas, primero el hormiguero enlazado y segundo el peso que tiene el enlace que tomaremos como la longitud
                String vA = data[0];
                int Long = Integer.parseInt(data[1]);
                g.addNode(new GraphListMap.Node(String.valueOf(i), vA, Long)); //se agrega el nodo al grafo 
            }    
            
            int question = Integer.parseInt(br.readLine()); //lectura del número de consultas
            
            for (int j = 0; j < question; j++)  //itera tantas veces como consultas haya
            {
                String input = br.readLine();   
                String[] data = input.split(" ");   //se divide la entrada del nodo inicial y la del nodo final
                g.BFS(data[0]); //el inicial entra al proceso de buscar el mejor camino               
                if (j > 0)
                {
                    bw.write(" ");
                    bw.flush();
                    g.printPath(data[1]);   //camino más corto
                }
                else
                {
                    bw.write("\n");
                    bw.flush();
                    g.printPath(data[1]);   //camino más corto
                }
            }            
        } 
    }    
}

/*
Entradas:
6
0 8
1 7
1 9
0 3
4 2
4
2 3
5 2
1 4
0 3
2
0 1
2
1 0
0 1
6
0 1000000000
1 1000000000
2 1000000000
3 1000000000
4 1000000000
1
5 0
0
Respuesta:
16 20 11 17
1 1
5000000000
*/